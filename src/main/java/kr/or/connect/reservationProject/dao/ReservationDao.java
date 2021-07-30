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

import kr.or.connect.reservationProject.dto.ProductDetail;
import kr.or.connect.reservationProject.dto.Reservation;


import static kr.or.connect.reservationProject.dao.ReservationProjectDaoSqls.*;

@Repository
public class ReservationDao {
	 private NamedParameterJdbcTemplate jdbc;
	 private SimpleJdbcInsert insertAction;
	 private SimpleJdbcInsert insertAction2;
	 private RowMapper<ProductDetail> rowMapper = BeanPropertyRowMapper.newInstance(ProductDetail.class);
	 private RowMapper<Reservation> rowMapper2 = BeanPropertyRowMapper.newInstance(Reservation.class);
	 
	 public ReservationDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		 this.insertAction = new SimpleJdbcInsert(dataSource)
				 .withTableName("reservation_info")
				 .usingGeneratedKeyColumns("id");
		 this.insertAction2 = new SimpleJdbcInsert(dataSource)
				 .withTableName("reservation_info_price")
				 .usingGeneratedKeyColumns("id");
	 }
	 
	 public List<ProductDetail> selectDetailProduct(Integer productId){
	 		Map<String, Integer> params = new HashMap<>();
	 		params.put("productId", productId);
	 		return jdbc.query(DETAIL_PRODUCT, params, rowMapper);
	 }
	 
	 public Long addReservationInfo(Reservation reservation) {
			SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
			return insertAction.executeAndReturnKey(params).longValue();
	 }
	 
	 public Long addReservationInfoPrice(Reservation reservation) {
		 	SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
		 	return insertAction2.executeAndReturnKey(params).longValue();
	 }
	 
	 public List<Reservation> selectProductPrice(Integer productId){
	 		Map<String, Integer> params = new HashMap<>();
	 		params.put("productId", productId);
	 		return jdbc.query(PRODUCT_PRICE, params, rowMapper2);
	 }
	 
	 public List<Reservation> selectReservationGroupbyPrice(String email){
		 	Map<String, String> params = new HashMap<String,String>();
	 		params.put("email", email);
	 		return jdbc.query(RSERVATION_GROUPBY_PRICE_TYPE, params, rowMapper2);
	 }
	 
	 
	 
	 public int selectReservationCount() {
		 return jdbc.queryForObject(RESERVATION_COUNT, Collections.emptyMap(), Integer.class);
	 }
	 
	 
	 
	 public List<Reservation> selectReservationInfo(String email){
	 		Map<String, String> params = new HashMap<>();
	 		params.put("email", email);
	 		return jdbc.query(RESERVATION_INFO, params, rowMapper2);
	 }
	 
	 public void cancelReservation(Reservation reservation) {
		 	Map<String, Object> params = new HashMap<String,Object>();
		 	params.put("productId", reservation.getProduct_id());
		 	params.put("email", reservation.getReservation_email());
			jdbc.update(CANCEL_RESERVATION, params);
	 }
	 

	 
	 
	 
}
