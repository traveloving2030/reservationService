package kr.or.connect.reservationProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;

import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/")
	public String main(@RequestParam(name="start", required=false, defaultValue="0") int start, ModelMap model) {
		
		
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
		
		model.addAttribute("productAllList", allProductList);
		model.addAttribute("productAllCount", productAllCount);
		model.addAttribute("productPageStartList", productPageStartList);
		
		return "main";
	}
	
	@GetMapping(path="/bookinglogin")
	public String bookingLogin() {
		
		return "bookinglogin";
	}
	
	@GetMapping(path="/detail/{productId}")
	public String detail() {
		return "detail";
	}
	
	@GetMapping(path="/myreservation")
	public String myReservation() {
		return "myreservation";
	}
	
	@GetMapping(path="/reserve")
	public String reserve() {
		return "reserve";
	}
	
	@GetMapping(path="/review")
	public String review() {
		return "review";
	}
	
	@GetMapping(path="/reviewWrite")
	public String reviewWrite() {
		return "reviewWrite";
	}
	
	
}
