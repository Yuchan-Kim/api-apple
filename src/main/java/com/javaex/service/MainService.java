package com.javaex.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MainDao;
import com.javaex.vo.unionVo;

@Service
public class MainService {
    
    @Autowired
    private MainDao maindao;
    
    public List<unionVo> getProProducts() {
        return maindao.getProProducts();
    }

    public List<unionVo> getRegularProducts() {
        return maindao.getRegularProducts();
    }

    public List<unionVo> getSEModels() {
        return maindao.getSEModels();
    }
    
    
    
    
    public List<unionVo> searchProducts(String keyword) {
        return maindao.searchProducts(keyword);
    }
    
    public List<unionVo> searchStores(String keyword) {
        return maindao.searchStores(keyword);
    }
    
    public List<unionVo> searchCommunities(String keyword) {
        return maindao.searchCommunities(keyword);
    }
    
    
    
    
    
    public unionVo getProductBasicInfo(int productDetailNum) {
    	System.out.println("MainService.getProductBasicInfo()");

        return maindao.getProductBasicInfo(productDetailNum);
    }
    
    public List<unionVo> getProductImages(int productDetailNum) {
    	System.out.println("MainService.getProductImages()");

        return maindao.getProductImages(productDetailNum);
    }
    
    public List<unionVo> getInfoImages(int productDetailNum) {
    	System.out.println("MainService.getInfoImages()");

        return maindao.getInfoImages(productDetailNum);
    }
    
    public List<unionVo> getProductColors(int productDetailNum) {
        return maindao.getProductColors(productDetailNum);
    }
    
    public List<unionVo> getAnotherProProducts(int productDetailNum) {
        return maindao.getAnotherProProducts(productDetailNum);
    }

    public List<unionVo> getAnotherRegularProducts(int productDetailNum) {
        return maindao.getAnotherRegularProducts(productDetailNum);
    }

    public List<unionVo> getAnotherSeProducts(int productDetailNum) {
        return maindao.getAnotherSeProducts(productDetailNum);
    }
    
    public List<unionVo> getOtherSotrages(int productDetailNum) {
        return maindao.getOtherSotrages(productDetailNum);
    }
    
    
    
    
    public List<unionVo> getAccs() {
        return maindao.getAccs();
    }
    
    public List<unionVo> getRelatedProducts(int productDetailNum) {
        return maindao.getRelatedProducts(productDetailNum);
    }

    
 // 장바구니 추가
 	public int exeaddToCart(unionVo unionvo) {
 		int existingCount = maindao.checkCartItemExists(unionvo);
 		System.out.println("MainService.exeaddToCart()");
 		if (existingCount != 0) {
 			// 이미 존재하는 경우 업데이트
 			maindao.updateCartItemCount(unionvo);
 			System.out.println("상품 있음 수량+1");
 		} else {
 			// 존재하지 않는 경우 새로 삽입
 			maindao.insertCartItem(unionvo);
 			System.out.println("장바구니에 추가+1");
 		}
 		return existingCount;
 	}
 	
 // 위시리스트에 추가
 	public int exeAddToLiked(unionVo unionvo) {
 	    int existingCount = maindao.checkLikedItemExists(unionvo);
 	    System.out.println("MainService.exeAddToLiked()");
 	    if (existingCount != 0) {
 	        // 이미 존재하는 경우 별도의 동작 (필요하다면 추가 로직 구현)
 	        System.out.println("위시리스트에 이미 존재하는 상품");
 	    } else {
 	        // 존재하지 않는 경우 새로 삽입
 	        maindao.insertLikedItem(unionvo);
 	        System.out.println("위시리스트에 상품 추가");
 	    }
 	    return existingCount;
 	}


 	
    public List<unionVo> getWishlistByUser(int userNum) {
        return maindao.getWishlistByUser(userNum);
    }
 	public int removeAllLikedProducts(int userNum) {
 	    return maindao.deleteAllLikedProducts(userNum);
 	}

}
