package com.ajax.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String userid;  // 사용자 id
	private String password;  // 비밀번호
	private String usernm;  // 사용자 이름
	private Timestamp regdt;  // 등록 날짜
	private String statuscd;  // 상태 코드
	private Timestamp dropdt;  // 탈퇴 날짜
	private Timestamp modifydt;  // 수정 날짜
	private String hphone;  // 휴대폰번호
	private String email;  // 이메일
	private String ceonm;  // 사업자 대표 이름
	private String comp_name;  // 사업장 상호
	private String biznum;  // 사업자 등록 번호
	private String cor_num;  // 법인 등록 번호
	private String comp_addr; // 사업장 주소
	private String comp_tel;  // 사업장 전화번호
	private Timestamp approvaldt;  // 승인 날짜
	private String comp_fax;  // 사업장 FAX 번호
	private String ktcloudid;  // kt cloud id
	
	public User() {
		// TODO Auto-generated constructor stub
	}
}
