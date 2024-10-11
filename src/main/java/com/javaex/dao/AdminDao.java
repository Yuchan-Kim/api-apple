package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductDetailVo;
import com.javaex.vo.StoreVo;
import com.javaex.vo.unionVo;

@Repository
public class AdminDao {

	@Autowired
	private SqlSession sqlSession;

	/* 시리즈 등록 */
	public int insertSeries(unionVo unionVo) {
		System.out.println("AdminService.exeAddSeries()");

		int count = sqlSession.insert("admin.seriesInsert", unionVo);

		return count;
	}

	/* 상품 등록 후 상품번호 반환 */
	public int insertProduct(unionVo unionVo) {
		System.out.println("AdminDao.insertProduct()");

		// 상품 등록 쿼리 실행 후, 자동 생성된 productNum이 unionVo 객체에 설정됨
		sqlSession.insert("admin.productInsert", unionVo);

		// unionVo에 설정된 productNum을 반환
		return unionVo.getProductNum();
	}

	/* 이미지 정보 저장(본문 이미지) */
	public int insertImageInfo(unionVo unionVo) {
		System.out.println("AdminDao.insertImageInfo()");

		// 이미지 정보 삽입 쿼리 실행
		return sqlSession.insert("admin.infoImageInsert", unionVo);
	}

	/* 상세 정보 입력 후 상품 상세정보 번호 반환 */
	public int insertDetail(unionVo unionVo) {
		System.out.println("AdminDao.insertDetail()");

		// 상품 등록 쿼리 실행 후, 자동 생성된 productDetailNum이 unionVo 객체에 설정됨
		sqlSession.insert("admin.detailInsert", unionVo);

		// unionVo에 설정된 productDetailNum을 반환
		return unionVo.getProductDetailNum();
	}

	/* 이미지 정보 저장(상세 이미지) */
	public int insertDetailImage(unionVo unionVo) {
		System.out.println("AdminDao.insertDetailImage()");

		// 이미지 정보 삽입 쿼리 실행
		return sqlSession.insert("admin.insertDetailImg", unionVo);
	}

	/* 색상 등록 */
	public int insertColor(unionVo unionVo) {
		System.out.println("AdminService.insertColor()");

		int count = sqlSession.insert("admin.colorInsert", unionVo);

		return count;
	}

	/* 디스플레이 등록 */
	public int insertDisplay(unionVo unionVo) {
		System.out.println("AdminService.insertDisplay()");

		int count = sqlSession.insert("admin.displayInsert", unionVo);

		return count;
	}

	/* 용량 등록 */
	public int insertStorage(unionVo unionVo) {
		System.out.println("AdminService.insertStorage()");

		int count = sqlSession.insert("admin.storageInsert", unionVo);

		return count;
	}

	/* 시리즈 가져오기 */
	public List<unionVo> getSeriesList() {
		System.out.println("AdminService.getSeriesList()");

		List<unionVo> seriesList = sqlSession.selectList("admin.selectSeriesList");

		return seriesList;
	}

	/* 상품명 가져오기 */
	public List<unionVo> getProductList(int seriesNum) {
		System.out.println("AdminService.getProductList()");

		List<unionVo> productList = sqlSession.selectList("admin.selectProductList", seriesNum);

		return productList;
	}

	/* 색상 가져오기 */
	public List<unionVo> getColorList(unionVo unionVo) {
		List<unionVo> colorList = sqlSession.selectList("admin.selectColorList", unionVo);

		return colorList;
	}

	/* 디스플레이 가져오기 */
	public List<unionVo> getDisplayList(unionVo unionVo) {
		List<unionVo> displayList = sqlSession.selectList("admin.selectDisplayList", unionVo);

		return displayList;
	}

	/* 용량 가져오기 */
	public List<unionVo> getStorageList(unionVo unionVo) {
		List<unionVo> storageList = sqlSession.selectList("admin.selectStorageList", unionVo);
		return storageList;
	}

	/* 상품 가져오기2 */
	public List<unionVo> getProductList2(int seriesNum) {
		System.out.println("AdminService.getProductList2()");

		List<unionVo> productList = sqlSession.selectList("admin.selectProductList2", seriesNum);

		return productList;
	}

	/* 색상 가져오기2 */
	public List<unionVo> getColorList2(int seriesNum) {
		System.out.println("AdminService.getColorList2()");

		List<unionVo> colorList = sqlSession.selectList("admin.selectColorList2", seriesNum);

		return colorList;
	}

