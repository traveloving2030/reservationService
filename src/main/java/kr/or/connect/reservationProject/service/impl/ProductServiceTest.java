package kr.or.connect.reservationProject.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservationProject.config.ApplicationConfig;
import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.service.ProductService;

public class ProductServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		ProductService ProductService = ac.getBean(ProductService.class);
		

//		List<Product> result = ProductService.getProductByCategoryId(2, 1);
//		System.out.println(result);
		List<Product> result = ProductService.getPromotionImage();
		System.out.println(result);
		
	}
}
