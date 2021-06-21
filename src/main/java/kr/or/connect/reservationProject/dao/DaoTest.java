package kr.or.connect.reservationProject.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import kr.or.connect.reservationProject.config.ApplicationConfig;
import kr.or.connect.reservationProject.dto.ProductDetail;

public class DaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		
		ProductDetailDao detail = ac.getBean(ProductDetailDao.class);


		List<ProductDetail> list = detail.selectDetailComment(1);
		
		for(ProductDetail pd: list) {
			System.out.println(pd);
		}
	}
}
