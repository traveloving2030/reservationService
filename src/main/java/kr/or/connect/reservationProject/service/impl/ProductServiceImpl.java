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
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public List<Product> getAllProducts(Integer start){
		List<Product> list = productDao.selectAll(start, ProductService.LIMIT);
		return list;
	}

	@Override
	public List<Product> getProductByCategoryId(Integer start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProductCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