	/* 디스플레이 가져오기2 */
	public List<unionVo> getDisplayList2(int seriesNum) {
		System.out.println("AdminService.getDisplayList2()");

		List<unionVo> displayList = sqlSession.selectList("admin.selectDisplayList2", seriesNum);

		return displayList;
	}

	/* 용량 가져오기2 */
	public List<unionVo> getStorageList2(int seriesNum) {
		System.out.println("AdminService.getStorageList2()");

		List<unionVo> storageList = sqlSession.selectList("admin.selectStroageList2", seriesNum);

		return storageList;
	}

	/* 시리즈 번호로 상품 상세정보 가져오기 */
	public List<ProductDetailVo> getProductDetail(int seriesNum) {
		System.out.println("AdminService.getProductDetail()");

		List<ProductDetailVo> productDetailList = sqlSession.selectList("admin.selectProductDetailList", seriesNum);

		return productDetailList;
	}

	/* Product 테이블에서 seriesNum이 있는지 확인 */
	public int existsInProduct(int seriesNum) {
		int count = sqlSession.selectOne("admin.existsInProduct", seriesNum);
		return count;
	}

	/* 시리즈 삭제 */
	public int deleteSeries(int seriesNum) {
		System.out.println("AdminController.deleteSeries()");

		int count = sqlSession.delete("admin.deleteSeries", seriesNum);

		return count;
	}

	/* Color 테이블에서 productNum이 있는지 확인 */
	public int existsInColor(int productNum) {
		int count = sqlSession.selectOne("admin.existsInColor", productNum);
		return count;
	}

	/* Display 테이블에서 productNum이 있는지 확인 */
	public int existsInDisplay(int productNum) {
		int count = sqlSession.selectOne("admin.existsInDisplay", productNum);
		return count;
	}

	/* Storage 테이블에서 productNum이 있는지 확인 */
	public int existsInStorage(int productNum) {
		int count = sqlSession.selectOne("admin.existsInStorage", productNum);
		return count;
	}

	/* 상품 삭제 */
	public int deleteProduct(int productNum) {
		System.out.println("AdminController.deleteProduct()");

		int count = sqlSession.delete("admin.deleteProduct", productNum);

		return count;
	}

	/* ProductDetail 테이블에서 colorNum이 있는지 확인 */
	public int existsInProductDetailColor(int colorNum) {
		int count = sqlSession.selectOne("admin.existsInProductDetail", colorNum);

		return count;
	}

	/* 색상 삭제 */
	public int deleteColor(int colorNum) {
		System.out.println("AdminController.deleteColor()");

		int count = sqlSession.delete("admin.deleteColor", colorNum);

		return count;
	}

	/* ProductDetail 테이블에서 displayNum이 있는지 확인 */
	public int existsInProductDetailDisplay(int displayNum) {
		int count = sqlSession.selectOne("admin.existsInProductDetailDisplay", displayNum);

		return count;
	}

	/* 디스플레이 삭제 */
	public int deleteDisplay(int displayNum) {
		System.out.println("AdminController.deleteDisplay()");

		int count = sqlSession.delete("admin.deleteDisplay", displayNum);

		return count;
	}

	/* ProductDetail 테이블에서 storageNum이 있는지 확인 */
	public int existsInProductDetailStorage(int storageNum) {
		int count = sqlSession.selectOne("admin.existsInProductDetailStorage", storageNum);

		return count;
	}

	/* 용량 삭제 */
	public int deleteStorage(int storageNum) {
		System.out.println("AdminController.deleteSeries()");

		int count = sqlSession.delete("admin.deleteStorage", storageNum);

		return count;
	}

	/* 상품 상세정보 삭제 */
	public int deleteProductDetail(int productDetailNum) {
		System.out.println("AdminController.deleteSeries()");

		int count = sqlSession.delete("admin.deleteProductDetail", productDetailNum);

		return count;
	}

	/* 매장 등록 */
	public int insertStore(StoreVo storeVo) {
		System.out.println("AdminService.insertStore()");

		int count = sqlSession.insert("admin.stroeInsert", storeVo);

		return count;
	}

	/* 상품 리스트 모두 가져오기 */
//	public List<ProductDetailVo> getProductListAll() {
//		System.out.println("AdminService.getProductListAll()");
//
//		List<ProductDetailVo> productListAll = sqlSession.selectList("admin.selectProductListAll");
//
//		return productListAll;
//	}
	
