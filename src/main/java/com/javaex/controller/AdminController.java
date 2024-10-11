package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AdminService;
import com.javaex.util.JsonResult;
import com.javaex.vo.ProductDetailVo;
import com.javaex.vo.StoreVo;
import com.javaex.vo.unionVo;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	/* 시리즈 등록 */
	@PostMapping("/api/add/series")
	public JsonResult addSeries(@RequestBody unionVo unionVo) {
		System.out.println("AdminController.addSeries()");

		int count = adminService.exeAddSeries(unionVo);

		if (count != 1) { // 등록 실패
			return JsonResult.fail("등록 실패");
		} else { // 등록 성공
			return JsonResult.success(count);
		}
	}

	/* 가격 + 본문 이미지 등록 */
	@PostMapping("/api/infoImage/upload")
	public JsonResult uploadInfoImages(@RequestParam("seriesNum") int seriesNum, // 시리즈 번호
			@RequestParam("productName") String productName, // 상품명
			@RequestParam("infoImageSavedName") List<MultipartFile> files // 여러 파일 받기
	) {
		// unionVo 객체 생성
		unionVo unionVo = new unionVo();
		unionVo.setSeriesNum(seriesNum);
		unionVo.setProductName(productName);

		// Service 계층에 데이터 처리 위임
		int count = adminService.exeAddProductWithImages(unionVo, files);

		if (count > 0) {
			return JsonResult.success("상품 이미지가 성공적으로 등록되었습니다.");
		} else {
			return JsonResult.fail("상품 이미지 등록 실패");
		}
	}

	/* 상품 + 상세 이미지 등록 */
	@PostMapping("/api/productImgage/upload")
	public JsonResult uploadProductImage(@RequestParam("seriesNum") int seriesNum, // 시리즈 번호
			@RequestParam("productNum") int productNum, // 상품 번호
			@RequestParam("colorNum") int colorNum, // 색상 번호
			@RequestParam("displayNum") int displayNum, // 디스플레이 번호
			@RequestParam("storageNum") int storageNum, // 용량 번호
			@RequestParam("productPrice") int productPrice, // 상품 가격
			@RequestParam("imageSavedName") List<MultipartFile> files // 여러 파일 받기
	) {
		// unionVo 객체 생성
		unionVo unionVo = new unionVo();
		unionVo.setSeriesNum(seriesNum);
		unionVo.setProductNum(productNum);
		unionVo.setColorNum(colorNum);
		unionVo.setDisplayNum(displayNum);
		unionVo.setStorageNum(storageNum);
		unionVo.setProductPrice(productPrice);

		// Service 계층에 데이터 처리 위임
		int count = adminService.exeAddDetailWithImages(unionVo, files);

		if (count > 0) {
			return JsonResult.success("상품 이미지가 성공적으로 등록되었습니다.");
		} else {
			return JsonResult.fail("상품 이미지 등록 실패");
		}
	}

	/* 색상 등록 */
	@PostMapping("/api/add/color")
	public JsonResult addColor(@RequestBody unionVo unionVo) {
		System.out.println("AdminController.addColor()");

		int count = adminService.exeAddColor(unionVo);

		if (count != 1) { // 등록 실패
			return JsonResult.fail("등록 실패");
		} else { // 등록 성공
			return JsonResult.success(count);
		}
	}

	/* 디스플레이 등록 */
	@PostMapping("/api/add/display")
	public JsonResult addDisplay(@RequestBody unionVo unionVo) {
		System.out.println("AdminController.addDisplay()");

		int count = adminService.exeAddDisplay(unionVo);

		if (count != 1) { // 등록 실패
			return JsonResult.fail("등록 실패");
		} else { // 등록 성공
			return JsonResult.success(count);
		}
	}

	/* 용량 등록 */
	@PostMapping("/api/add/storage")
	public JsonResult addStorage(@RequestBody unionVo unionVo) {
		System.out.println("AdminController.addStorage()");

		int count = adminService.exeAddStorage(unionVo);

		if (count != 1) { // 등록 실패
			return JsonResult.fail("등록 실패");
		} else { // 등록 성공
			return JsonResult.success(count);
		}
	}

	/* 시리즈 가져오기 */
	@GetMapping("/api/series")
	public JsonResult getSeriesList() {
		System.out.println("AdminController.getSeriesList()");

		List<unionVo> seriesList = adminService.exeGetSeriesList();

		return JsonResult.success(seriesList);
	}

	/* 상품명 가져오기 */
	@GetMapping("/api/product/{seriesNum}")
	public JsonResult getProductList(@PathVariable("seriesNum") int seriesNum) {
		System.out.println("AdminController.getProductList()");

		List<unionVo> productList = adminService.exeGetProductList(seriesNum);

		return JsonResult.success(productList);
	}

	/* ＃＃＃＃＃＃＃＃＃＃＃＃＃ 상품 상세 등록에서 옵션 리스트 ＃＃＃＃＃＃＃＃＃＃＃＃＃ */
	/* 색상 가져오기 */
	@GetMapping("/api/color/{seriesNum}/{productNum}")
	public JsonResult getColorList(@PathVariable("seriesNum") int seriesNum,
			@PathVariable("productNum") int productNum) {
		System.out.println("AdminController.getColorList()");

		// 서비스 레이어에서 seriesNum과 productNum을 넘겨줌
		List<unionVo> colorList = adminService.exeGetColorList(seriesNum, productNum);

		return JsonResult.success(colorList);
	}

	/* 디스플레이 가져오기 */
	@GetMapping("/api/display/{seriesNum}/{productNum}")
	public JsonResult getDisplayList(@PathVariable("seriesNum") int seriesNum,
			@PathVariable("productNum") int productNum) {
		System.out.println("AdminController.getDisplayList()");

		// 서비스 레이어에서 seriesNum과 productNum을 넘겨줌
		List<unionVo> displayList = adminService.exeGetDisplayList(seriesNum, productNum);

		return JsonResult.success(displayList);
	}

	/* 용량 가져오기 */
	@GetMapping("/api/storage/{seriesNum}/{productNum}")
	public JsonResult getStorageList(@PathVariable("seriesNum") int seriesNum,
			@PathVariable("productNum") int productNum) {
		System.out.println("AdminController.getStorageList()");

		// 서비스 레이어에서 seriesNum과 productNum을 넘겨줌
		List<unionVo> storageList = adminService.exeGetStorageList(seriesNum, productNum);

		return JsonResult.success(storageList);
	}

	/* 시리즈번호로 색상 상세정보 가져오기 */
	@GetMapping("/api/colors/{seriesNum}")
	public JsonResult getColorList2(@PathVariable("seriesNum") int seriesNum) {
		System.out.println(seriesNum);
		System.out.println("AdminController.getColorList2()");

		List<unionVo> colorList = adminService.exeGetColorList2(seriesNum);

		return JsonResult.success(colorList);
	}

	/* 시리즈 번호로 디스플레이 상세정보 가져오기 */
	@GetMapping("/api/displays/{seriesNum}")
	public JsonResult getDisplayList2(@PathVariable("seriesNum") int seriesNum) {
		System.out.println("AdminController.getDisplayList2()");

		List<unionVo> displayList = adminService.exeGetDisplayList2(seriesNum);

		return JsonResult.success(displayList);
	}

	/* 시리즈 번호로 용량 상세정보 가져오기 */
	@GetMapping("/api/storages/{seriesNum}")
	public JsonResult getStorageList2(@PathVariable("seriesNum") int seriesNum) {
		System.out.println("AdminController.getStorageList2()");

		List<unionVo> storageList = adminService.exeGetStorageList2(seriesNum);

		return JsonResult.success(storageList);
	}

	/* 시리즈 번호로 상품 상세정보 가져오기(add6) */
	@GetMapping("/api/product/details/{seriesNum}")
	public JsonResult getProductDetail(@PathVariable("seriesNum") int seriesNum) {
		System.out.println("AdminController.getProductDetail()");

		List<ProductDetailVo> productDetailList = adminService.exeGetProductDetail(seriesNum);

		return JsonResult.success(productDetailList);
	}

	/* 시리즈 번호로 상품 리스트 가져오기(add2) */
	@GetMapping("/api/products/{seriesNum}")
	public JsonResult getProductList2(@PathVariable("seriesNum") int seriesNum) {
		System.out.println("AdminController.getProductList2()");

		List<unionVo> productList = adminService.exeGetProductList2(seriesNum);

		return JsonResult.success(productList);
	}

	/* 시리즈 삭제 */
	@DeleteMapping("/api/delete/series/{seriesNum}")
	public JsonResult deleteSeries(@PathVariable(value = "seriesNum") int seriesNum) {
		System.out.println("AdminController.delSeries()");

		boolean existsInProduct = adminService.checkProduct(seriesNum);

		if (existsInProduct) {
			return JsonResult.fail("해당 시리즈에 연결된 상품이 있어 삭제할 수 없습니다.");
		} else {
			int count = adminService.exDeleteSeries(seriesNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}
		}
	}

	/* 상품 삭제 */
	@DeleteMapping("/api/delete/product/{productNum}")
	public JsonResult deleteProduct(@PathVariable(value = "productNum") int productNum) {
		System.out.println("AdminController.deleteProduct()");

		// 하위 테이블들이 상품번호를 가지고 있는지 확인
		boolean existsInColor = adminService.checkColor(productNum);
		boolean existsInDisplay = adminService.checkDisplay(productNum);
		boolean existsInStorage = adminService.checkStorage(productNum);

		if (existsInColor || existsInDisplay || existsInStorage) {
			return JsonResult.fail("해당 시리즈는 색상, 디스플레이, 용량 중 하나에서 사용 중이기 때문에 삭제할 수 없습니다.");
		} else {
			int count = adminService.exDeleteProduct(productNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}
		}
	}

	/* 색상 삭제 */
	@DeleteMapping("/api/delete/color/{colorNum}")
	public JsonResult deleteColor(@PathVariable(value = "colorNum") int colorNum) {
		System.out.println("AdminController.deleteColor()");

		boolean existsInProductDetail = adminService.checkProductDetailColor(colorNum);

		if (existsInProductDetail) {
			return JsonResult.fail("해당 색상은 상품 세부 정보에서 사용 중이므로 삭제할 수 없습니다.");
		} else {
			int count = adminService.exDeleteColor(colorNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}
		}
	}

	/* 디스플레이 삭제 */
	@DeleteMapping("/api/delete/display/{displayNum}")
	public JsonResult deleteDisplay(@PathVariable(value = "displayNum") int displayNum) {
		System.out.println("AdminController.deleteDisplay()");

		boolean existsInProductDisplay = adminService.checkProductDetailDisplay(displayNum);

		if (existsInProductDisplay) {
			return JsonResult.fail("해당 디스플레이는 상품 세부 정보에서 사용 중이므로 삭제할 수 없습니다.");
		} else {
			int count = adminService.exDeleteDisplay(displayNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}

		}

	}

	/* 용량 삭제 */
	@DeleteMapping("/api/delete/storage/{storageNum}")
	public JsonResult deleteStorage(@PathVariable(value = "storageNum") int storageNum) {
		System.out.println("AdminController.deleteStorage()");

		boolean existsInProductStorage = adminService.checkProductDetailStorage(storageNum);

		if (existsInProductStorage) {
			return JsonResult.fail("해당 용량은 상품 세부 정보에서 사용 중이므로 삭제할 수 없습니다.");
		} else {
			int count = adminService.exDeleteStorage(storageNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}
		}
	}

	/* 상품 상세정보 삭제 */
	@DeleteMapping("/api/delete/productDetail/{productDetailNum}")
	public JsonResult deleteProductDetail(@PathVariable(value = "productDetailNum") int productDetailNum) {
		System.out.println("AdminController.deleteProductDetail()");

		System.out.println("--------");
		System.out.println(productDetailNum);
		// 구매내역에 사용되었는지 확인
		boolean existsInHistory = adminService.checkHistory(productDetailNum);
		System.out.println("테스트");
		System.out.println(existsInHistory);

		if (existsInHistory) {
			return JsonResult.fail("해당 상품은 이미 구매된 기록이 있어 삭제할 수 없습니다.");
		} else {
			int count = adminService.exDeleteProductDetail(productDetailNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}
		}
	}

	/* 매장 등록 */
	@PostMapping("/api/add/store")
	public JsonResult addStore(@ModelAttribute StoreVo storeVo) {

		// 서비스로 store 정보를 전달하며 처리
		int count = adminService.exeAddStore(storeVo);

		if (count != -1) {
			return JsonResult.success(count); // 성공 시
		} else {
			return JsonResult.fail("매장 등록 실패"); // 실패 시
		}
	}

	/* 상품 리스트 모두 가져오기 */
