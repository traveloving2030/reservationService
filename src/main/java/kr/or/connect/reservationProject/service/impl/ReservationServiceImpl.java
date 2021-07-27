package kr.or.connect.reservationProject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import kr.or.connect.reservationProject.dao.ProductDetailDao;
import kr.or.connect.reservationProject.dao.ReservationDao;
import kr.or.connect.reservationProject.dto.Log;
import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.dto.Reservation;
import kr.or.connect.reservationProject.service.ReservationServcie;

@Service
public class ReservationServiceImpl implements ReservationServcie {
	@Autowired
	ProductDetailDao productDetailDao;

	@Autowired
	ReservationDao reservationDao;
	
	@Override
	@Transactional
	public List<ProductDetail> getProductDetail(Integer productId){
		List<ProductDetail> list = productDetailDao.selectDetailProduct(productId);
		return list;
	}
	
	@Override
	public int getTotalReservation() {
		return reservationDao.selectReservationCount();
	}
	
	@Override
	@Transactional
	public List<Reservation> getReservationInfo(String email){
		List<Reservation> list = reservationDao.selectReservationInfo(email);
		return list;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Reservation addReservation(Reservation reservation, Integer productId, Integer display_info_id, String ip) {
		guestbook.setRegdate(new Date());
		int id = reservationDao.insert(reservation);
		guestbook.setId(id);
		
//		if(1 == 1)
//			throw new RuntimeException("test exception");
//			
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		
		return guestbook;
	}
	
}
