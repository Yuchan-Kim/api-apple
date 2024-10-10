package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.JmUserService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.unionVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JmUserConteroller {

	@Autowired
	private JmUserService service;

	

	// 회원 번호로 주소 가져오기
	@GetMapping("/api/user/address")
	public JsonResult getUserAddress(HttpServletRequest request) {
		System.out.println(request);
		// JwtUtil에서 유저 ID를 추출 (int 대신 Integer 사용)
		Integer userId = JwtUtil.getNoFromHeader(request);

		// 유저 ID가 null이 아닌 경우 주소를 조회
		if (userId != -1) {
			unionVo authUser = service.exeUserAddress(userId); // 주소 데이터를 가져옴
			System.out.println("@@@@@@@@@@@@@@@@@" + authUser);
			return JsonResult.success(authUser); // 성공적으로 가져온 주소 데이터를 반환
		} else {
			return JsonResult.fail("주소를 찾을 수 없습니다.");
		}
	}

	// 장바구니 폼 회원no로 카트리스트 가져오기
	@GetMapping("api/user/cart")
	public JsonResult cartform(HttpServletRequest request) {
		System.out.println("JmUserConteroller-shoppingcart");

		int userId = JwtUtil.getNoFromHeader(request);

		if (userId != -1) {
			List<unionVo> cList = service.exeCartform(userId);
			System.out.println("JmUserConteroller" + cList);
			return JsonResult.success(cList);
		} else {
			return JsonResult.fail("토큰x");
		}
	}

	// 카트 상품 삭제
	@DeleteMapping("api/user/cart/{cartNum}")
	public JsonResult deleteCart(@PathVariable("cartNum") int cartNum) {
		System.out.println("JmUserController-deleteCart");
		System.out.println(cartNum);

		int count = service.exeDeleteCart(cartNum);
		if (count != 1) {
			return JsonResult.success(count); // 삭제 실패 시
		} else {
			return JsonResult.success(count); // 삭제 성공 시
		}
	}

	// 장바구니에 담기
	@PostMapping("api/user/cart")
	public JsonResult addToCart(@RequestBody unionVo unionvo, HttpServletRequest request) {
		// 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
		int userNum = JwtUtil.getNoFromHeader(request);
		// cartItemVo에 유저 정보 추가
		unionvo.setUserNum(userNum);
		System.out.println("장바구니 정보" + unionvo);

		// 서비스 호출하여 장바구니에 아이템 추가
		int count = service.exeaddToCart(unionvo);

		if (count > 0) {
			return JsonResult.success("장바구니에 추가되었습니다.");
		} else {
			return JsonResult.fail("장바구니 추가 실패");
		}
	}

	// 장바구니 수량 변경
	@PostMapping("api/user/cart/update")
	public JsonResult updateCartCount(@RequestBody unionVo unionvo, HttpServletRequest request) {
		System.out.println("수량변경 test");
		int updatedCount = 0;
		// 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
		int userNum = JwtUtil.getNoFromHeader(request);
		unionvo.setUserNum(userNum);
		System.out.println("수랑변경 test" + unionvo);

		updatedCount += service.exeupdateCartCount(unionvo);

		if (updatedCount > 0) {
			return JsonResult.success("수량 업데이트 성공");
		} else {
			return JsonResult.fail("수량 업데이트 실패");
		}
	}

	// 악세사리 리스트 가져오기
	@GetMapping("api/user/cartAcce")
	public JsonResult cartformAcce(HttpServletRequest request) {
		System.out.println("JmUserConteroller-cartformAcce");

		int userId = JwtUtil.getNoFromHeader(request);

		if (userId != -1) {
			List<unionVo> aList = service.exeCartformAcce();
			System.out.println("JmUserConteroller 악세사리" + aList);
			return JsonResult.success(aList);
		} else {
			return JsonResult.fail("토큰x");
		}
	}

	// 스토어 리스트 가져오기
	@GetMapping("api/user/storelist")
	public JsonResult storeList(HttpServletRequest request) {
		System.out.println("JmUserConteroller-storeList");

		int userId = JwtUtil.getNoFromHeader(request);

		if (userId != -1) {
			List<unionVo> sList = service.exeStoreList();
			System.out.println("JmUserConteroller######" + sList);
			return JsonResult.success(sList);
		} else {
			return JsonResult.fail("토큰x");
		}
	}

	// 배송 영수증 추가
	@PostMapping("api/delivery")
	public JsonResult deliveryInsert(@RequestBody unionVo unionvo, HttpServletRequest request) {
		// 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
		int userNum = JwtUtil.getNoFromHeader(request);
		// unionvo에 유저 정보 추가
		unionvo.setUserNum(userNum);
		System.out.println("장바구니 정보" + unionvo);

		// 서비스 호출하여 영수증에 정보 추가
		int count = service.exedeliveryInsert(unionvo);

		if (count > 0) {
			return JsonResult.success("결제 완료.");
		} else {
			return JsonResult.fail("결제 실패.");
		}
	}

	// 픽업 영수증 추가
	@PostMapping("api/pickup")
	public JsonResult pickupInsert(@RequestBody unionVo unionvo, HttpServletRequest request) {
		// 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
		int userNum = JwtUtil.getNoFromHeader(request);
		// unionvo에 유저 정보 추가
		unionvo.setUserNum(userNum);
		System.out.println("픽업 정보" + unionvo);

		// 서비스 호출하여 영수증에 정보 추가
		int count = service.exePickupInsert(unionvo);

		if (count > 0) {
			return JsonResult.success("결제 완료.");
		} else {
			return JsonResult.fail("결제 실패.");
		}
	}

	// 결제 완료폼 히스토리에서 구매 정보 가져오기
	@GetMapping("api/user/payok")
	public JsonResult historyList(HttpServletRequest request) {
		System.out.println("JmUserConteroller-historyList");

		int userId = JwtUtil.getNoFromHeader(request);
		System.out.println(userId);

		if (userId != -1) {
			List<unionVo> hList = service.exehistoryList(userId);
			System.out.println("JmUserConteroller 결제완료" + hList);
			return JsonResult.success(hList);
		} else {
			return JsonResult.fail("토큰x");
		}
	}

	// 관심상품 장바구니에 담고 관심리스트 비우기
	@PostMapping("api/user/wishtocart")
	public JsonResult addToCartAndDel(@RequestBody unionVo unionvo, HttpServletRequest request) {
		// 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
		int userNum = JwtUtil.getNoFromHeader(request);
		// cartItemVo에 유저 정보 추가
		unionvo.setUserNum(userNum);
		System.out.println("장바구니 정보" + unionvo);

		// 서비스 호출하여 장바구니에 아이템 추가
		int count = service.exeaaddToCartAndDel(unionvo);

		if (count > 0) {
			return JsonResult.success("장바구니에 추가되었습니다.");
		} else {
			return JsonResult.fail("장바구니 추가 실패");
		}
	}

}
