package com.enc.dto;

import java.time.LocalDateTime;

public class BoardNotice {
	
	int bbs_noticeuid;  // 게시판_공지사항 고유번호
	String title;  // 제목
	String doc_type;  // 게시글타입
	String doc_body_long;  // 게시판본문
	int hit_viewer;  // 조회수
	String writer_ip;  // 작성자IP
	String read_ip;  // 최근조회IP
	LocalDateTime regdt;  // 등록날짜
	String adminid;  // 관리자 계정 id
	String file_name;  // 파일원본명
	String file_original_name;  // 저장파일고유명
	
	public BoardNotice() {
		// TODO Auto-generated constructor stub
	}

	public int getBbs_noticeuid() {
		return bbs_noticeuid;
	}

	public void setBbs_noticeuid(int bbs_noticeuid) {
		this.bbs_noticeuid = bbs_noticeuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoc_type() {
		return doc_type;
	}

	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}

	public String getDoc_body_long() {
		return doc_body_long;
	}

	public void setDoc_body_long(String doc_body_long) {
		this.doc_body_long = doc_body_long;
	}

	public int getHit_viewer() {
		return hit_viewer;
	}

	public void setHit_viewer(int hit_viewer) {
		this.hit_viewer = hit_viewer;
	}

	public String getWriter_ip() {
		return writer_ip;
	}

	public void setWriter_ip(String writer_ip) {
		this.writer_ip = writer_ip;
	}

	public String getRead_ip() {
		return read_ip;
	}

	public void setRead_ip(String read_ip) {
		this.read_ip = read_ip;
	}

	public LocalDateTime getRegdt() {
		return regdt;
	}

	public void setRegdt(LocalDateTime regdt) {
		this.regdt = regdt;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_original_name() {
		return file_original_name;
	}

	public void setFile_original_name(String file_original_name) {
		this.file_original_name = file_original_name;
	}
	
	
}
