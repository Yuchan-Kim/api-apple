package com.javaex.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.unionVo;

@Repository
public class JmUserDao {

	@Autowired
	private SqlSession session;

	

	// 회원no로 어드레스 가져오기
	public unionVo userAddress(int userId) {

		unionVo authUser = session.selectOne("jmuser.getUserAddressByUserNum", userId);
		System.out.println("Dao  주소 가져와" + authUser);
		System.out.println(authUser);

		return authUser;
	}

	// 회원no로 카트리스트 가져오기
	public List<unionVo> userCartList(int userId) {
		System.out.println("UserDao.userSelectOneByNo");

		// List<unionVo> cList = session.selectList("jmuser.selectList", userId); // 유저
		// ID로 장바구니 조회 쿼리 실행
		List<unionVo> cList = session.selectList("jmuser.cartList", userId);
		System.out.println("JmUserDao" + cList);
		return cList;
	}

	// 카트 상품 삭제
	public int deleteCart(int cartNum) {
		System.out.println("UserDao.deleteCart");

		int count = session.delete("jmuser.deleteOne", cartNum);
		return count;
	}

	// 카트 전체 상품 삭제
	public int deleteAllCart(unionVo unionvo) {
		System.out.println("UserDao.deleteAllCart");
		System.out.println(unionvo);

		int count = session.delete("jmuser.deleteAll", unionvo);
		return count;
	}

	// 관심상품 전체 삭제
	public int deleteWish(unionVo unionvo) {
		System.out.println("UserDao.deleteCart");

		int count = session.delete("jmuser.wishDeleteAll", unionvo);
		return count;
	}

	// ----------- 장바구니 추가 ----------------//

	// 장바구니에 같은 상품이 있는지 확인
	public int checkCartItemExists(unionVo unionvo) {
		Integer count = session.selectOne("jmuser.checkCartItemExists", unionvo);
		int itemCount = (count != null) ? count : 0;
		return itemCount;
	}

	// 같은 상품이 있을경우 카운트만 업데이트
	public int updateCartItemCount(unionVo unionvo) {
		return session.update("jmuser.updateCartItemCount", unionvo);
	}

	// 같은 상품이 없으면 인서트
	public int insertCartItem(unionVo unionvo) {
		return session.insert("jmuser.insertCartItem", unionvo);
	}

	// ----------- 장바구니 추가 ----------------//

	// 영수증 최신 번호 받기
	public int getLastReceiptNum(int userNum) {
		return session.selectOne("jmuser.getLastReceiptNum", userNum);
	}

	// 회원no로 카트리스트 가져오기
	public List<unionVo> userCartList2(int userId) {
		System.out.println("UserDao.userSelectOneByNo");

		// List<unionVo> cList = session.selectList("jmuser.selectList", userId); // 유저
		// ID로 장바구니 조회 쿼리 실행
		List<unionVo> cList = session.selectList("jmuser.getCartItemsByUser", userId);
		System.out.println("JmUserDao" + cList);
		return cList;
	}

	// 히스토리 인서트
	public int insertHistory(unionVo historyVo) {
		return session.insert("jmuser.insertHistory", historyVo);
	}

	// 수량 변경
	public int updateCartCount(unionVo unionvo) {
		return session.update("jmuser.updateCartCount", unionvo);
	}

	// 악세사리 리스트 가져오기
	public List<unionVo> acceList() {
		System.out.println("UserDao.acceList");

		List<unionVo> aList = session.selectList("jmuser.acceList");
		System.out.println("JmUserDao 악세사리" + aList);
		return aList;
	}

	// 스토어 리스트 가져오기
	public List<unionVo> storeList() {
		System.out.println("UserDao.storeList");

		List<unionVo> sList = session.selectList("jmuser.storeList");
		System.out.println("JmUserDao" + sList);
		return sList;
	}

	// 배송 영수증 추가
	public int deliveryInsert(unionVo unionvo) {
		return session.insert("jmuser.deliveryInsert", unionvo);
	}

	// 픽업 영수증 추가
	public int pickupInsert(unionVo unionvo) {
		return session.insert("jmuser.pickupInsert", unionvo);
	}

	// 회원no로 히스토리에서 구매 정보 가져오기
	public List<unionVo> historyList(int userId) {
		System.out.println("UserDao.historyList");
		System.out.println(userId);

		List<unionVo> hList = session.selectList("jmuser.receiptList", userId);
		System.out.println("JmUserDao 결제완료" + hList);
		return hList;
	}

}
