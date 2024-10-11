package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CommunityDao;
import com.javaex.vo.CommentVo;
import com.javaex.vo.CommunityVo;

@Service
public class CommunityService {
	@Autowired
	private CommunityDao communityDao;
	
	
	/* 커뮤니티 리스트폼 */
	public List<CommunityVo> exeCommunityList() {
		System.out.println("CommunityService.exeCommunityList()");
		
		List<CommunityVo> communityList = communityDao.getCommunityList();
		
		return communityList;
		
	}


	
	/* 상품이름 리스트 */
	public List<CommunityVo> exeProductList() {
		System.out.println("CommunityService.exeCommunityList()");
		
		List<CommunityVo> communityList = communityDao.getProductList();
		
		return communityList;
		
	}
	
	/* 커뮤니티 쓰기 */
	public CommunityVo exeCommunityWrite(CommunityVo CommunityVo) {
		System.out.println("CommunityService.exeCommunityWrite()");
		
		CommunityVo insertVo = communityDao.getInsert(CommunityVo);
		
		return insertVo;
	}

	/* 커뮤니티 하나하나 읽기 */
	public CommunityVo exeCommunityRead(int boardNum) {
		System.out.println("CommunityService.exeCommunityRead()");
		
		// 조회수증가
		int result = communityDao.increaseboardViewsCount(boardNum);
		
		CommunityVo communityVo = communityDao.getRead(boardNum);
		
		List<CommentVo> commentList = communityDao.selectCommentsByBoardNum(boardNum);
		
		if (communityVo != null) {
			 communityVo.setCommentList(commentList);  // 댓글 목록을 CommunityVo 객체에 설정
		}
		
		return communityVo;
	}
	
	/* 답글 쓰기 */
	public CommentVo exeCommentWrite(CommentVo commentVo) {
		System.out.println("CommunityService.exeCommentWrite()");
		
		CommentVo returnVo = communityDao.getCommentInsert(commentVo); 
		
		returnVo = communityDao.getCommentByCommentNum(commentVo.getCommentNum());
		
		return returnVo;
	}
}
