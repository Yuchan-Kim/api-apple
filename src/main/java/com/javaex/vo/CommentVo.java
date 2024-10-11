package com.javaex.vo;

public class CommentVo {
	
	private int commentNum;
	private int userNum;
	private int boardNum;
	private String comment;
	private String commentDateTime;

	private String userId;

	public CommentVo() {
		super();
	}

	public CommentVo(int commentNum, int userNum, int boardNum, String comment, String commentDateTime, String userId) {
		super();
		this.commentNum = commentNum;
		this.userNum = userNum;
		this.boardNum = boardNum;
		this.comment = comment;
		this.commentDateTime = commentDateTime;
		this.userId = userId;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CommentVo [commentNum=" + commentNum + ", userNum=" + userNum + ", boardNum=" + boardNum + ", comment="
				+ comment + ", commentDateTime=" + commentDateTime + ", userId=" + userId + "]";
	}
	
	
}