//	@GetMapping("/api/productList")
//	public JsonResult getProductListAll() {
//		System.out.println("AdminController.getProductListAll()");
//
//		List<ProductDetailVo> productListAll = adminService.exeGetProductListAll();
//
//		return JsonResult.success(productListAll);
//	}

	@GetMapping("/api/productList")
	public JsonResult getProductListAll(@RequestParam(value = "keyword", required = false) String keyword) {
		System.out.println("AdminController.getProductListAll() - 검색어: " + keyword);

		// 키워드가 없으면 전체 목록을 반환하고, 키워드가 있으면 필터링하여 반환
		List<ProductDetailVo> productListAll;

		if (keyword == null || keyword.isEmpty()) {
			// 키워드가 없을 경우 모든 제품 리스트 반환
			productListAll = adminService.exeGetProductListAll();
		} else {
			// 키워드가 있을 경우 필터링된 리스트 반환
			productListAll = adminService.searchProductListByKeyword(keyword);
		}

		return JsonResult.success(productListAll);
	}

	/* 상품 리스트에서 상품디테일번호 확인하고 삭제하기 */
	@DeleteMapping("/api/delete/productList/{productDetailNum}")
	public JsonResult deleteProductList(@PathVariable int productDetailNum) {
		// History 테이블에서 해당 productDetailNum이 있는지 확인
		boolean existsInHistory = adminService.checkHistory(productDetailNum);

		if (existsInHistory) {
			// History 테이블에 있으면 삭제 불가
			return JsonResult.fail("해당 상품은 이미 구매된 기록이 있어 삭제할 수 없습니다.");
		} else {
			// 삭제 처리
			int count = adminService.deleteProductList(productDetailNum);
			if (count > 0) {
				return JsonResult.success("삭제되었습니다.");
			} else {
				return JsonResult.fail("삭제 실패");
			}
		}
	}

	/* 상점 리스트 전체 */
	@GetMapping("/api/admin/store")
	public JsonResult getStoreList() {
		System.out.println("AdminController.exeStoreList()");
		List<StoreVo> storeList = adminService.exeStoreList();

		if (storeList != null) {
			return JsonResult.success(storeList);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}

	/* 매장 1개 정보 가져오기 */
	@GetMapping("/api/modify/store/{storeNum}")
	public JsonResult getStoreSelectOne(@PathVariable(value = "storeNum") int storeNum) {
		System.out.println("AdminController.getStoreSelectOne()");

		StoreVo storeVo = adminService.exeGetStoreSelectOne(storeNum);

		return JsonResult.success(storeVo);
	}

	/* 매장 수정하기 */
	@PutMapping("/api/update/store/{storeNum}")
	public JsonResult modifyStore(@ModelAttribute StoreVo storeVo) {

		int count = adminService.exeModifyStore(storeVo);

		if (count != -1) {
			return JsonResult.success(count); // 성공 시
		} else {
			return JsonResult.fail("매장 수정 실패"); // 실패 시
		}
	}

	/* 회원 리스트 가져오기 */
	@GetMapping("/api/admin/user")
	public JsonResult getUserList() {
		System.out.println("AdminController.exeUserList()");
		List<unionVo> userList = adminService.exeUserList();

		if (userList != null) {
			return JsonResult.success(userList);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}

	/* 회원 1명 정보 가져오기 */
	@GetMapping("/api/modify/user/{userNum}")
	public JsonResult getUserSelectOne(@PathVariable(value = "userNum") int userNum) {
		System.out.println("AdminController.getUserSelectOne()");

		unionVo userList = adminService.getStoreSelectOne(userNum);

		return JsonResult.success(userList);
	}

	/* 회원정보 수정하기 */
	@PutMapping("/api/update/user/{userNum}")
	public JsonResult modifyUser(@RequestBody unionVo unionVo) {

		int count = adminService.exeModifyUser(unionVo);

		if (count != -1) {
			return JsonResult.success(count); // 성공 시
		} else {
			return JsonResult.fail("매장 수정 실패"); // 실패 시
		}
	}

	/* 선택한 상품 상세정보 1개 가져오기 */
	@GetMapping("/api/select/productDetail/{productDetailNum}")
	public JsonResult selectOneProductDetail(@PathVariable(value = "productDetailNum") int productDetailNum) {
		System.out.println("@@@@@@@@@@@@");
		System.out.println(productDetailNum);

		ProductDetailVo productDetailVo = adminService.exeSelectOneProductDetail(productDetailNum);

		if (productDetailVo != null) {
			return JsonResult.success(productDetailVo);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}

	/* 선택한 상품의 상세 이미지 가져오기 */
	@GetMapping("/api/select/productDetailImg/{productDetailNum}")
	public JsonResult selectOneProductDetailImg(@PathVariable(value = "productDetailNum") int productDetailNum) {
		System.out.println("@@@@@@@@@@@@");
		System.out.println(productDetailNum);

		List<ProductDetailVo> productDetailList = adminService.exeProductDetailImg(productDetailNum);

		if (productDetailList != null) {
			return JsonResult.success(productDetailList);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}

	/* 상품상세 정보 수정하기 */
	@PutMapping("/api/update/productDetail/{productDetailNum}")
	public JsonResult modifyProductDetail(@PathVariable("productDetailNum") int productDetailNum,
			@RequestParam("seriesName") String seriesName, @RequestParam("productName") String productName,
			@RequestParam("colorName") String colorName, @RequestParam("colorCode") String colorCode,
			@RequestParam("displaySize") String displaySize, @RequestParam("storageSize") String storageSize,
			@RequestParam("productPrice") int productPrice, @RequestParam("imageSavedName") List<MultipartFile> files) {

		ProductDetailVo productDetailVo = new ProductDetailVo();
		productDetailVo.setProductDetailNum(productDetailNum);
		productDetailVo.setSeriesName(seriesName);
		productDetailVo.setProductName(productName);
		productDetailVo.setColorName(colorName);
		productDetailVo.setColorCode(colorCode);
		productDetailVo.setDisplaySize(displaySize);
		productDetailVo.setStorageSize(storageSize);
		productDetailVo.setProductPrice(productPrice);

		int count = adminService.exeModifyDetailWithImages(productDetailVo, files);

		if (count != -1) {
			return JsonResult.success(count);
		} else {
			return JsonResult.fail("상품 수정 실패");
		}
	}

}
