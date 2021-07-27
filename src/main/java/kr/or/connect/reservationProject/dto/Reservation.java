package kr.or.connect.reservationProject.dto;

import java.util.Date;

public class Reservation {
	private int id;
	private int product_id;
	private int display_info_id;
	private String price_type_name;
	private int price;
	private double discount_rate;
	private String description;
	private String opening_hours;
	private String place_name;
	private String tel;
	private String homepage;
	private String reservation_name;
	private String reservation_tel;
	private String reservation_email;
	private Date reservation_date;
	private int cancel_flag;
	private Date create_date;
	private Date modify_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice_type_name() {
		return price_type_name;
	}
	public void setPrice_type_name(String price_type_name) {
		this.price_type_name = price_type_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(double discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOpening_hours() {
		return opening_hours;
	}
	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getReservation_email() {
		return reservation_email;
	}
	public void setReservation_email(String reservation_email) {
		this.reservation_email = reservation_email;
	}
	
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getDisplay_info_id() {
		return display_info_id;
	}
	public void setDisplay_info_id(int display_info_id) {
		this.display_info_id = display_info_id;
	}
	public String getReservation_name() {
		return reservation_name;
	}
	public void setReservation_name(String reservation_name) {
		this.reservation_name = reservation_name;
	}
	public String getReservation_tel() {
		return reservation_tel;
	}
	public void setReservation_tel(String reservation_tel) {
		this.reservation_tel = reservation_tel;
	}
	public Date getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}
	public int getCancel_flag() {
		return cancel_flag;
	}
	public void setCancel_flag(int cancel_flag) {
		this.cancel_flag = cancel_flag;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", product_id=" + product_id + ", display_info_id=" + display_info_id
				+ ", price_type_name=" + price_type_name + ", price=" + price + ", discount_rate=" + discount_rate
				+ ", description=" + description + ", opening_hours=" + opening_hours + ", place_name=" + place_name
				+ ", tel=" + tel + ", homepage=" + homepage + ", reservation_name=" + reservation_name
				+ ", reservation_tel=" + reservation_tel + ", reservation_email=" + reservation_email
				+ ", reservation_date=" + reservation_date + ", cancel_flag=" + cancel_flag + ", create_date="
				+ create_date + ", modify_date=" + modify_date + "]";
	}
	

	
	
	
	
	
	
}
