package kr.or.connect.reservationProject.service;

import java.util.List;


import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.dto.Reservation;

public interface ReservationService {
	public List<ProductDetail> getProductDetail(Integer productId);
	public int getTotalReservation();
	public List<Reservation> getReservationInfo(String email);
	public Reservation addReservation(Reservation reservation, String ip);
	public List<Reservation> getProductPrice(Integer productId);
	public List<Reservation> cancelReservation(Reservation reservation);
}
