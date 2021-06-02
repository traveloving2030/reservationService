package kr.or.connect.reservationProject.dto;

public class Display_Info_Image {
	private int id;
	private int display_info_id;
	private int file_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDisplay_info_id() {
		return display_info_id;
	}
	public void setDisplay_info_id(int display_info_id) {
		this.display_info_id = display_info_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	
	@Override
	public String toString() {
		return "display_info_image [id=" + id + ", display_info_id=" + display_info_id + ", file_id=" + file_id + "]";
	}
	
	
	
}
