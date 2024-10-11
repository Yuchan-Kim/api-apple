package com.javaex.vo;

import org.springframework.web.multipart.MultipartFile;

public class StoreVo {

	private int storeNum;
	private String storeName;
	private String storeAddress;
	private String storeNumber;
	private String storeImage;
	private String storeMapImage;
	private MultipartFile storeFile;
	private MultipartFile mapFile;
	private String storeStatus;

	public StoreVo() {
	}

	public StoreVo(int storeNum, String storeName, String storeAddress, String storeNumber, String storeImage,
			String storeMapImage, MultipartFile storeFile, MultipartFile mapFile, String storeStatus) {
		this.storeNum = storeNum;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeNumber = storeNumber;
		this.storeImage = storeImage;
		this.storeMapImage = storeMapImage;
		this.storeFile = storeFile;
		this.mapFile = mapFile;
		this.storeStatus = storeStatus;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}

	public String getStoreMapImage() {
		return storeMapImage;
	}

	public void setStoreMapImage(String storeMapImage) {
		this.storeMapImage = storeMapImage;
	}

	public MultipartFile getStoreFile() {
		return storeFile;
	}

	public void setStoreFile(MultipartFile storeFile) {
		this.storeFile = storeFile;
	}

	public MultipartFile getMapFile() {
		return mapFile;
	}

	public void setMapFile(MultipartFile mapFile) {
		this.mapFile = mapFile;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	@Override
	public String toString() {
		return "StoreVo [storeNum=" + storeNum + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", storeNumber=" + storeNumber + ", storeImage=" + storeImage + ", storeMapImage=" + storeMapImage
				+ ", storeFile=" + storeFile + ", mapFile=" + mapFile + ", storeStatus=" + storeStatus + "]";
	}

}
