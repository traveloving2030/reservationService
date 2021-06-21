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

import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.service.DetailService;

@RestController
@RequestMapping(path="/api")
public class DetailApiController {
	@Autowired
	DetailService detailService;
	
	@GetMapping("/detail/{productId}")
	public Map<String, Object> detailListByProductId(@PathVariable(name="productId") int productId){
		List<ProductDetail> productDetail = detailService.getProductDetail(productId);
		Map<String, Object> map = new HashMap<>();
		map.put("productDetail", productDetail);
		return map;
	}
	
	@GetMapping("/detail/comment")
	public Map<String, Object> detailComment(@PathVariable(name="productId") int productId){
		List<ProductDetail> comment = detailService.getDetailComment(productId);
		Map<String, Object> map = new HashMap<>();
		map.put("comment", comment);
		return map;
	}
	
	

}
