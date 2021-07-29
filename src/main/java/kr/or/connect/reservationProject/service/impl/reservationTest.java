package kr.or.connect.reservationProject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservationProject.config.ApplicationConfig;
import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.dto.Reservation;
import kr.or.connect.reservationProject.service.ReservationService;


public class reservationTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
//		ProductService ProductService = ac.getBean(ProductService.class);
		ReservationService ReservationService = ac.getBean(ReservationService.class);
		
//		Reservation reservation = new Reservation();
//		reservation.setProduct_id(1);
//		reservation.setReservation_email("traveloving2030@gmail.com");
//
//		List<Reservation> result = ReservationService.cancelReservation(reservation);
		
		List<Reservation> result = ReservationService.getReservationInfo("traveloving2030@gmail.com");
		
//		int result = ReservationService.getTotalReservation();
//		List<Reservation> result = ReservationService.getProductPrice(1);
		result.forEach(i -> {
			if(1==1) {
				System.out.println(i.getReservation_email());
			}
		});
	}

}
