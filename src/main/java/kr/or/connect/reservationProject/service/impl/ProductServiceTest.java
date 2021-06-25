package kr.or.connect.reservationProject.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservationProject.config.ApplicationConfig;
import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.service.DetailService;
import kr.or.connect.reservationProject.service.ProductService;

public class ProductServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
//		ProductService ProductService = ac.getBean(ProductService.class);
		DetailService DetailService = ac.getBean(DetailService.class);

		List<ProductDetail> result = DetailService.getProductDetail(2);
		
		System.out.println(result);

		
	}
}
