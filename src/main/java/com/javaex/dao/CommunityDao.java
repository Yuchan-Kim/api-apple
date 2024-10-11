package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CommentVo;
import com.javaex.vo.CommunityVo;

@Repository
public class CommunityDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	/* 커뮤니티 리스트폼 */
	public List<CommunityVo> getCommunityList() {
		System.out.println("CommunityDao.getCommunityList()");
		
		List<CommunityVo> communityList = sqlSession.selectList("community.selectList");
		
		return communityList;
	}
	
	
	/* 커뮤니티 조회수 */
	public int increaseboardViewsCount(int boardNum) {
		System.out.println("CommunityDao.increaseHitCount()");
		
		int result = sqlSession.update("community.increaseboardViewsCount", boardNum);	
		
		if (result == 1) {
			return result;
		} else {
			return 0;
		}
		
	}
	
	/* 상품이름 리스트 */
	public List<CommunityVo> getProductList() {
		System.out.println("CommunityDao.getProductList()");
		
		List<CommunityVo> communityList = sqlSession.selectList("community.selectProduct");
		
		return communityList;
	}

	/* 커뮤니티 쓰기 */
	public CommunityVo getInsert(CommunityVo communityVo) {
		System.out.println("CommunityDao.getInsert()");
		
		int count = sqlSession.insert("community.insert", communityVo);		

		if (count == 1) {
			return communityVo;
		} else {
			return null;
		}
	}
	
	/* 커뮤니티 하나하나 읽기 */
	public CommunityVo getRead(int boardNum) {
		System.out.println("CommunityDao.getRead()");
		
		CommunityVo communityVo = sqlSession.selectOne("community.selectRead", boardNum);
		
		return communityVo;
	}
	
	
	/* 특정 게시글에 달린 댓글 목록 조회 */
    public List<CommentVo> selectCommentsByBoardNum(int boardNum) {
    	
    	List<CommentVo> commentVoList = sqlSession.selectList("community.selectCommentsByBoardNum", boardNum);
    	
    	return commentVoList;    
    }
    
    
	/* 답글 쓰기 */
	public CommentVo getCommentInsert(CommentVo commentVo) {
		System.out.println("CommunityDao.getInsert()");
		System.out.println("CommunityDao."+ commentVo);
		
		int count = sqlSession.insert("community.insertComment", commentVo);		

		if (count == 1) {
			return commentVo;
		} else {
			return null;
		}
	}
	
	/* 댓글 조회 */
	public CommentVo getCommentByCommentNum(int commentNum) {
		CommentVo commentVo = sqlSession.selectOne("community.selectComment", commentNum);
		
	    return commentVo;
	}

}
