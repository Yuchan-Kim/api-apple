package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.UserService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.UserVo;
import com.javaex.vo.unionVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserController {
	
	@Autowired		
	private UserService userService;
	
	
	/* 회원가입 */
	// http://localhost:3000/user/joinform
	@PostMapping("/api/users")
	public JsonResult userJoin(@RequestBody unionVo unionVo) {	
		// System.out.println("UserController.Userjoin()");
		// System.out.println(userVo);
		int count = userService.exeUserJoin(unionVo);
		
		if(count != 1) { 		//등록안됨
			return JsonResult.fail("회원등록에 실패했습니다.");
		}else { 				//등록됨
			return JsonResult.success(count);
		}
		
	}
	
	/* 아이디 중복체크 */
	@PostMapping("/api/users/{userId}")
	public JsonResult idCheck(@PathVariable(value="userId") String userId) {
		System.out.println("UserController.idCheck()");
		
		boolean can = userService.exeIdCheck(userId);
		
		if(can == false) { 		//등록안됨
			return JsonResult.fail("등록에 실패했습니다.");
		}else { 				//등록됨
			return JsonResult.success(can);
		}
		
	}
	
	
	/* 로그인 */
	// http://localhost:3000/user/loginform
	@PostMapping("/api/users/login")
	public JsonResult login(@RequestBody unionVo unionVo, HttpServletResponse response) {
		// System.out.println("UserController.login()");
		// System.out.println(userVo);
		unionVo authUser = userService.exeLogin(unionVo);	// id, password만 온다
		
		if(authUser != null ) { 	// 로그인됨		-> id, password  admin이면 관리자로 로그인됨
			JwtUtil.createTokenAndSetHeader(response, ""+authUser.getUserNum());
			System.out.println(authUser);
			return JsonResult.success(authUser);	// userNum, id, name만 온다
			
		}else { 				//로그인 안됨
			return JsonResult.fail("아이디 또는 비밀번호가 잘못되었습니다.");	
		}
		
	}
	
	
	/* 회원 마이페이지폼 */
	// http://localhost:3000/user/mypage
	@GetMapping("/api/users/me")
	public JsonResult userMypageForm(HttpServletRequest request) {
		// System.out.println("UserController.userMypageForm()");
		
		int userNum = JwtUtil.getNoFromHeader(request);
		// System.out.println(userNum);
		
		if (userNum != -1) {		// 토큰정상
			UserVo userVo = userService.exeMypageForm(userNum);	// userNum는 유저번호
			return JsonResult.success(userVo);
			
		} else {		// 토큰이 없거나(로그인상태아님), 변조된 경우
			return JsonResult.fail("토큰X, 비로그인, 변조");
			
		}
	}
	
	
	/* 회원정보수정 */
	@PutMapping("/api/users/me")
	public JsonResult userModify(HttpServletRequest request, @RequestBody unionVo unionVo) {
		// System.out.println("UserController.userModify()");
		
		// 화면에 있는 userVo 출력
		// System.out.println(unionVo);	// password, name, phoneNumber, address
		
		// 토큰사용해서 userNum값 출력
		int userNum = JwtUtil.getNoFromHeader(request);
		
		if(userNum != -1) {		// 토큰이 정상일때
			unionVo.setUserNum(userNum);
			int count = userService.exeUserModify(unionVo);	// userNum, password, name, phoneNumber, address
			// System.out.println(count);
			
			if(count == 1) {	// 정상적으로 수정되었을때
				unionVo.setUserPw(null);	// 로그인할때 토큰에 이름이랑 userNum만 저장하기때매
				unionVo.setUserHp(null);		// 불필요한걸 지워서 저장시키기위해 두개만 보냄
				unionVo.setUserAddress(null);	
				return JsonResult.success(unionVo);
				
			}else {			// 비정상적으로 수정되었을때
				return JsonResult.fail("수정오류, 수정실패");
				
			}
			
		}else {		// 토큰이 비정상일때
			return JsonResult.fail("토큰X, 비로그인, 변조");
			
		}
	}
	
	
	/* 마이페이지 구매내역 폼 */
	@GetMapping("/api/purchaselist")
	public JsonResult purchaseList(HttpServletRequest request) {// 토큰에서 꺼낸다
		System.out.println("UserInfoController.purchaseList()");

		// 로그인한 session 값을 객체로 가져오기
		int userNum = JwtUtil.getNoFromHeader(request);

		// 회원의 세션번호로 구매내역 불러오기
		// 한사람이 여러개를 사면 결과값이 1개 이상이므로
		UserVo userVo = userService.exeUserPurchase(userNum);
		System.out.println("userNum"+userNum);
		System.out.println("userVo"+userVo);
		return JsonResult.success(userVo);
	
	}
	

}
