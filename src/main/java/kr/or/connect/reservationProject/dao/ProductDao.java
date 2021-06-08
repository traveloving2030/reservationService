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
import static kr.or.connect.reservationProject.dao.ReservationProjectDaoSqls.*;

@Repository
public class ProductDao {
	 private NamedParameterJdbcTemplate jdbc;
	 private SimpleJdbcInsert insertAction;
	 private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	 
	 public ProductDao(DataSource dataSource) {
	        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	 }
	 
	public List<Product> selectAll(Integer start, Integer limit) {
    		Map<String, Integer> params = new HashMap<>();
    		params.put("start", start);
    		params.put("limit", limit);
        return jdbc.query(SELECT_PAGING, params, rowMapper);
    }
	
	 public List<Product> selectProductByCategoryId(Integer category_id, Integer start, Integer limit) {
    		Map<String, Integer> params = new HashMap<>();
    		params.put("category_id", category_id);
    		params.put("start", start);
    		params.put("limit", limit);
        return jdbc.query(SELECT_PRODUCT_PAGING, params, rowMapper);
    }
	 
	public int insertProduct(Product product) {
			SqlParameterSource params = new BeanPropertySqlParameterSource(product);
			return insertAction.execute(params);
	}
	
	public int selectAllProdCount() {
		return jdbc.queryForObject(SELECT_PRODUCT_COUNT, Collections.emptyMap(), Integer.class);
	}

	public int selectProdCountByCategory(Integer category_id) {
		return jdbc.queryForObject(SELECT_PRODUCT_COUNT_BYCATEGORY, Collections.emptyMap(), Integer.class);
	}
	
	public List<Product> selectPromotion(){
		return jdbc.query(PROMOTION_FILEINFO, rowMapper);
	}
	 
}
