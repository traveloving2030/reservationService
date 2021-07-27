package kr.or.connect.reservationProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservationProject.dao.ProductDao;
import kr.or.connect.reservationProject.dao.ProductDetailDao;
import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService{
	@Autowired
	ProductDetailDao productDetailDao;

	
	@Override
	@Transactional
	public List<ProductDetail> getProductDetail(Integer productId){
		List<ProductDetail> list = productDetailDao.selectDetailProduct(productId);
		return list;
	}
	
	@Override
	@Transactional
	public List<ProductDetail> getDetailComment(Integer productId){
		List<ProductDetail> list = productDetailDao.selectDetailComment(productId);
		return list;
	}
	
	@Override
	@Transactional
	public List<Product> getDetailProductForMap(Integer productId){
		List<Product> list = productDetailDao.selectDetailProductForMap(productId);
		return list;
	}
	
	
	@Override
	public int getCommentCount(Integer productId) {
		return productDetailDao.selectCommentCount(productId);
	}
	
	@Override
	public int getDetailImgCount(Integer productId) {
		return productDetailDao.selectDetailImgCount(productId);
	}
	
}
