package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.unionVo;

@Repository
public class MainDao {
    
    @Autowired
    private SqlSession sqlsession;
    
    public List<unionVo> getProProducts() {
        return sqlsession.selectList("main.getProProducts");
    }

    public List<unionVo> getRegularProducts() {
        return sqlsession.selectList("main.getRegularProducts");
    }

    public List<unionVo> getSEModels() {
        return sqlsession.selectList("main.getSEModels");
    }
   
    
    public List<unionVo> getImageWithPrimaryTwo(int productDetailNum) {
        System.out.println("MainDao.getImageWithPrimaryTwo()");
        return sqlsession.selectList("main.getImageWithPrimaryTwo", productDetailNum);
    }
    
    
    
    
    
    public List<unionVo> searchProducts(String keyword) {
        return sqlsession.selectList("main.searchProducts", keyword);
    }
    
    public List<unionVo> searchStores(String keyword) {
        return sqlsession.selectList("main.searchStores", keyword);
    }
    
    public List<unionVo> searchCommunities(String keyword) {
        return sqlsession.selectList("main.searchCommunities", keyword);
    }
    
    
    
    

    public unionVo getProductBasicInfo(int productDetailNum) {
    	System.out.println("MainDao.getProductBasicInfo()");

        return sqlsession.selectOne("main.getProductBasicInfo", productDetailNum);
    }
    
    public List<unionVo> getProductImages(int productDetailNum) {
    	System.out.println("MainDao.getProductImages()");

        return sqlsession.selectList("main.getProductImages", productDetailNum);
    }
    
    public List<unionVo> getInfoImages(int productDetailNum) {
    	System.out.println("MainDao.getInfoImages()");

        return sqlsession.selectList("main.getInfoImages", productDetailNum);
    }
    
    public List<unionVo> getProductColors(int productDetailNum) {
    	System.out.println("MainDao.getProductColors()");

        return sqlsession.selectList("main.getProductColors", productDetailNum);
    }
    
    public List<unionVo> getAnotherProProducts(int productDetailNum) {
        return sqlsession.selectList("main.getAnotherProProducts", productDetailNum);
    }

    public List<unionVo> getAnotherRegularProducts(int productDetailNum) {
        return sqlsession.selectList("main.getAnotherRegularProducts", productDetailNum);
    }

    public List<unionVo> getAnotherSeProducts(int productDetailNum) {
        return sqlsession.selectList("main.getAnotherSeProducts", productDetailNum);
    }
    
    public List<unionVo> getOtherSotrages(int productDetailNum) {
        return sqlsession.selectList("main.getOtherSotrages", productDetailNum);
    }
    
    
    
    
    
    public List<unionVo> getAccs() {
        return sqlsession.selectList("main.getAccs");
    }
    public List<unionVo> getRelatedProducts(int productDetailNum) {
        return sqlsession.selectList("main.getRelatedProducts", productDetailNum);
    }

    
    
 // 장바구니에 같은 상품이 있는지 확인
 	public int checkCartItemExists(unionVo unionvo) {
 		Integer count = sqlsession.selectOne("main.checkCartItemExists", unionvo);
 		int itemCount = (count != null) ? count : 0;
 		return itemCount;
 	}

 	// 같은 상품이 있을경우 카운트만 업데이트
 	public int updateCartItemCount(unionVo unionvo) {
 		return sqlsession.update("main.updateCartItemCount", unionvo);
 	}

 	// 같은 상품이 없으면 인서트
 	public int insertCartItem(unionVo unionvo) {
 		return sqlsession.insert("main.insertCartItem", unionvo);
 	}

 // 위시리스트에 같은 상품이 있는지 확인
 	public int checkLikedItemExists(unionVo unionvo) {
 	    Integer count = sqlsession.selectOne("main.checkLikedItemExists", unionvo);
 	    int itemCount = (count != null) ? count : 0;
 	    return itemCount;
 	}

 	// 같은 상품이 없으면 위시리스트에 삽입
 	public int insertLikedItem(unionVo unionvo) {
 	    return sqlsession.insert("main.insertLikedItem", unionvo);
 	}

 	
 	

 	public List<unionVo> getWishlistByUser(int userNum) {
        return sqlsession.selectList("main.getWishlistByUser", userNum);
    }
 	
 	public int deleteAllLikedProducts(int userNum) {
 	    return sqlsession.delete("main.deleteAllLikedProducts", userNum);
 	}

    
   


}
