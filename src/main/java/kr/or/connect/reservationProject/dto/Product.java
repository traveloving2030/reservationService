package kr.or.connect.reservationProject.dto;

import java.util.*;

public class Product {
	private int id;
	private int category_id;
	private String description;	
	private String content;
	private String opening_hours;
	private String place_name;
	private String place_lot;
	private String place_street;
	private String tel;
	private String homepage;
	private String email;
	private String save_file_name;
	private String type;
	
	private String event;
	private Date create_date;
	private Date modify_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getPlace_lot() {
		return place_lot;
	}
	public void setPlace_lot(String place_lot) {
		this.place_lot = place_lot;
	}
	public String getPlace_street() {
		return place_street;
	}
	public void setPlace_street(String place_street) {
		this.place_street = place_street;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
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
		return "Product [id=" + id + ", category_id=" + category_id + ", description=" + description + ", content="
				+ content + ", opening_hours=" + opening_hours + ", place_name=" + place_name + ", place_lot="
				+ place_lot + ", place_street=" + place_street + ", tel=" + tel + ", homepage=" + homepage + ", email="
				+ email + ", save_file_name=" + save_file_name + ", type=" + type + ", event=" + event
				+ ", create_date=" + create_date + ", modify_date=" + modify_date + "]";
	}
	
	
	
	
	
	

}
