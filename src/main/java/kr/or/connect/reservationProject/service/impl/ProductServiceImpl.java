package kr.or.connect.reservationProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservationProject.dao.CategoryDao;
import kr.or.connect.reservationProject.dao.ProductDao;
import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public List<Product> getAllProducts(Integer start){
		List<Product> list = productDao.selectAll(start, ProductService.LIMIT);
		return list;
	}

	@Override
	public List<Product> getProductByCategoryId(Integer category_id, Integer start) {
		List<Product> list = productDao.selectProductByCategoryId(category_id, start, ProductService.LIMIT);
		return list;
	}

	@Override
	public int getAllProductCount() {
		return productDao.selectAllProdCount();
	}

	@Override
	public int getProductCountByCategory(Integer category_id) {
		return productDao.selectProdCountByCategory(category_id);
	}

	@Override
	public List<Product> getPromotionImage() {
		List<Product> list = productDao.selectPromotion();
		return list;
	}



}
