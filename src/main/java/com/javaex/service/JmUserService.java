package com.javaex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaex.dao.JmUserDao;
import com.javaex.vo.unionVo;

@Service
public class JmUserService {

	@Autowired
	private JmUserDao dao;

	

	// 회원no로 어드레스 가져오기
	public unionVo exeUserAddress(int userId) {

		unionVo authUser = dao.userAddress(userId);
		System.out.println("Service  주소 가져와" + authUser);
		System.out.println(authUser);

		return authUser;
	}

	// 회원no로 카트리스트 가져오기
	public List<unionVo> exeCartform(int userId) {
		System.out.println("JmUserService.exeCartform");

		List<unionVo> cList = dao.userCartList(userId);
		System.out.println("JmUserService" + cList);

		return cList;
	}

	// 카트 상품 삭제
	public int exeDeleteCart(int cartNum) {
		System.out.println("JmUserService.exePersonDelete()");

		int count = dao.deleteCart(cartNum);

		return count;
	}

	// 장바구니 추가
	public int exeaddToCart(unionVo unionvo) {
		
		//해당 유저 장바구니에 같은 상품이 있는지 체크
		int existingCount = dao.checkCartItemExists(unionvo);
		System.out.println("wkkdkwkdkwkdkwkfakfkasfksad");
		if (existingCount != 0) {
			// 이미 존재하는 경우 업데이트
			dao.updateCartItemCount(unionvo);
			System.out.println("상품 있음 수량+1");
		} else {
			// 존재하지 않는 경우 새로 삽입
			dao.insertCartItem(unionvo);
			System.out.println("장바구니에 추가+1");
		}
		return existingCount;
	}

	// 장바구니 수량 변경
	public int exeupdateCartCount(unionVo unionvo) {
		return dao.updateCartCount(unionvo);
	}

	// 악세사리 리스트 가져오기
	public List<unionVo> exeCartformAcce() {
		System.out.println("JmUserService.exeCartformAcce");

		List<unionVo> aList = dao.acceList();
		System.out.println("JmUserService 악세사리" + aList);

		return aList;
	}

	// 스토어 리스트 가져오기
	public List<unionVo> exeStoreList() {
		System.out.println("JmUserService.exeStoreList");

		List<unionVo> sList = dao.storeList();
		System.out.println("JmUserService" + sList);

		return sList;
	}

	// 배송 영수증 추가 + 히스토리에 영수증 정보 추가 + 장바구니 비우기
	public int exedeliveryInsert(unionVo unionvo) {
		
		// 1. 카트에서 삭제하기 전에 유저의 장바구니 목록을 가져옴
		List<unionVo> cartItems = dao.userCartList2(unionvo.getUserNum());
		System.out.println("히스토리에 넣을 장바구니 정보" + cartItems);

		// 2. 영수증을 인서트함
		int deliveryInsertCount = dao.deliveryInsert(unionvo);

		// 3. 방금 생성된 영수증 번호를 가져옴
		int receiptNum = dao.getLastReceiptNum(unionvo.getUserNum());
		System.out.println("생성된 영수증 번호" + receiptNum);

		// 4. 가져온 장바구니 목록을 이용하여 History 테이블에 인서트
		for (unionVo item : cartItems) {
			item.setReceiptNum(receiptNum); // 영수증 번호 설정
			dao.insertHistory(item); // History 테이블에 삽입
		}

		// 5. History에 삽입 후 장바구니 비우기
		int cartDeleteCount = dao.deleteAllCart(unionvo);

		return deliveryInsertCount;
	}

	// 픽업 영수증 추가 + 히스토리에 영수증 정보 추가 + 장바구니 비우기
	public int exePickupInsert(unionVo unionvo) {
		// 1. 카트에서 삭제하기 전에 유저의 장바구니 목록을 가져옴
		List<unionVo> cartItems = dao.userCartList2(unionvo.getUserNum());
		System.out.println("히스토리에 넣을 장바구니 정보" + cartItems);

		// 2. 영수증을 인서트함
		int deliveryInsertCount = dao.pickupInsert(unionvo);

		// 3. 방금 생성된 영수증 번호를 가져옴
		int receiptNum = dao.getLastReceiptNum(unionvo.getUserNum());
		System.out.println("생성된 영수증 번호" + receiptNum);

		// 4. 가져온 장바구니 목록을 이용하여 History 테이블에 인서트
		for (unionVo item : cartItems) {
			item.setReceiptNum(receiptNum); // 영수증 번호 설정
			dao.insertHistory(item); // History 테이블에 삽입
		}

		// 5. History에 삽입 후 장바구니 비우기
		int cartDeleteCount = dao.deleteAllCart(unionvo);

		return deliveryInsertCount;
	}

	// 회원no로 히스토리에서 구매 정보 가져오기
	public List<unionVo> exehistoryList(int userId) {
		System.out.println("JmUserService.exeCartform");
		System.out.println(userId);

		List<unionVo> hList = dao.historyList(userId);
		System.out.println("JmUserService 결제완료" + hList);

		return hList;
	}

	// 관심상품 장바구니에 담고 관심리스트 비우기
	public int exeaaddToCartAndDel(unionVo unionvo) {
		
		//해당 유저 장바구니에 같은 상품이 있는지 체크
		int existingCount = dao.checkCartItemExists(unionvo);
		System.out.println("wkkdkwkdkwkdkwkfakfkasfksad");
		
		if (existingCount != 0) {
			// 이미 존재하는 경우 업데이트
			dao.updateCartItemCount(unionvo);
			System.out.println("상품 있음 수량+1");
		} else {
			// 존재하지 않는 경우 새로 삽입
			dao.insertCartItem(unionvo);
			System.out.println("장바구니에 추가+1");
		}
		//장바구니 인서트 후 관심상품 리스트 전체 삭제
		int cartDeleteCount = dao.deleteWish(unionvo);
		
		return existingCount;
	}

}
