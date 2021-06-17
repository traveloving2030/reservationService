package kr.or.connect.reservationProject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.service.ProductService;

@RestController
@RequestMapping(path="/api")
public class ProductApiController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/promotions")
	public Map<String, Object> promotionImage(){
		List<Product> promotionImage = productService.getPromotionImage();
		Map<String, Object> map = new HashMap<>();
		map.put("promotionImage", promotionImage);
		return map;
	}
	
	@GetMapping("/products")
	public Map<String, Object> allProductList(@RequestParam(name="start", required = false, defaultValue = "0") int start){
		
		List<Product> allProductList = productService.getAllProducts(start);
		
		int productAllCount = productService.getAllProductCount();
		int pageCount = productAllCount / productService.LIMIT;
		if(productAllCount % productService.LIMIT > 0) {
			pageCount ++;
		}
	
		List<Integer> productPageStartList = new ArrayList<>();
		
		for(int i = 0; i < pageCount; i++) {
			productPageStartList.add(i * ProductService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("productList", allProductList);
		map.put("productCount", productAllCount);
		map.put("productPageStartList", productPageStartList);
		
		return map;
	}
	
	@GetMapping("/products/{category}")
	public Map<String, Object> productListByCategory(@RequestParam(name="start", required = false, defaultValue = "0") int start,  @PathVariable(name="category") int category){
		
		List<Product> productListByCategoryId = productService.getProductByCategoryId(category, start);
		
		int productCountByCategoryId = productService.getProductCountByCategory(category);
		int pageCount = productCountByCategoryId / productService.LIMIT;
		if(productCountByCategoryId % productService.LIMIT > 0) {
			pageCount ++;
		}
	
		List<Integer> productPageStartList = new ArrayList<>();
		
		for(int i = 0; i < pageCount; i++) {
			productPageStartList.add(i * ProductService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("productList", productListByCategoryId);
		map.put("productCount", productCountByCategoryId);
		map.put("productPageStartList", productPageStartList);

		return map;
	}
	
}
