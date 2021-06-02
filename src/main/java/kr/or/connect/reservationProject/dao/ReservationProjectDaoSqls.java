package kr.or.connect.reservationProject.dao;

public class ReservationProjectDaoSqls {
	
	public static final String SELECT_PAGING = "SELECT prod.id, prod.category_id, prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_PAGING = "SELECT prod.description, prod.content, di.place_name, fi.save_file_name FROM product prod JOIN display_info di ON (prod.id = di.product_id) JOIN product_image pi ON (prod.id = pi.product_id) JOIN file_info fi ON (pi.file_id = fi.id) WHERE pi.type = 'th' AND prod.category_id = :category_id ORDER BY prod.id DESC limit :start, :limit";
	public static final String SELECT_PRODUCT_COUNT = "SELECT count(*) FROM product";
}
