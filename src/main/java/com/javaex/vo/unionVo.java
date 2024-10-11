package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class unionVo {

   // Field
   private int seriesNum;
   private String seriesName;

   private int userNum;
   private String userId;
   private String userPw;
   private String userName;
   private String userAddress;
   private String userHp;
   private String userStatus;

   private int storeNum;
   private String storeName;
   private String storeAddress;
   private String storeNumber;
   private String storeImage;
   private String storeMapImage;
   private String storeStatus;

   private int productNum;

   private int colorNum;
   private String colorName;
   private String colorCode;

   private int displayNum;
   private String displaySize;

   private int storageNum;
   private String storageSize;

   private int productDetailNum;
   private int productPrice;
   private String productName;

   private int cartNum;
   private int count;

   private int boardNum;
   private String boardContent;
   private String boardTitle;
   private Integer boardViews;
   private String boardDate;

   private int commentNum;
   private String comment;
   private String commentDateTime;

   private int receiptNum;
   private String purchasedDate;
   private String shippingAddress;
   private String shippingStatus;
   private int totalPrice;

   private int historyNum;
   private int productCount;

   private int imageNum;
   private String imageSavedName;
   private int imagePrimary;

   private int likedProductNum;

   private int infoImageNum;
   private String infoImageSavedName;
   private int infoImagePrimary;

   private List<unionVo> purchaseList; // 구매 내역 리스트
   private List<unionVo> likeList; // 관심 목록 리스트

   public int getSeriesNum() {
      return seriesNum;
   }

   public void setSeriesNum(int seriesNum) {
      this.seriesNum = seriesNum;
   }

   public String getSeriesName() {
      return seriesName;
   }

   public void setSeriesName(String seriesName) {
      this.seriesName = seriesName;
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

   public String getStoreStatus() {
      return storeStatus;
   }

   public void setStoreStatus(String storeStatus) {
      this.storeStatus = storeStatus;
   }

   public int getProductNum() {
      return productNum;
   }

   public void setProductNum(int productNum) {
      this.productNum = productNum;
   }

   public int getColorNum() {
      return colorNum;
   }

   public void setColorNum(int colorNum) {
      this.colorNum = colorNum;
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

   public int getDisplayNum() {
      return displayNum;
   }

   public void setDisplayNum(int displayNum) {
      this.displayNum = displayNum;
   }

   public String getDisplaySize() {
      return displaySize;
   }

   public void setDisplaySize(String displaySize) {
      this.displaySize = displaySize;
   }

   public int getStorageNum() {
      return storageNum;
   }

   public void setStorageNum(int storageNum) {
      this.storageNum = storageNum;
   }

   public String getStorageSize() {
      return storageSize;
   }

   public void setStorageSize(String storageSize) {
      this.storageSize = storageSize;
   }

   public int getProductDetailNum() {
      return productDetailNum;
   }

   public void setProductDetailNum(int productDetailNum) {
      this.productDetailNum = productDetailNum;
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

   public int getCartNum() {
      return cartNum;
   }

   public void setCartNum(int cartNum) {
      this.cartNum = cartNum;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public int getProductCount() {
      return productCount;
   }

   public void setProductCount(int productCount) {
      this.productCount = productCount;
   }

   public int getBoardNum() {
      return boardNum;
   }

   public void setBoardNum(int boardNum) {
      this.boardNum = boardNum;
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

   public Integer getBoardViews() {
      return boardViews;
   }

   public void setBoardViews(Integer boardViews) {
      this.boardViews = boardViews;
   }

   public String getBoardDate() {
      return boardDate;
   }

   public void setBoardDate(String boardDate) {
      this.boardDate = boardDate;
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

   public String getShippingAddress() {
      return shippingAddress;
   }

   public void setShippingAddress(String shippingAddress) {
      this.shippingAddress = shippingAddress;
   }

   public String getShippingStatus() {
      return shippingStatus;
   }

   public void setShippingStatus(String shippingStatus) {
      this.shippingStatus = shippingStatus;
   }

   public int getTotalPrice() {
      return totalPrice;
   }

   public void setTotalPrice(int totalPrice) {
      this.totalPrice = totalPrice;
   }

   public int getHistoryNum() {
      return historyNum;
   }

   public void setHistoryNum(int historyNum) {
      this.historyNum = historyNum;
   }

   public int getImageNum() {
      return imageNum;
   }

   public void setImageNum(int imageNum) {
      this.imageNum = imageNum;
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

   public int getLikedProductNum() {
      return likedProductNum;
   }

   public void setLikedProductNum(int likedProductNum) {
      this.likedProductNum = likedProductNum;
   }

   public int getInfoImageNum() {
      return infoImageNum;
   }

   public void setInfoImageNum(int infoImageNum) {
      this.infoImageNum = infoImageNum;
   }

   public String getInfoImageSavedName() {
      return infoImageSavedName;
   }

   public void setInfoImageSavedName(String infoImageSavedName) {
      this.infoImageSavedName = infoImageSavedName;
   }

   public int getInfoImagePrimary() {
      return infoImagePrimary;
   }

   public void setInfoImagePrimary(int infoImagePrimary) {
      this.infoImagePrimary = infoImagePrimary;
   }

   public List<unionVo> getPurchaseList() {
      return purchaseList;
   }

   public void setPurchaseList(List<unionVo> purchaseList) {
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
      return "unionVo [seriesNum=" + seriesNum + ", seriesName=" + seriesName + ", userNum=" + userNum + ", userId="
            + userId + ", userPw=" + userPw + ", userName=" + userName + ", userAddress=" + userAddress
            + ", userHp=" + userHp + ", userStatus=" + userStatus + ", storeNum=" + storeNum + ", storeName="
            + storeName + ", storeAddress=" + storeAddress + ", storeNumber=" + storeNumber + ", storeImage="
            + storeImage + ", storeMapImage=" + storeMapImage + ", storeStatus=" + storeStatus + ", productNum="
            + productNum + ", colorNum=" + colorNum + ", colorName=" + colorName + ", colorCode=" + colorCode
            + ", displayNum=" + displayNum + ", displaySize=" + displaySize + ", storageNum=" + storageNum
            + ", storageSize=" + storageSize + ", productDetailNum=" + productDetailNum + ", productPrice="
            + productPrice + ", productName=" + productName + ", cartNum=" + cartNum + ", count=" + count
            + ", boardNum=" + boardNum + ", boardContent=" + boardContent + ", boardTitle=" + boardTitle
            + ", boardViews=" + boardViews + ", boardDate=" + boardDate + ", commentNum=" + commentNum
            + ", comment=" + comment + ", commentDateTime=" + commentDateTime + ", receiptNum=" + receiptNum
            + ", purchasedDate=" + purchasedDate + ", shippingAddress=" + shippingAddress + ", shippingStatus="
            + shippingStatus + ", totalPrice=" + totalPrice + ", historyNum=" + historyNum + ", productCount="
            + productCount + ", imageNum=" + imageNum + ", imageSavedName=" + imageSavedName + ", imagePrimary="
            + imagePrimary + ", likedProductNum=" + likedProductNum + ", infoImageNum=" + infoImageNum
            + ", infoImageSavedName=" + infoImageSavedName + ", infoImagePrimary=" + infoImagePrimary + "]";
   }

}