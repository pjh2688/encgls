package com.ajax.service;

import java.util.List;

import com.ajax.dto.Board;
import com.ajax.dto.PageMaker;

public interface IBoardService {
	
	/* 게시글 전체 목록 */
	public List<Board> listAllService(PageMaker page);
	
	/* 게시글 상세 보기 */
	public Board readService(int b_no);
	
	/* 게시글 작성 */
	public int createService(Board board);
	
	/* 게시글 수정 */
	public int modifyService(Board board);
	
	/* 게시글 총 갯수 */
	public int totalCnt();
	
	/* 게시글 비밀번호 조회 */
	public int board_pw(int b_no);
	
	/* 게시글 삭제 */
	public int deleteService(int b_no);
}
