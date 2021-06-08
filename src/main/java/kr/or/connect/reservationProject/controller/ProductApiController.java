package kr.or.connect.reservationProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		map.put("productAllList", allProductList);
		map.put("productAllCount", productAllCount);
		map.put("productPageStartList", productPageStartList);
		
		return map;
	}
	
	@GetMapping("/products/{category}")
	public Map<String, Object> productListByCategory(@RequestParam(name="start", required = false, defaultValue = "0") int start,  @RequestParam(name="category_id", required = false) int category_id){
		
		List<Product> productListByCategoryId = productService.getProductByCategoryId(category_id, start);
		
		int productCountByCategoryId = productService.getProductCountByCategory(category_id);
		int pageCount = productCountByCategoryId / productService.LIMIT;
		if(productCountByCategoryId % productService.LIMIT > 0) {
			pageCount ++;
		}
	
		List<Integer> productPageStartList = new ArrayList<>();
		
		for(int i = 0; i < pageCount; i++) {
			productPageStartList.add(i * ProductService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("productListByCategory", productListByCategoryId);
		map.put("productCountByCategory", productCountByCategoryId);
		map.put("productPageStartList", productPageStartList);

		return map;
	}
	
}
