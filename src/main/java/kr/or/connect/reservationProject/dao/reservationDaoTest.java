package kr.or.connect.reservationProject.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.reservationProject.config.ApplicationConfig;



public class reservationDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		ReservationDao reservationDao = ac.getBean(ReservationDao.class);
		int result = reservationDao.selectReservationCount();
		System.out.println(result);
	}

}
