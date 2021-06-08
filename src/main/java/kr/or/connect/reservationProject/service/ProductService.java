package kr.or.connect.reservationProject.service;

import java.util.List;

import kr.or.connect.reservationProject.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Product> getAllProducts(Integer start);
	public List<Product> getProductByCategoryId(Integer category_id, Integer start);
	public int getAllProductCount();
	public int getProductCountByCategory(Integer category_id);
	public List<Product> getPromotionImage();
}
