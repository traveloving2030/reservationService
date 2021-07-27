package kr.or.connect.reservationProject.dto;

public class ProductDetail {
	private int id;
	private String description;
	private String content;
	private String save_file_name;
	private String type;
	private double score;
	private String comment;
	private String modify_date;
	private String opening_hours;
	private String place_name;
	private String reservation_email;
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	
	public String getReservation_email() {
		return reservation_email;
	}
	public void setReservation_email(String reservation_email) {
		this.reservation_email = reservation_email;
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
	
	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", description=" + description + ", content=" + content + ", save_file_name="
				+ save_file_name + ", type=" + type + ", score=" + score + ", comment=" + comment + ", modify_date="
				+ modify_date + ", opening_hours=" + opening_hours + ", place_name=" + place_name
				+ ", reservation_email=" + reservation_email + "]";
	}

	



	
	

	
}
