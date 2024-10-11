package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.MyProductVo;
import com.javaex.vo.UserVo;
import com.javaex.vo.unionVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	
	/* 회원가입 */
	public int exeUserJoin(unionVo unionVo) {	 
		// System.out.println("UserService.exeUserJoin()");
		
		int count = userDao.insertUser(unionVo);
		
		return count;
		
	}
	
	/* 아이디 중복체크  */
	public boolean exeIdCheck(String userId) {
		System.out.println("UserService.exeIdCheck()");

		int count = userDao.selectUserById(userId);
		
		if(count >= 1) {
			return false;		// 이미 가입된 아이디 가입불가능
		}else {
			return true;		// 없는 아이디 가입가능
		}
		
	}
	
	
	
	/* 로그인 */
	public unionVo exeLogin(unionVo unionVo) {
		// System.out.println("UserService.exeLogin()");
		
		unionVo authUser =userDao.selectUser(unionVo);
		
		return authUser;
	}
	
	
	/* 회원 마이페이지폼 */
	public UserVo exeMypageForm(int userNum) {
		// System.out.println("UserService.exeMypageForm()");

		UserVo userVo = userDao.userSelectOneByNum(userNum);
		
	    // 구매 내역과 관심 목록을 가져옴
		List<MyProductVo> purchaseList = userDao.selectPurchaseProduct(userNum);
	    List<unionVo> likeList = userDao.selectlikedProduct(userNum);
	    // System.out.println("likeList"+likeList);

	    // unionVo에 구매 내역과 관심 목록을 설정
	    userVo.setPurchaseList(purchaseList);
	    userVo.setLikeList(likeList);
	    
		return userVo;
	}
	
	
	/* 회원 수정 */
	public int exeUserModify(unionVo unionVo) {
		// System.out.println("UserService.exeUserModify()");

		int count = userDao.userUpdate(unionVo);
		return count;
	}
	
	
	/* 마이페이지 구매내역 */
	public UserVo exeUserPurchase(int userNum) {
		System.out.println("UserInfoService.exeUserPurchase()");

		UserVo userVo = userDao.userSelectByNum(userNum);
		List<MyProductVo> purchaseList = userDao.selectPurchase(userNum);
		userVo.setPurchaseList(purchaseList);
		
		System.out.println("userVo"+userVo);

		return userVo;

	}
	
}
