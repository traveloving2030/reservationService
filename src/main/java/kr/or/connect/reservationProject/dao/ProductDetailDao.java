package kr.or.connect.reservationProject.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservationProject.dto.Product;
import kr.or.connect.reservationProject.dto.ProductDetail;
import static kr.or.connect.reservationProject.dao.ReservationProjectDaoSqls.*;

@Repository
public class ProductDetailDao {
	 private NamedParameterJdbcTemplate jdbc;
	 private SimpleJdbcInsert insertAction;
	 private RowMapper<ProductDetail> rowMapper = BeanPropertyRowMapper.newInstance(ProductDetail.class);
	 private RowMapper<Product> rowMapper2 = BeanPropertyRowMapper.newInstance(Product.class);
	 
	 public ProductDetailDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	 }
	 
	 public List<ProductDetail> selectDetailProduct(Integer productId){
 		Map<String, Integer> params = new HashMap<>();
 		params.put("productId", productId);
 		return jdbc.query(DETAIL_PRODUCT, params, rowMapper);
	 }
	 
	 public List<ProductDetail> selectDetailComment(Integer productId){
	 		Map<String, Integer> params = new HashMap<>();
	 		params.put("productId", productId);
	 		return jdbc.query(DETAIL_COMMENT, params, rowMapper);
	 }
	 
	 public List<Product> selectDetailProductForMap(Integer productId){
	 		Map<String, Integer> params = new HashMap<>();
	 		params.put("productId", productId);
	 		return jdbc.query(DETAIL_PRODUCT_FOR_MAP, params, rowMapper2);
	 }
	
	public int selectCommentCount(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
    	params.put("productId", productId);
		return jdbc.queryForObject(COMMENT_COUNT, params, Integer.class);
	}
	 
	public int selectDetailImgCount(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
    	params.put("productId", productId);
		return jdbc.queryForObject(DETAIL_PRODUCT_COUNT, params, Integer.class);
	}	 
}
