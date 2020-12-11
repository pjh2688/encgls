package com.enc.dto;

import java.time.LocalDateTime;

public class ServiceCont {
	
	String userid;  // 사용자ID
	LocalDateTime regdt;  // 등록날짜
	LocalDateTime modifydt;  // 수정날짜
	String service_lot_yn;  // 서비스_IOT_사용여부
	String service_block_yn;  // 서비스_블럭체인_사용여부
	String service_status;  // 서비스_상태
	int cont_no;  // 계약번호
	String service_type_pl;  // 서비스_종류
	
	public ServiceCont() {
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public LocalDateTime getRegdt() {
		return regdt;
	}

	public void setRegdt(LocalDateTime regdt) {
		this.regdt = regdt;
	}

	public LocalDateTime getModifydt() {
		return modifydt;
	}

	public void setModifydt(LocalDateTime modifydt) {
		this.modifydt = modifydt;
	}

	public String getService_lot_yn() {
		return service_lot_yn;
	}

	public void setService_lot_yn(String service_lot_yn) {
		this.service_lot_yn = service_lot_yn;
	}

	public String getService_block_yn() {
		return service_block_yn;
	}

	public void setService_block_yn(String service_block_yn) {
		this.service_block_yn = service_block_yn;
	}

	public String getService_status() {
		return service_status;
	}

	public void setService_status(String service_status) {
		this.service_status = service_status;
	}

	public int getCont_no() {
		return cont_no;
	}

	public void setCont_no(int cont_no) {
		this.cont_no = cont_no;
	}

	public String getService_type_pl() {
		return service_type_pl;
	}

	public void setService_type_pl(String service_type_pl) {
		this.service_type_pl = service_type_pl;
	}
	
	
}
