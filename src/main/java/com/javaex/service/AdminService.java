package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.AdminDao;
import com.javaex.vo.ProductDetailVo;
import com.javaex.vo.StoreVo;
import com.javaex.vo.unionVo;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	/* 시리즈 등록 */
	public int exeAddSeries(unionVo unionVo) {
		System.out.println("AdminService.exeAddSeries()");

		int count = adminDao.insertSeries(unionVo);

		return count;
	}

	/* 파일 저장 후 파일명 반환 */
	public String exeUpload(MultipartFile file) {
		System.out.println("AdminService.exeUpload()");

		// 파일 저장 경로 설정
		String saveDir;
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("linux")) {
			saveDir = "/app/upload";
			// saveDir = "/Users/yuchan/Desktop";
		} else {
			saveDir = "C:\\javaStudy\\upload";
		}

		// 오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("Original File Name: " + orgName);

		// 확장자 추출
		String exeName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("Extension: " + exeName);

		// 저장 파일명 (UUID로 중복 방지)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exeName;
		System.out.println("Save Name: " + saveName);

		// 파일 전체 경로 + 파일명
		String filePath = saveDir + File.separator + saveName;
		System.out.println("File Path: " + filePath);

		// 파일을 실제로 디스크에 저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			bos.write(fileData);
			bos.close();
		} catch (Exception e) {
			System.out.println("파일 저장 중 오류: " + e.getMessage());
			return null;
		}

		// 저장된 파일명 반환
		return orgName;
	}

	/* 상품 + 본문 이미지 등록 */
	public int exeAddProductWithImages(unionVo unionVo, List<MultipartFile> files) {
		// Step 1: Product 테이블에 상품 정보 삽입 (자동 생성된 productNum이 unionVo에 설정됨)
		int productNum = adminDao.insertProduct(unionVo);

		// Step 2: InfoImage 테이블에 파일 정보 삽입
		int fileCount = 0;
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			if (!file.isEmpty()) {
				// 파일 저장 후 저장된 파일명 반환
				String savedFileName = exeUpload(file);

				if (savedFileName != null) {
					// unionVo에 저장된 파일명 및 이미지 순서 설정
					unionVo.setProductNum(productNum); // 새로 생성된 productNum 설정
					unionVo.setInfoImageSavedName(savedFileName);
					unionVo.setInfoImagePrimary(i + 1); // 이미지 순서 설정
					adminDao.insertImageInfo(unionVo); // 이미지 정보 삽입
					fileCount++;
				}
			}
		}
		return fileCount; // 성공적으로 처리된 파일 수 반환
	}

	/* 상세 정보 + 상세 이미지 등록 */
	public int exeAddDetailWithImages(unionVo unionVo, List<MultipartFile> files) {
		// Step 1: Product 테이블에 상품 정보 삽입 (자동 생성된 productNum이 unionVo에 설정됨)
		int productDetailNum = adminDao.insertDetail(unionVo);

		// Step 2: productImage 테이블에 파일 정보 삽입
		int fileCount = 0;
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			if (!file.isEmpty()) {
				// 파일 저장 후 저장된 파일명 반환
				String savedFileName = exeUpload(file);

				if (savedFileName != null) {
					// unionVo에 저장된 파일명 및 이미지 순서 설정
					unionVo.setProductDetailNum(productDetailNum); // 새로 생성된 productDetailNum 설정
					unionVo.setImageSavedName(savedFileName);
					unionVo.setImagePrimary(i + 1); // 이미지 순서 설정
					adminDao.insertDetailImage(unionVo); // 이미지 정보 삽입
					fileCount++;
				}
			}
		}
		return fileCount; // 성공적으로 처리된 파일 수 반환
	}

	/* 색상 등록 */
	public int exeAddColor(unionVo unionVo) {
		System.out.println("AdminService.exeAddColor()");

		int count = adminDao.insertColor(unionVo);

		return count;
	}

	/* 디스플레이 등록 */
	public int exeAddDisplay(unionVo unionVo) {
		System.out.println("AdminService.exeAddDisplay()");

		int count = adminDao.insertDisplay(unionVo);

		return count;
	}

	/* 용량 등록 */
	public int exeAddStorage(unionVo unionVo) {
		System.out.println("AdminService.exeAddStorage()");

		int count = adminDao.insertStorage(unionVo);

		return count;
	}

	/* 시리즈 가져오기 */
	public List<unionVo> exeGetSeriesList() {
		System.out.println("AdminService.exeGetSeriesList()");

		List<unionVo> seriesList = adminDao.getSeriesList();
		return seriesList;
	}

	/* 상품명 가져오기 */
	public List<unionVo> exeGetProductList(int seriesNum) {
		System.out.println("AdminService.exeGetProductList()");

		List<unionVo> productList = adminDao.getProductList(seriesNum);

		return productList;
	}

	/* 색상 가져오기 */
	public List<unionVo> exeGetColorList(int seriesNum, int productNum) {
		System.out.println("AdminService.exeGetColorList()");

		// unionVo 객체에 seriesNum과 productNum을 담아 DAO로 전달
		unionVo unionVo = new unionVo();
		unionVo.setSeriesNum(seriesNum);
		unionVo.setProductNum(productNum);

		List<unionVo> colorList = adminDao.getColorList(unionVo);

		return colorList;
	}

	/* 디스플레이 가져오기 */
	public List<unionVo> exeGetDisplayList(int seriesNum, int productNum) {
		System.out.println("AdminService.exeGetDisplayList()");

		// unionVo 객체에 seriesNum과 productNum을 담아 DAO로 전달
		unionVo unionVo = new unionVo();
		unionVo.setSeriesNum(seriesNum);
		unionVo.setProductNum(productNum);

		List<unionVo> displayList = adminDao.getDisplayList(unionVo);

		return displayList;
	}

	/* 용량 가져오기 */
	public List<unionVo> exeGetStorageList(int seriesNum, int productNum) {
		System.out.println("AdminService.exeGetStorageList()");

		// unionVo 객체에 seriesNum과 productNum을 담아 DAO로 전달
		unionVo unionVo = new unionVo();
		unionVo.setSeriesNum(seriesNum);
		unionVo.setProductNum(productNum);

		List<unionVo> storageList = adminDao.getStorageList(unionVo);

		return storageList;
	}

	/* 상품 가져오기2 */
	public List<unionVo> exeGetProductList2(int seriesNum) {
		System.out.println("AdminService.exeGetProductList2()");

		List<unionVo> productList = adminDao.getProductList2(seriesNum);

		return productList;
	}

	/* 색상 가져오기2 */
	public List<unionVo> exeGetColorList2(int seriesNum) {
		System.out.println("AdminService.exeGetColorList2()");

		List<unionVo> colorList = adminDao.getColorList2(seriesNum);

		return colorList;
	}

	/* 디스플레이 가져오기2 */
	public List<unionVo> exeGetDisplayList2(int seriesNum) {
		System.out.println("AdminService.exeGetDisplayList2()");

		List<unionVo> displayList = adminDao.getDisplayList2(seriesNum);

		return displayList;
	}

	/* 용량 가져오기2 */
	public List<unionVo> exeGetStorageList2(int seriesNum) {
		System.out.println("AdminService.exeGetStorageList2()");

		List<unionVo> storageList = adminDao.getStorageList2(seriesNum);

		return storageList;
	}

	/* 상품상세 정보 가져오기 */
	public List<ProductDetailVo> exeGetProductDetail(int seriesNum) {
		System.out.println("AdminService.exeGetProductDetail()");

		List<ProductDetailVo> productDetailList = adminDao.getProductDetail(seriesNum);

		return productDetailList;
	}

	/* Product 테이블에서 seriesNum이 있는지 확인 */
	public boolean checkProduct(int seriesNum) {

		int count = adminDao.existsInProduct(seriesNum);

		return count > 0;
	}

	/* 시리즈 삭제 */
	public int exDeleteSeries(int seriesNum) {
		System.out.println("AdminController.exDeleteSeries()");

		int count = adminDao.deleteSeries(seriesNum);

		return count;
	}

	/* Color 테이블에서 productNum이 있는지 확인 */
	public boolean checkColor(int productNum) {
		int count = adminDao.existsInColor(productNum);
		return count > 0;
	}

	/* Display 테이블에서 productNum이 있는지 확인 */
	public boolean checkDisplay(int productNum) {
		int count = adminDao.existsInDisplay(productNum);
		return count > 0;
	}

	/* Storage 테이블에서 productNum이 있는지 확인 */
	public boolean checkStorage(int productNum) {
		int count = adminDao.existsInStorage(productNum);
		return count > 0;
	}

	/* 상품 삭제 */
	public int exDeleteProduct(int productNum) {
		System.out.println("AdminController.exDeleteProduct()");

		int count = adminDao.deleteProduct(productNum);

		return count;
	}

	/* ProductDetail 테이블에서 colorNum이 있는지 확인 */
	public boolean checkProductDetailColor(int colorNum) {
		int count = adminDao.existsInProductDetailColor(colorNum);

		return count > 0;
	}

	/* 색상 삭제 */
	public int exDeleteColor(int colorNum) {
		System.out.println("AdminController.exDeleteColor()");

		int count = adminDao.deleteColor(colorNum);

		return count;
	}

	/* ProductDetail 테이블에서 displayNum이 있는지 확인 */
	public boolean checkProductDetailDisplay(int displayNum) {
		int count = adminDao.existsInProductDetailDisplay(displayNum);

		return count > 0;
	}

	/* 디스플레이 삭제 */
	public int exDeleteDisplay(int displaynum) {
		System.out.println("AdminController.exDeleteDisplay()");

		int count = adminDao.deleteDisplay(displaynum);

		return count;
	}

	/* ProductDetail 테이블에서 storageNum이 있는지 확인 */
	public boolean checkProductDetailStorage(int storageNum) {
		int count = adminDao.existsInProductDetailStorage(storageNum);

		return count > 0;
	}

	/* 용량 삭제 */
	public int exDeleteStorage(int storageNum) {
		System.out.println("AdminController.exDeleteStorage()");

		int count = adminDao.deleteStorage(storageNum);

		return count;
	}

	/* 상품 상세정보 삭제 */
	public int exDeleteProductDetail(int productDetailNum) {
		System.out.println("AdminController.exDeleteProductDetail()");

		// productImage 테이블에서 해당 productDetailNum을 가진 데이터 삭제
		adminDao.deleteProductImage(productDetailNum);

		int count = adminDao.deleteProductDetail(productDetailNum);

		return count;
	}

	// 매장 등록
	public int exeAddStore(StoreVo storeVo) {

		// 매장 이미지 처리
		if (storeVo.getStoreFile() != null && !storeVo.getStoreFile().isEmpty()) {
			String storeImgName = exeUpload(storeVo.getStoreFile()); // 파일 저장 후 저장된 파일명 반환
			storeVo.setStoreImage(storeImgName); // 파일 이름을 Vo에 저장
		}

		// 지도 이미지 처리
		if (storeVo.getMapFile() != null && !storeVo.getMapFile().isEmpty()) {
			String mapImgName = exeUpload(storeVo.getMapFile()); // 파일 저장 후 저장된 파일명 반환
			storeVo.setStoreMapImage(mapImgName); // 파일 이름을 Vo에 저장
		}

		// DB에 매장 정보 저장
		int count = adminDao.insertStore(storeVo);

		return count;
	}

	/* 상품 리스트 모두 가져오기 */
