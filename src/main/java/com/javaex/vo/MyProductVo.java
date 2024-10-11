package com.javaex.vo;

import java.util.List;

public class MyProductVo {

	private int userNum;
	private String userId;
	private String userName;

	private int receiptNum;
	private String purchasedDate;
	private int totalPrice;

	private int productDetailNum;
	private int productCount;

	private int productNum;

	private int productPrice;
	private String productName;
	private String colorName;
	private int colorNum;

	private String imageSavedName;
	private int imagePrimary;
	private String storageSize;
	private int storageNum;
	
	
	public MyProductVo() {
		super();
	}


	public MyProductVo(int userNum, String userId, String userName, int receiptNum, String purchasedDate,
			int totalPrice, int productDetailNum, int productCount, int productNum, int productPrice,
			String productName, String colorName, int colorNum, String imageSavedName, int imagePrimary,
			String storageSize, int storageNum) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userName = userName;
		this.receiptNum = receiptNum;
		this.purchasedDate = purchasedDate;
		this.totalPrice = totalPrice;
		this.productDetailNum = productDetailNum;
		this.productCount = productCount;
		this.productNum = productNum;
		this.productPrice = productPrice;
		this.productName = productName;
		this.colorName = colorName;
		this.colorNum = colorNum;
		this.imageSavedName = imageSavedName;
		this.imagePrimary = imagePrimary;
		this.storageSize = storageSize;
		this.storageNum = storageNum;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getReceiptNum() {
		return receiptNum;
	}


	public void setReceiptNum(int receiptNum) {
		this.receiptNum = receiptNum;
	}


	public String getPurchasedDate() {
		return purchasedDate;
	}


	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getProductDetailNum() {
		return productDetailNum;
	}


	public void setProductDetailNum(int productDetailNum) {
		this.productDetailNum = productDetailNum;
	}


	public int getProductCount() {
		return productCount;
	}


	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	public int getProductNum() {
		return productNum;
	}


	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}


	public int getColorNum() {
		return colorNum;
	}


	public void setColorNum(int colorNum) {
		this.colorNum = colorNum;
	}


	public String getImageSavedName() {
		return imageSavedName;
	}


	public void setImageSavedName(String imageSavedName) {
		this.imageSavedName = imageSavedName;
	}


	public int getImagePrimary() {
		return imagePrimary;
	}


	public void setImagePrimary(int imagePrimary) {
		this.imagePrimary = imagePrimary;
	}


	public String getStorageSize() {
		return storageSize;
	}


	public void setStorageSize(String storageSize) {
		this.storageSize = storageSize;
	}


	public int getStorageNum() {
		return storageNum;
	}


	public void setStorageNum(int storageNum) {
		this.storageNum = storageNum;
	}


	@Override
	public String toString() {
		return "MyProductVo [userNum=" + userNum + ", userId=" + userId + ", userName=" + userName + ", receiptNum="
				+ receiptNum + ", purchasedDate=" + purchasedDate + ", totalPrice=" + totalPrice + ", productDetailNum="
				+ productDetailNum + ", productCount=" + productCount + ", productNum=" + productNum + ", productPrice="
				+ productPrice + ", productName=" + productName + ", colorName=" + colorName + ", colorNum=" + colorNum
				+ ", imageSavedName=" + imageSavedName + ", imagePrimary=" + imagePrimary + ", storageSize="
				+ storageSize + ", storageNum=" + storageNum + "]";
	}

	
	

}
