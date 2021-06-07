package kr.or.connect.reservationProject.controller;

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
	public String main(@RequestParam(name="start", required=false, defaultValue="0") int start, @RequestParam(name="category_id", required = false) int category_id, ModelMap model) {
		List<Product> allProductList = productService.getAllProducts(start);
		
		
		List<Product> productByCatgorList = productService.getAllProducts(start);
		return "main";
	}
	
	
}