	// 전체 상품 목록 가져오기
    public List<ProductDetailVo> getProductListAll() {
        System.out.println("AdminDao.getProductListAll()");
        return sqlSession.selectList("admin.selectProductListAll");  // Mapper에서 전체 상품 목록을 가져옴
    }

    // 키워드 기반으로 필터링된 상품 목록 가져오기
    public List<ProductDetailVo> searchProductListByKeyword(String keyword) {
        System.out.println("AdminDao.searchProductListByKeyword() - 키워드: " + keyword);
        return sqlSession.selectList("admin.productListByKeyword", keyword);  // Mapper에서 필터링된 상품 목록을 가져옴
    }

	// History 테이블에서 productDetailNum이 있는지 확인
	public int existsInHistory(int productDetailNum) {
		int count = sqlSession.selectOne("admin.existsInHistory", productDetailNum);
		return count;
	}

	// productImage 테이블에서 productDetailNum으로 삭제
	public int deleteProductImage(int productDetailNum) {
		int count = sqlSession.delete("admin.deleteProductImage", productDetailNum);
		return count;
	}

	// 상품 리스트에서 삭제
	public int deleteProductList(int productDetailNum) {
		return sqlSession.delete("admin.deleteProductList", productDetailNum);
	}

	/* 매장 리스트 가져오기 */
	public List<StoreVo> storeSelectList() {
		System.out.println("AdminDao.storeSelectList()");

		List<StoreVo> storeList = sqlSession.selectList("admin.storeSelectList");

		return storeList;
	}

	/* 매장 1개 정보 가져오기 */
	public StoreVo storeSelectOne(int storeNum) {
		System.out.println("AdminDao.storeSelectOne()");

		StoreVo storeVo = sqlSession.selectOne("admin.storeSelectOne", storeNum);

		return storeVo;
	}

	/* 매장 수정하기 */
	public int modifyStore(StoreVo storeVo) {
		System.out.println("AdminDao.modifyStore()");

		int count = sqlSession.update("admin.updateStore", storeVo);

		return count;
	}

	/* 유저 리스트 가져오기 */
	public List<unionVo> userSelectList() {
		System.out.println("AdminDao.userSelectList()");

		List<unionVo> userList = sqlSession.selectList("admin.userSelectList");

		return userList;
	}

	/* 회원 1명 정보 가져오기 */
	public unionVo userSelectOne(int userNum) {
		System.out.println("AdminDao.userSelectOne()");

		unionVo unionVo = sqlSession.selectOne("admin.userSelectOne", userNum);

		return unionVo;
	}

	/* 회원 수정하기 */
	public int modifyUser(unionVo unionVo) {
		System.out.println("AdminDao.modifyUser()");

		int count = sqlSession.update("admin.updateUser", unionVo);

		return count;
	}

	/* 선택한 상세정보 1개 가져오기 */
	public ProductDetailVo selectOneProductDetail(int productDetailNum) {
		System.out.println("AdminDao.selectOneProductDetail()");

		ProductDetailVo productDetailVo = sqlSession.selectOne("admin.selectOneProductDetail", productDetailNum);

		return productDetailVo;
	}

	/* 선택한 상품의 상세 이미지 가져오기 */
	public List<ProductDetailVo> productDetailImg(int productDetailNum) {
		System.out.println("AdminDao.productDetailImg()");

		List<ProductDetailVo> productDetailList = sqlSession.selectList("admin.productDetailImg", productDetailNum);

		return productDetailList;
	}

	/* 상품상세 정보 수정 */
	public int updateProductDetail(ProductDetailVo productDetailVo) {
		return sqlSession.update("admin.updateProductDetail", productDetailVo);
	}

	/* 기존 상품 이미지 수정 */
	public int updateProductImage(int imagePrimary, String savedFileName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("imagePrimary", imagePrimary);
		paramMap.put("savedFileName", savedFileName);
		return sqlSession.update("admin.updateProductImage", paramMap);
	}

	/* 상품디테일 이미지 추가 */
	public int insertProductImage(int productDetailNum, String savedFileName, int imagePrimary) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("productDetailNum", productDetailNum);
		paramMap.put("savedFileName", savedFileName);
		paramMap.put("imagePrimary", imagePrimary);
		return sqlSession.insert("admin.insertProductImage", paramMap);
	}

}