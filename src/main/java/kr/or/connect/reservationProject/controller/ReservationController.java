package kr.or.connect.reservationProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
		model.addAttribute("productDetails", productDetails);
		model.addAttribute("productId", productId);
		model.addAttribute("productPrice", productPrice);
		return "reserve";
	}
	
	@PostMapping(path="/addPerson")
	public String addPerson(@ModelAttribute Reservation reservation,
							HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		reservationService.addNewPerson(reservation, clientIp);
		return "redirect:/reserve";
	}
	
	@PostMapping(path="/myreservation")
	public String bookingLogin(@RequestParam(name="resrv_email", required=true) String email,
			ModelMap model,
			HttpSession session,
			RedirectAttributes redirectAttr
			) {
			
		return "myreservation";
	}
	
	@GetMapping(path="/")
	
	
}
