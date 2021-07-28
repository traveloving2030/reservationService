package kr.or.connect.reservationProject.dao;

public class ReservationProjectDaoSqls {
	
	public static final String SELECT_PAGING = "SELECT prod.id, prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_PAGING = "SELECT prod.id, prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' AND prod.category_id = :category_id ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_COUNT = "SELECT count(*) FROM product";
	public static final String SELECT_PRODUCT_COUNT_BYCATEGORY = "SELECT count(*) FROM product where category_id= :category_id";
	public static final String PROMOTION_FILEINFO = "SELECT fi.save_file_name FROM file_info fi JOIN product_image pi ON (fi.id = pi.file_id), promotion WHERE pi.product_id = promotion.product_id && pi.type = 'th'";
	
	public static final String DETAIL_PRODUCT = "SELECT prod.description, prod.content, di.place_name, di.opening_hours, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id= di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE (pi.type = 'ma' OR pi.type = 'et') AND prod.id = :productId";
	public static final String DETAIL_PRODUCT_FOR_MAP = "SELECT prod.description, fi.save_file_name, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN display_info_image dim ON (dim.display_info_id = di.id) JOIN file_info fi ON (fi.id = dim.file_id) WHERE prod.id = :productId";
	public static final String DETAIL_PRODUCT_COUNT = "SELECT count(*) FROM product prod JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE (pi.type = 'ma' OR pi.type = 'et') AND prod.id = :productId";
	public static final String DETAIL_COMMENT = "SELECT com.score, com.comment, com.modify_date, fi.save_file_name, resv.reservation_email FROM Product prod JOIN reservation_user_comment com ON (prod.id = com.product_id) JOIN reservation_info resv ON (com.reservation_info_id = resv.id AND prod.id = resv.product_id AND resv.product_id = com.product_id) LEFT OUTER JOIN reservation_user_comment_image comImg ON (comImg.reservation_user_comment_id = com.id AND comImg.reservation_info_id = resv.id) LEFT OUTER JOIN file_info fi ON(comImg.file_id = fi.id) WHERE prod.id = :productId";
	public static final String COMMENT_COUNT = "SELECT count(*) FROM Product prod JOIN reservation_user_comment com ON (prod.id = com.product_id) JOIN reservation_info resv ON (com.reservation_info_id = resv.id AND prod.id = resv.product_id AND resv.product_id = com.product_id) LEFT OUTER JOIN reservation_user_comment_image comImg ON (comImg.reservation_user_comment_id = com.id AND comImg.reservation_info_id = resv.id) LEFT OUTER JOIN file_info fi ON(comImg.file_id = fi.id) WHERE prod.id = :productId";
	
	public static final String PRODUCT_PRICE = "SELECT prod.id, fare.price_type_name, fare.price, fare.discount_rate FROM product prod JOIN product_price fare ON (fare.product_id = prod.id) WHERE prod.id = :productId";
	public static final String RESERVATION_COUNT = "SELECT (*) FROM reservation_info";
	public static final String RESERVATION_INFO = "SELECT prod.id, prod.description, di.opening_hours, di.place_name, di.tel, di.homepage, ri.reservation_email FROM product prod JOIN reservation_info ri ON (ri.product_id = prod.id) JOIN display_info di ON (di.product_id = ri.display_info_id) WHERE ri.reservation_email = :email";
	public static final String CANCEL_RESERVATION = "UPDATE reservation_info SET cancel_flag = 1 WHERE reservation_email = :email AND product_id := productId";
}

