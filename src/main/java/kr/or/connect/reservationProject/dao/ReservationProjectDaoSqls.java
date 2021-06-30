package kr.or.connect.reservationProject.dao;

public class ReservationProjectDaoSqls {
	
	public static final String SELECT_PAGING = "SELECT prod.id, prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_PAGING = "SELECT prod.id, prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' AND prod.category_id = :category_id ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_COUNT = "SELECT count(*) FROM product";
	public static final String SELECT_PRODUCT_COUNT_BYCATEGORY = "SELECT count(*) FROM product where category_id= :category_id";
	public static final String PROMOTION_FILEINFO = "SELECT fi.save_file_name FROM file_info fi JOIN product_image pi ON (fi.id = pi.file_id), promotion WHERE pi.product_id = promotion.product_id && pi.type = 'th'";
	
	public static final String DETAIL_PRODUCT = "SELECT prod.description, prod.content, fi.save_file_name FROM product prod JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE (pi.type = 'ma' OR pi.type = 'et') AND prod.id = :productId"; 
	public static final String DETAIL_COMMENT = "SELECT com.score, com.comment, com.modify_date, fi.save_file_name, resv.reservation_email FROM Product prod JOIN reservation_user_comment com ON (prod.id = com.product_id) JOIN reservation_info resv ON (com.reservation_info_id = resv.id AND prod.id = resv.product_id AND resv.product_id = com.product_id) LEFT OUTER JOIN reservation_user_comment_image comImg ON (comImg.reservation_user_comment_id = com.id AND comImg.reservation_info_id = resv.id) LEFT OUTER JOIN file_info fi ON(comImg.file_id = fi.id) WHERE prod.id = :productId";
	public static final String COMMENT_COUNT = "SELECT count(*) FROM Product prod JOIN reservation_user_comment com ON (prod.id = com.product_id) JOIN reservation_info resv ON (com.reservation_info_id = resv.id AND prod.id = resv.product_id AND resv.product_id = com.product_id) LEFT OUTER JOIN reservation_user_comment_image comImg ON (comImg.reservation_user_comment_id = com.id AND comImg.reservation_info_id = resv.id) LEFT OUTER JOIN file_info fi ON(comImg.file_id = fi.id) WHERE prod.id = :productId";
	
	
}

