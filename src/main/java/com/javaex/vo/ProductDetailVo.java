package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDetailVo {

	private int productNum;
	private int productDetailNum;
	private String seriesName;
	private String productName;
	private String displaySize;
	private String colorName;
	private String colorCode;
	private int productPrice;
	private String storageSize;
	private String imageSavedName;
	private String imagePrimary;
	private int seriesNum;
	private int colorNum;
	private int displayNum;
	private int storageNum;

	private MultipartFile productImgFile;
	private List<Integer> imagePrimaryList; // 수정할 이미지의 imagePrimary 리스트

	public ProductDetailVo() {
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getProductDetailNum() {
		return productDetailNum;
	}

	public void setProductDetailNum(int productDetailNum) {
		this.productDetailNum = productDetailNum;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(String storageSize) {
		this.storageSize = storageSize;
	}

	public String getImageSavedName() {
		return imageSavedName;
	}

	public void setImageSavedName(String imageSavedName) {
		this.imageSavedName = imageSavedName;
	}

	public String getImagePrimary() {
		return imagePrimary;
	}

	public void setImagePrimary(String imagePrimary) {
		this.imagePrimary = imagePrimary;
	}

	public int getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	public int getColorNum() {
		return colorNum;
	}

	public void setColorNum(int colorNum) {
		this.colorNum = colorNum;
	}

	public int getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(int displayNum) {
		this.displayNum = displayNum;
	}

	public int getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(int storageNum) {
		this.storageNum = storageNum;
	}

	public MultipartFile getProductImgFile() {
		return productImgFile;
	}

	public void setProductImgFile(MultipartFile productImgFile) {
		this.productImgFile = productImgFile;
	}

	public List<Integer> getImagePrimaryList() {
		return imagePrimaryList;
	}

	public void setImagePrimaryList(List<Integer> imagePrimaryList) {
		this.imagePrimaryList = imagePrimaryList;
	}

	@Override
	public String toString() {
		return "ProductDetailVo [productNum=" + productNum + ", productDetailNum=" + productDetailNum + ", seriesName="
				+ seriesName + ", productName=" + productName + ", displaySize=" + displaySize + ", colorName="
				+ colorName + ", colorCode=" + colorCode + ", productPrice=" + productPrice + ", storageSize="
				+ storageSize + ", imageSavedName=" + imageSavedName + ", imagePrimary=" + imagePrimary + ", seriesNum="
				+ seriesNum + ", colorNum=" + colorNum + ", displayNum=" + displayNum + ", storageNum=" + storageNum
				+ ", productImgFile=" + productImgFile + ", imagePrimaryList=" + imagePrimaryList + "]";
	}

}