//	public List<ProductDetailVo> exeGetProductListAll() {
//		System.out.println("AdminService.exeGetProductListAll()");
//
//		List<ProductDetailVo> productListAll = adminDao.getProductListAll();
//		return productListAll;
//	}
	
	// 전체 상품 목록 반환 메소드
    public List<ProductDetailVo> exeGetProductListAll() {
        System.out.println("AdminService.exeGetProductListAll()");
        return adminDao.getProductListAll();  // Dao에서 전체 목록을 가져옴
    }

    // 키워드로 필터링된 상품 목록 반환 메소드
    public List<ProductDetailVo> searchProductListByKeyword(String keyword) {
        System.out.println("AdminService.searchProductListByKeyword() - 검색어: " + keyword);
        return adminDao.searchProductListByKeyword(keyword);  // Dao에서 필터링된 목록을 가져옴
    }

	/* 상품 리스트에서 상품디테일번호 확인하고 삭제하기 */
	// History 테이블에서 productDetailNum이 있는지 확인
	public boolean checkHistory(int productDetailNum) {
		// adminDao의 existsInHistory 메소드를 통해 확인
		int count = adminDao.existsInHistory(productDetailNum);
		return count > 0; // 결과가 0보다 크면 History에 존재하는 것으로 처리
	}

	/* 상품리스트에서 삭제 */
	public int deleteProductList(int productDetailNum) {
		// productImage 테이블에서 해당 productDetailNum을 가진 데이터 삭제
		adminDao.deleteProductImage(productDetailNum);

		int count = adminDao.deleteProductList(productDetailNum);

		return count;
	}

	/* 매장 리스트 가져오기 */
	public List<StoreVo> exeStoreList() {
		System.out.println("AdminService.exeStoreList()");

		List<StoreVo> storeList = adminDao.storeSelectList();

		return storeList;
	}

	/* 매장 1개 정보 가져오기 */
	public StoreVo exeGetStoreSelectOne(int storeNum) {
		System.out.println("AdminService.getStoreSelectOne()");

		StoreVo storeVo = adminDao.storeSelectOne(storeNum);

		return storeVo;
	}

	/* 매장 수정하기 */
	public int exeModifyStore(StoreVo storeVo) {
		System.out.println("UserService.exeModifyStore()");

		// 매장 이미지 처리
		if (storeVo.getStoreFile() != null && !storeVo.getStoreFile().isEmpty()) {
			String storeImgName = exeUpload(storeVo.getStoreFile()); // 파일 저장 후 저장된 파일명 반환
			storeVo.setStoreImage(storeImgName); // 파일 이름을 Vo에 저장
		}

		// 지도 이미지 처리
		if (storeVo.getMapFile() != null && !storeVo.getMapFile().isEmpty()) {
			String mapImgName = exeUpload(storeVo.getMapFile()); // 파일 저장 후 저장된 파일명 반환
			storeVo.setStoreMapImage(mapImgName); // 파일 이름을 Vo에 저장
		}

		int count = adminDao.modifyStore(storeVo);

		return count;
	}

	/* 회원 리스트 가져오기 */
	public List<unionVo> exeUserList() {
		System.out.println("AdminService.exeUserList()");

		List<unionVo> userList = adminDao.userSelectList();

		return userList;
	}

	/* 회원 1명 정보 가져오기 */
	public unionVo getStoreSelectOne(int userNum) {
		System.out.println("AdminService.getUserSelectOne()");

		unionVo userList = adminDao.userSelectOne(userNum);

		return userList;
	}

	/* 회원정보 수정하기 */
	public int exeModifyUser(unionVo unionVo) {
		System.out.println("AdminService.exeModifyUser()");
		int count = adminDao.modifyUser(unionVo);

		return count;
	}

	/* 선택한 상세정보 1개 가져오기 */
	public ProductDetailVo exeSelectOneProductDetail(int productDetailNum) {
		System.out.println("AdminService.exeSelectOneProductDetail()");

		ProductDetailVo productDetailVo = adminDao.selectOneProductDetail(productDetailNum);

		return productDetailVo;
	}

	/* 선택한 상품의 상세 이미지 가져오기 */
	public List<ProductDetailVo> exeProductDetailImg(int productDetailNum) {
		System.out.println("AdminService.exeSelectOneProductDetailImg()");

		List<ProductDetailVo> productDetailList = adminDao.productDetailImg(productDetailNum);

		return productDetailList;
	}

	/* 상품상세 정보 수정하기 */
	public int exeModifyDetailWithImages(ProductDetailVo productDetailVo, List<MultipartFile> files) {
		List<String> savedFileNames = new ArrayList<>();

		List<Integer> imagePrimaryList = productDetailVo.getImagePrimaryList();

		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			if (!file.isEmpty()) {
				String savedFileName = exeUpload(file);
				if (savedFileName != null) {
					savedFileNames.add(savedFileName);

					if (imagePrimaryList != null && i < imagePrimaryList.size()) {
						adminDao.updateProductImage(imagePrimaryList.get(i), savedFileName);
					} else {
						adminDao.insertProductImage(productDetailVo.getProductDetailNum(), savedFileName, i);
					}
				} else {
					return -1;
				}
			}
		}

		adminDao.updateProductDetail(productDetailVo);
		return 1;
	}

}
