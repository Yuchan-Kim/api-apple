package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.CommunityService;
import com.javaex.util.JsonResult;
import com.javaex.vo.CommentVo;
import com.javaex.vo.CommunityVo;

@RestController
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	
	/* 커뮤니티 리스트폼 */
	// http://localhost:3000/community 
	@GetMapping("/api/communitys")
	public JsonResult communityList() {
		System.out.println("CommunityController.communityList()");
		
		List<CommunityVo> communityList = communityService.exeCommunityList();
		 System.out.println(communityList);
		return JsonResult.success(communityList); 
	}
	
	
	/* 상품이름 리스트 */
	@GetMapping("/api/communitys/product")
	public JsonResult productList() {
		System.out.println("CommunityController.communityList()");
		
		List<CommunityVo> communityList = communityService.exeProductList();
		 System.out.println(communityList);
		return JsonResult.success(communityList);
	}
	
	
	/* 커뮤니티 쓰기 */
	// http://localhost:3000/community/write
	@PostMapping("/api/communitys")
	public JsonResult communityWrite(@RequestBody CommunityVo communityVo) {
		System.out.println("CommunityController.communityWrite()");
		
		CommunityVo insertVo = communityVo;
		
		CommunityVo returnVo = communityService.exeCommunityWrite(communityVo);
		System.out.println(communityVo);
	
		if(returnVo != null) {
			return JsonResult.success(returnVo);
		}else { 				//로그인 안됨
			return JsonResult.fail("게시판 등록실패");	
		}
	}
	
	
	/* 커뮤니티 하나하나 읽기 */
	// http://localhost:3000/community/comment/~
	@GetMapping("/api/communitys/{boardNum}")
	public JsonResult communityRead(@PathVariable(value="boardNum") int boardNum) {
		System.out.println("CommunityController.communityRead()");
		System.out.println(boardNum);
		
	    // 게시글, 댓글
	    CommunityVo communityVo = communityService.exeCommunityRead(boardNum);
	    //System.out.println("communityVo---" +communityVo);

	    // 댓글 목록을 CommunityVo 객체에 세팅
	    if (communityVo != null) {
	        return JsonResult.success(communityVo);
	    }else { 				//로그인 안됨
			return JsonResult.fail("게시판 읽기실패");
		}

	}
	
	
	/* 답글 쓰기 */
	@PostMapping("/api/comments")
	public JsonResult commentWrite(@RequestBody CommentVo commentVo) {
		System.out.println("CommunityController.commentWrite()");
		
		CommentVo returnVo = communityService.exeCommentWrite(commentVo);
		System.out.println("returnVo"+returnVo); 
		if(returnVo != null) {
			return JsonResult.success(returnVo);
		}else { 				//로그인 안됨
			return JsonResult.fail("게시판 등록실패");	
		}
	}
	
}
