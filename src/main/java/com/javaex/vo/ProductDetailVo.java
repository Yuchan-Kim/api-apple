package com.javaex.vo;

public class ProductDetailVo {

	private int productNum;
	private int productDetailNum;
	private String seriesName;
	private String productName;
	private String displaySize;
	private String colorName;
	private int productPrice;
	private String storageSize;
	private String imageSavedName;

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

	@Override
	public String toString() {
		return "ProductDetailVo [productNum=" + productNum + ", productDetailNum=" + productDetailNum + ", seriesName="
				+ seriesName + ", productName=" + productName + ", displaySize=" + displaySize + ", colorName="
				+ colorName + ", productPrice=" + productPrice + ", storageSize=" + storageSize + ", imageSavedName="
				+ imageSavedName + "]";
	}

}
