package kr.or.connect.reservationProject.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservationProject.config.ApplicationConfig;
import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.service.ReservationService;


public class reservationTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
//		ProductService ProductService = ac.getBean(ProductService.class);
		ReservationService ReservationService = ac.getBean(ReservationService.class);
		

		
		int result = ReservationService.getTotalReservation();
		System.out.println(result);
	}

}
