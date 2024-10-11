package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MyProductVo;
import com.javaex.vo.UserVo;
import com.javaex.vo.unionVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	
	/* 회원가입 */
	public int insertUser(unionVo unionVo) {
		// System.out.println("UserDao.insertUser()");
		
		int count = sqlSession.insert("user.insert", unionVo);
		
		return count;
		
	}
	
	/* 아이디 중복체크 */
	public int selectUserById(String userId) {
		System.out.println("UserDao.selectUserById()");
		
		int count = sqlSession.selectOne("user.selectById", userId);
		System.out.println(count);
		
		return count;
		
	}
	
	/* 로그인 */
	public unionVo selectUser(unionVo unionVo) {
		// System.out.println("UserDao.selectUser()");
		
		unionVo authUser = sqlSession.selectOne("user.selectByIdPw", unionVo);
		return authUser;
	}
	
	
	/* 회원 마이페이지폼 */
	public UserVo userSelectOneByNum(int userNum) {
		// System.out.println("UserDao.userSelectOneByNum()");

		UserVo userVo = sqlSession.selectOne("user.userSelectOneByNum", userNum);
		return userVo;
	}
	
	/* 마이페이지폼 관심 */
	public List<unionVo> selectlikedProduct(int userNum) {
		System.out.println("userNum"+userNum);

		List<unionVo> likeList = sqlSession.selectList("user.selectlikedProduct", userNum);
		// System.out.println("likeList"+likeList);
		
		return likeList;
	}
	
	/* 마이페이지폼 구매 */
	public List<MyProductVo> selectPurchaseProduct(int userNum) {
		System.out.println("userNum"+userNum);

		List<MyProductVo> purchaseList = sqlSession.selectList("user.selectPurchaseProduct", userNum);
		// System.out.println(purchaseList);
		
		return purchaseList;
	}
	
	
	/* 회원 수정 */
	public int userUpdate(unionVo unionVo) {
		// System.out.println("UserDao.userUpdate()");

		int count = sqlSession.update("user.userUpdate", unionVo);
		return count;
	}
	
	
	/* 마이페이지 구매내역 */
	public List<MyProductVo> selectPurchase(int userNum) {
		System.out.println("userNum"+userNum);

		List<MyProductVo> purchaseList = sqlSession.selectList("user.selectPurchase", userNum);
		// System.out.println(purchaseList);
		
		return purchaseList;
	}
	
	/* 구매에서 내정보가져오기 */
	public UserVo userSelectByNum(int userNum) {
		// System.out.println("UserDao.userSelectOneByNum()");

		UserVo userVo = sqlSession.selectOne("user.userSelectByNum", userNum);
		return userVo;
	}
	
}
