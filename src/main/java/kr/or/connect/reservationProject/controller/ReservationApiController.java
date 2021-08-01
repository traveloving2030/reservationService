package kr.or.connect.reservationProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.dto.Reservation;
import kr.or.connect.reservationProject.service.DetailService;
import kr.or.connect.reservationProject.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired
	DetailService detailService;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/reserve/{productId}")
	public Map<String, Object> reservationByProductId(@PathVariable(name="productId") int productId){
		List<ProductDetail> productDetails = detailService.getProductDetail(productId);
		List<Reservation> productPrice = reservationService.getProductPrice(productId);
		Map<String, Object> map = new HashMap<>();
		map.put("productDetail", productDetails);
		map.put("productPrice", productPrice);
		return map;
	}
	
	@GetMapping("/myreservation/{email}")
	public Map<String, Object> myreservationByEmail(@PathVariable(name="email") String email){
		List<Reservation> reservationInfo = reservationService.getReservationInfo(email);
		List<Reservation> reservationGroupbyPriceType = reservationService.getReservationGroupbyPriceType(email);
		Map<String, Object> map = new HashMap<>();
		map.put("reservationInfo", reservationInfo);
		map.put("reservationGroupbyPriceType", reservationGroupbyPriceType);	
		return map;
	}
	
	@PostMapping
	public Reservation[] addReservation(@RequestBody Reservation reservation,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		Reservation[] reservationArr = new Reservation[2];
		reservationArr[0] = reservationService.addReservationInfo(reservation, clientIp);
		reservationArr[1] = reservationService.addReservationInfoPrice(reservation);
		return reservationArr;
	}
	

}
