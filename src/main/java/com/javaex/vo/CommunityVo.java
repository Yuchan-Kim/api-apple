package com.javaex.vo;

import java.util.List;

public class CommunityVo {

	private int boardNum;
	private int productNum;
	private String productName;
	private int userNum;
	private String boardContent;
	private String boardTitle;
	private int boardViews;
	private String boardDate;

	private String userName;
	private String userId;

	private int commentNum;
	private String comment;
	private String commentDateTime;

	private int commentCount; // 댓글 수 추가

	private List<CommentVo> commentList;

	public CommunityVo() {
		super();
	}

	public CommunityVo(int boardNum, int productNum, String productName, int userNum, String boardContent,
			String boardTitle, int boardViews, String boardDate, String userName, String userId, int commentNum,
			String comment, String commentDateTime, List<CommentVo> commentList) {
		super();
		this.boardNum = boardNum;
		this.productNum = productNum;
		this.productName = productName;
		this.userNum = userNum;
		this.boardContent = boardContent;
		this.boardTitle = boardTitle;
		this.boardViews = boardViews;
		this.boardDate = boardDate;
		this.userName = userName;
		this.userId = userId;
		this.commentNum = commentNum;
		this.comment = comment;
		this.commentDateTime = commentDateTime;
		this.commentList = commentList;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public int getBoardViews() {
		return boardViews;
	}

	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentDateTime() {
		return commentDateTime;
	}

	public void setCommentDateTime(String commentDateTime) {
		this.commentDateTime = commentDateTime;
	}

	public List<CommentVo> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentVo> commentList) {
		this.commentList = commentList;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "CommunityVo [boardNum=" + boardNum + ", productNum=" + productNum + ", productName=" + productName
				+ ", userNum=" + userNum + ", boardContent=" + boardContent + ", boardTitle=" + boardTitle
				+ ", boardViews=" + boardViews + ", boardDate=" + boardDate + ", userName=" + userName + ", userId="
				+ userId + ", commentNum=" + commentNum + ", comment=" + comment + ", commentDateTime="
				+ commentDateTime + ", commentCount=" + commentCount + ", commentList=" + commentList + "]";
	}

}
