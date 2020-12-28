package com.ajax.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {
	
	int bbs_no; // 게시글 번호 가짜
	int b_no;  // 게시글 번호 진짜
	String b_tit;  // 게시글 제목
	String b_cont; // 게시글 내용
	String usernm;  // 작성자 이름
	LocalDateTime reg_date;  // 작성 날짜
	int b_hit;  // 조회수
	String userid; // 사용자 id
	int b_pw; // 게시글 password
	String file_name;  // 저장파일고유명
	String file_original_name;  // 파일원본명
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

}
