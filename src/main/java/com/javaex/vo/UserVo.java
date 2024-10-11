package com.javaex.vo;

import java.util.List;

public class UserVo {

	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddress;
	private String userHp;
	private String userStatus;

	private List<MyProductVo> purchaseList; // 구매 내역 리스트
	private List<unionVo> likeList; // 관심 목록 리스트

	public UserVo() {
		super();
	}

	public UserVo(int userNum, String userId, String userPw, String userName, String userAddress, String userHp,
			String userStatus, List<MyProductVo> purchaseList, List<unionVo> likeList) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userHp = userHp;
		this.userStatus = userStatus;
		this.purchaseList = purchaseList;
		this.likeList = likeList;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserHp() {
		return userHp;
	}

	public void setUserHp(String userHp) {
		this.userHp = userHp;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public List<MyProductVo> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<MyProductVo> purchaseList) {
		this.purchaseList = purchaseList;
	}

	public List<unionVo> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<unionVo> likeList) {
		this.likeList = likeList;
	}

	@Override
	public String toString() {
		return "UserVo [userNum=" + userNum + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userHp=" + userHp + ", userStatus=" + userStatus
				+ ", purchaseList=" + purchaseList + ", likeList=" + likeList + "]";
	}

}
