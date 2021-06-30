package kr.or.connect.reservationProject.service;

import java.util.List;

import kr.or.connect.reservationProject.dto.ProductDetail;

public interface DetailService {
	public List<ProductDetail> getProductDetail(Integer productId);
	public List<ProductDetail> getDetailComment(Integer productId);
	public int getCommentCount(Integer productId); 
}
