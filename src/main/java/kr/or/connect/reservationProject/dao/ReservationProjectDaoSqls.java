package kr.or.connect.reservationProject.dao;

public class ReservationProjectDaoSqls {
	
	public static final String SELECT_PAGING = "SELECT prod.id, prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_PAGING = "SELECT prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' AND prod.category_id = :category_id ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_COUNT = "SELECT count(*) FROM product";
	public static final String SELECT_PRODUCT_COUNT_BYCATEGORY = "SELECT count(*) FROM product where category_id= :category_id";
	public static final String PROMOTION_FILEINFO = "SELECT fi.save_file_name FROM file_info fi JOIN product_image pi ON (fi.id = pi.file_id), promotion WHERE pi.product_id = promotion.product_id && pi.type = 'th'";
	
	public static final String DETAIL_PRODUCT = "SELECT prod.description, prod.content, fi.save_file_name FROM product prod JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE (pi.type = 'ma' OR pi.type = 'et') AND prod.id = :productId";
	public static final String DETAIL_COMMENT = "SELECT com.score, com.comment FROM product prod JOIN display_info di ON(prod.id = di.product_id) JOIN reservation_user_comment com on (prod.id = com.product_id) WHERE prod.id = :productId"; 

}
