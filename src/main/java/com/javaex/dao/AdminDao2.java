package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.StoreVo;
import com.javaex.vo.unionVo;

@Repository
public class AdminDao2 {

	@Autowired
	private SqlSession sqlSession;

	public int deleteStore(StoreVo storeVo) {
		System.out.println("AdminDao.deleteStore()");

		int count = sqlSession.update("admin.storeDelete", storeVo);

		return count;
	}

	// 유저 삭제
	public int deleteUser(unionVo unionVo) {
		System.out.println("AdminDao.deleteUser()");

		int count = sqlSession.update("admin.userDelete", unionVo);

		return count;
	}

	// delivery
	public List<unionVo> deliverySelectList() {
		System.out.println("AdminDao.deliverySelectList()");

		List<unionVo> deliveryList = sqlSession.selectList("admin.deliverySelectList");

		return deliveryList;
	}

	// 배송중으로 변환
	public int productSend(unionVo unionVo) {
		System.out.println("AdminDao.productSend()");

		int count = sqlSession.update("admin.productSend", unionVo);

		return count;
	}

	// 베송 완료로 변환
	public int productArrived(unionVo unionVo) {
		System.out.println("AdminDao.productArrived()");

		int count = sqlSession.update("admin.productArrived", unionVo);

		return count;
	}

	// history
	public List<unionVo> historySelectList() {
		System.out.println("AdminDao.historySelectList()");

		List<unionVo> historyList = sqlSession.selectList("admin.historySelectList");

		return historyList;
	}

	public List<unionVo> productSelectList() {
		System.out.println("AdminDao.productSelectList()");

		List<unionVo> productList = sqlSession.selectList("admin.productSelectList");

		return productList;
	}

}
