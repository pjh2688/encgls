package com.enc.dto;

import java.time.LocalDateTime;

public class BoardQnaRepl {

	int bbs_qna_repluid;  // 게시판_문의하기댓글고유번호
	int bbs_qnauid;  // 게시판_문의하기고유번호
	String doc_body_long;  // 게시판 본문
	LocalDateTime regdt;  // 등록 날짜
	String adminid;  // 관리자 아이디
	String file_name;  // 파일원본명
	String file_original_name;  // 저장파일고유명
	
	public BoardQnaRepl() {
		// TODO Auto-generated constructor stub
	}

	public int getBbs_qna_repluid() {
		return bbs_qna_repluid;
	}

	public void setBbs_qna_repluid(int bbs_qna_repluid) {
		this.bbs_qna_repluid = bbs_qna_repluid;
	}

	public int getBbs_qnauid() {
		return bbs_qnauid;
	}

	public void setBbs_qnauid(int bbs_qnauid) {
		this.bbs_qnauid = bbs_qnauid;
	}

	public String getDoc_body_long() {
		return doc_body_long;
	}

	public void setDoc_body_long(String doc_body_long) {
		this.doc_body_long = doc_body_long;
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
