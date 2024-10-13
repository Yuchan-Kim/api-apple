package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MainService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.unionVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MainController {
    
    @Autowired
    private MainService mainservice;
    
    @GetMapping("api/main/products/pro")
    public JsonResult getProProducts() {
        System.out.println("MainController.getProProducts()");
        List<unionVo> proProducts = mainservice.getProProducts();
        return JsonResult.success(proProducts); 
    }

    @GetMapping("api/main/products/regular")    
    public JsonResult getRegularProducts() {
        System.out.println("MainController.getRegularProducts()");
        List<unionVo> regularProducts = mainservice.getRegularProducts();
        return JsonResult.success(regularProducts);
    }

    @GetMapping("api/main/products/se") 
    public JsonResult getSEModels() {
        System.out.println("MainController.getSEModels()");
        List<unionVo> seModels = mainservice.getSEModels();
        return JsonResult.success(seModels);
    }
    
    @GetMapping("api/main/products/acc")
    public JsonResult getAccs() {
        System.out.println("MainController.getAccs()");
        List<unionVo> accModels = mainservice.getAccs();
        return JsonResult.success(accModels);
    }
    
    
    
    @GetMapping("api/search/products/{keyword}")
    public JsonResult searchProducts(@PathVariable String keyword) {
        System.out.println("제품 검색어: " + keyword);
        try {
            List<unionVo> searchResults = mainservice.searchProducts(keyword);
            System.out.println("검색된 제품 수: " + searchResults.size());
            return JsonResult.success(searchResults);
        } catch (Exception e) {
            return JsonResult.fail("제품 검색 중 오류가 발생했습니다.");
        }
    }
    
    @GetMapping("api/search/stores/{keyword}")
    public JsonResult searchStores(@PathVariable String keyword) {
        System.out.println("매장 검색어: " + keyword);
        try {
            List<unionVo> searchResults = mainservice.searchStores(keyword);
            System.out.println("검색된 매장 수: " + searchResults.size());
            return JsonResult.success(searchResults);
        } catch (Exception e) {
            return JsonResult.fail("매장 검색 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("api/search/communities/{keyword}")
    public JsonResult searchCommunities(@PathVariable String keyword) { 
        System.out.println("커뮤니티 검색어: " + keyword);
        try {
            List<unionVo> searchResults = mainservice.searchCommunities(keyword);
            System.out.println("검색된 커뮤니티 수: " + searchResults.size());
            return JsonResult.success(searchResults);
        } catch (Exception e) {
            return JsonResult.fail("커뮤니티 검색 중 오류가 발생했습니다.");
        } 
    }
    
    
    
    @GetMapping("api/product/{productDetailNum}/primaryImage2")
    public JsonResult getImageWithPrimaryTwo(@PathVariable int productDetailNum) {
        System.out.println("MainController.getImageWithPrimaryTwo()");
        List<unionVo> images = mainservice.getImageWithPrimaryTwo(productDetailNum);
        return JsonResult.success(images);
    }
    @GetMapping("api/product/{productDetailNum}/info")
    public JsonResult getProductBasicInfo(@PathVariable int productDetailNum) {
        System.out.println("MainController.getProductBasicInfo()");
        try {
            unionVo productBasicInfo = mainservice.getProductBasicInfo(productDetailNum);
            if (productBasicInfo != null) {
                return JsonResult.success(productBasicInfo); // 성공 응답
            } else {
                return JsonResult.fail("제품 정보를 찾을 수 없습니다."); // 실패 응답
            }
        } catch (Exception e) {
            return JsonResult.fail("서버에서 오류가 발생했습니다."); // 예외 처리
        }
    }
    
    @GetMapping("api/productAcc/{productDetailNum}/info")
    public JsonResult getProductAccBasicInfo(@PathVariable int productDetailNum) {
        System.out.println("MainController.getProductBasicInfo()");
        try {
            unionVo productBasicInfo = mainservice.getProductBasicInfo(productDetailNum);
            if (productBasicInfo != null) {
                return JsonResult.success(productBasicInfo); // 성공 응답
            } else {
                return JsonResult.fail("제품 정보를 찾을 수 없습니다."); // 실패 응답
            }
        } catch (Exception e) {
            return JsonResult.fail("서버에서 오류가 발생했습니다."); // 예외 처리
        }
    }
    
    @GetMapping("api/product/{productDetailNum}/relatedProducts")
    public JsonResult getRelatedProducts(@PathVariable int productDetailNum) {
        List<unionVo> relatedProducts = mainservice.getRelatedProducts(productDetailNum);
        return JsonResult.success(relatedProducts);
    }

    
    @GetMapping("api/product/{productDetailNum}/productimages")
    public JsonResult getProductImages(@PathVariable int productDetailNum) {
        System.out.println("MainController.getProductImages()");

        List<unionVo> images = mainservice.getProductImages(productDetailNum);
        return JsonResult.success(images);
    }
    
    @GetMapping("api/productAcc/{productDetailNum}/productimages")
    public JsonResult getProductAccImages(@PathVariable int productDetailNum) {
        System.out.println("MainController.getProductImages()");

        List<unionVo> images = mainservice.getProductImages(productDetailNum);
        return JsonResult.success(images);
    }
    
    
    @GetMapping("api/product/{productDetailNum}/infoImages")
    public JsonResult getInfoImages(@PathVariable int productDetailNum) {
        System.out.println("MainController.getInfoImages()");

        List<unionVo> infoImages = mainservice.getInfoImages(productDetailNum);
        return JsonResult.success(infoImages);
    }
    
    @GetMapping("api/productAcc/{productDetailNum}/infoImages")
    public JsonResult getAccInfoImages(@PathVariable int productDetailNum) {
        System.out.println("MainController.getInfoImages()");

        List<unionVo> infoImages = mainservice.getInfoImages(productDetailNum);
        return JsonResult.success(infoImages);
    }
    
    
    @GetMapping("api/product/{productDetailNum}/colors")
    public JsonResult getProductColorsForPro(@PathVariable int productDetailNum) {
        List<unionVo> colors = mainservice.getProductColors(productDetailNum);
        return JsonResult.success(colors);
    }

    
    // pro 포함된 제품 정보 (상세페이지용)
    @GetMapping("api/product/{productDetailNum}/anotherPro")
    public JsonResult getProProducts(@PathVariable int productDetailNum) {
        List<unionVo> proProducts = mainservice.getAnotherProProducts(productDetailNum);
        return JsonResult.success(proProducts);
    }

    // pro, se 포함되지 않은 제품 정보 (상세페이지용)
    @GetMapping("api/product/{productDetailNum}/anotherRegular")
    public JsonResult getRegularProducts(@PathVariable int productDetailNum) {
        List<unionVo> regularProducts = mainservice.getAnotherRegularProducts(productDetailNum);
        return JsonResult.success(regularProducts);
    }

    // se 포함된 제품 정보 (상세페이지용)
    @GetMapping("api/product/{productDetailNum}/anotherSe")
    public JsonResult getSeProducts(@PathVariable int productDetailNum) {
        List<unionVo> seProducts = mainservice.getAnotherSeProducts(productDetailNum);
        return JsonResult.success(seProducts);
    }
    
    // 같은 제품 다른 사이즈 정보 (상세페이지용)
    @GetMapping("api/product/{productDetailNum}/storages")
    public JsonResult getOtherStorages(@PathVariable int productDetailNum) {
    	List<unionVo> anotherStorages = mainservice.getOtherSotrages(productDetailNum);
    	return JsonResult.success(anotherStorages);
    }
    
    
    
    
    
    
 // 장바구니에 담기
 	@PostMapping("api/product/addtocart")
 	public JsonResult addToCart(@RequestBody unionVo unionvo, HttpServletRequest request) {
 		// 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
 		int userNum = JwtUtil.getNoFromHeader(request);
 		// cartItemVo에 유저 정보 추가
 		unionvo.setUserNum(userNum);
 		System.out.println("장바구니 정보" + unionvo);

 		// 서비스 호출하여 장바구니에 아이템 추가
 		int count = mainservice.exeaddToCart(unionvo);

 		if (count > 0) {
 			return JsonResult.success("장바구니에 추가되었습니다.");
 		} else {
 			return JsonResult.fail("장바구니 추가 실패");
 		}
 	}
 	
 // 위시리스트에 상품 추가
 	@PutMapping("api/user/addtoliked")
 	public JsonResult addToLiked(@RequestBody unionVo unionvo, HttpServletRequest request) {
 	    // 토큰에서 유저 정보를 가져오는 로직 (예: userNum 추출)
 	    int userNum = JwtUtil.getNoFromHeader(request);
 	    // unionVo에 유저 정보 추가
 	    unionvo.setUserNum(userNum);
 	    System.out.println("위시리스트 정보" + unionvo);

 	    // 서비스 호출하여 위시리스트에 아이템 추가
 	    int count = mainservice.exeAddToLiked(unionvo);

 	    if (count == 0) {
 	        return JsonResult.success("위시리스트에 추가되었습니다.");
 	    } else {
 	        return JsonResult.fail("이미 위시리스트에 존재하는 상품입니다.");
 	    }
 	}
 	
 	@DeleteMapping("api/product/unlike")
 	public JsonResult removeAllLikedProducts(HttpServletRequest request) {
 	    // JWT 토큰에서 userNum을 추출
 	    int userNum = JwtUtil.getNoFromHeader(request);

 	    if (userNum == -1) {
 	        return JsonResult.fail("Invalid token");
 	    }

 	    // Service 호출하여 해당 유저의 모든 좋아요 상품 삭제
 	    int result = mainservice.removeAllLikedProducts(userNum);

 	    if (result > 0) {
 	        return JsonResult.success("모든 관심 상품이 삭제되었습니다.");
 	    } else {
 	        return JsonResult.fail("삭제할 관심 상품이 없습니다.");
 	    }
 	}
 	
 // 관심 목록 가져오기
    @GetMapping("/api/user/wishlist")
    public JsonResult getWishlist(HttpServletRequest request) {
        // JWT에서 userNum 추출
        int userNum = JwtUtil.getNoFromHeader(request);
        if (userNum == -1) {
            return JsonResult.fail("유효하지 않은 토큰입니다.");
        }

        List<unionVo> wishlistItems = mainservice.getWishlistByUser(userNum);
        return JsonResult.success(wishlistItems);
    }
 	
 	



}
