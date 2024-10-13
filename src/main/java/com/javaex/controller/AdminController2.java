package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.AdminService2;
import com.javaex.util.JsonResult;
import com.javaex.vo.ProductDetailVo;
import com.javaex.vo.StoreVo;
import com.javaex.vo.unionVo;

@RestController
public class AdminController2 {

	@Autowired
	private AdminService2 adminService2; 

	// store삭제
	@PutMapping("/api/admin/store/{no}")
	public JsonResult deleteStore(@PathVariable("no") int storeNum, @RequestBody StoreVo storeVo) {
		System.out.println("AdminController.exeDeleteStore()");

		int count = adminService2.exeDeleteStore(storeVo);

		if (count != 1) { // Update failed
			return JsonResult.fail("Update failed");
		} else { // Update success
			return JsonResult.success(count);
		}
	}

	// 유저 "삭제"
	@PutMapping("/api/admin/user/{no}")
	public JsonResult deleteUser(@PathVariable("no") int userNum, @RequestBody unionVo unionVo) {
		System.out.println("AdminController.exeDeleteUser()");

		int count = adminService2.exeDeleteUser(unionVo);

		if (count != 1) { // Update failed
			return JsonResult.fail("Update failed");
		} else { // Update success
			return JsonResult.success(count);
		}
	}

	@GetMapping("/api/admin/delivery")
	public JsonResult getDeliveryList() {
		System.out.println("AdminController.exeDeliveryList()");
		List<unionVo> deliveryList = adminService2.exeDeliveryList();

		if (deliveryList != null) {
			return JsonResult.success(deliveryList);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}

	@PutMapping("/api/admin/delivery/send/{no}")
	public JsonResult productSent(@PathVariable("no") int userNum, @RequestBody unionVo unionVo) {
		System.out.println("AdminController.productSent()");

		int count = adminService2.exeProductSent(unionVo);

		if (count != 1) { // Update failed
			return JsonResult.fail("Update failed");
		} else { // Update success
			return JsonResult.success(count);
		} 
	}

	@PutMapping("/api/admin/delivery/arrive/{no}")
	public JsonResult productArrived(@PathVariable("no") int userNum, @RequestBody unionVo unionVo) {
		System.out.println("AdminController.productArrived()");

		int count = adminService2.exeProductArrived(unionVo);

		if (count != 1) { // Update failed
			return JsonResult.fail("Update failed");
		} else { // Update success 
			return JsonResult.success(count);
		}
	}
	
	@PutMapping("/api/admin/delivery/pickup/{no}")
	public JsonResult pickUp(@PathVariable("no") int userNum, @RequestBody unionVo unionVo) {
		System.out.println("AdminController.pickUp()");

		int count = adminService2.exePickUp(unionVo);

		if (count != 1) { // Update failed
			return JsonResult.fail("Update failed");
		} else { // Update success 
			return JsonResult.success(count);
		}
	}

	@GetMapping("/api/admin/history")
	public JsonResult getHistoryList() {
		System.out.println("AdminController.exeHistoryList()");
		List<unionVo> historyList = adminService2.exeHistoryList();

		if (historyList != null) {
			return JsonResult.success(historyList);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}

	@GetMapping("/api/admin/product")
	public JsonResult getProductList() {
		System.out.println("AdminController.exeProductList()");
		List<unionVo> productList = adminService2.exeProductList();

		if (productList != null) {
			return JsonResult.success(productList);
		} else {
			return JsonResult.fail("데이터 없음");
		}
	}
	
	
	//-----2024/10/10
	@GetMapping("/api/store/detail/{storeNum}")
	public JsonResult getStoreSelectOne(@PathVariable(value = "storeNum") int storeNum) {
	    StoreVo storeVo = adminService2.exeGetStoreSelectOne(storeNum);
	    if (storeVo != null) {
	        return JsonResult.success(storeVo);
	    } else {
	        return JsonResult.fail("데이터 없음");
	    }
	}

	
	//-----------2024/10/12
	
	@GetMapping("/api/productList3")
	public JsonResult getProductListAll2() {
		System.out.println("AdminController2.getProductListAll2()");

		List<ProductDetailVo> productListAll = adminService2.exeGetProductListAll2();

		return JsonResult.success(productListAll);
	}


}
