package kr.or.connect.reservationProject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.dto.Reservation;
import kr.or.connect.reservationProject.service.DetailService;
import kr.or.connect.reservationProject.service.ReservationService;

@Controller
public class ReservationController {
	
	// controller에서 Reservation DTO 에 대해 SetId, Set ... 다 해주기!ddd
	
	@Autowired
	DetailService detailService;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping(path="/reserve")
	public String reserve(@RequestParam(name="productId") int productId, ModelMap model) {
		List<ProductDetail> productDetails = detailService.getProductDetail(productId);
		List<Reservation> productPrice = reservationService.getProductPrice(productId);
		Reservation reservation = new Reservation();
		
		Date date = new Date();
		reservation.setReservation_date(date);
		Date resvDate = reservation.getReservation_date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
		String Date = formatter.format(resvDate);
		
		model.addAttribute("productDetails", productDetails);
		model.addAttribute("productId", productId);
		model.addAttribute("productPrice", productPrice);
		model.addAttribute("resrvDate", Date);
		return "reserve";
	}
	
	@PostMapping(path="/addReservation")
	public String addReservation(@ModelAttribute Reservation reservation,
							@ModelAttribute Reservation reservation2,
							HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		reservationService.addReservationInfo(reservation, clientIp);
		reservationService.addReservationInfoPrice(reservation2);
		return "redirect:/reserve";
	}
	
	@GetMapping(path="/myreservation")
	public String myreservation(@RequestParam(name="email") String email, ModelMap model) {
		List<Reservation> reservationInfo = reservationService.getReservationInfo(email);
		List<Reservation> reservationGroupbyPriceType = reservationService.getReservationGroupbyPriceType(email);
		model.addAttribute("reservationInfo", reservationInfo);
		model.addAttribute("reservationGroupbyPriceType", reservationGroupbyPriceType);
		return "myreservation";
	}
	
	@PostMapping(path="/myreservation")
	public String bookingLogin(@RequestParam(name="resrv_email", required=true) String email,
			ModelMap model,
			HttpSession session,
			RedirectAttributes redirectAttr
			) {
			List<Reservation> reservationInfo = reservationService.getReservationInfo(email);
			reservationInfo.forEach(obj -> {
				if(obj.getReservation_email().equals(email)) {
					session.setAttribute("isValidUser", "true");
				}else {
					redirectAttr.addFlashAttribute("errorMessage","등록되지 않은 이메일입니다.");
				}
			});
			
			return "myreservation";
	}
	
	
	
	
	
	
}
