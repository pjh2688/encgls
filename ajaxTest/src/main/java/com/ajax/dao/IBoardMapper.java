package com.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ajax.dto.Board;
import com.ajax.dto.PageMaker;

@Mapper
public interface IBoardMapper {

	/* create */
	int insert(Board board);
	
	/* read - multiple */
	List<Board> select(PageMaker page);
	
	/* read - single */
	Board select_row(int b_no);
	
	/* update  */
	int update(Board board);
	
	/* delete */
	int delete(int b_no);
	
	/* 게시글 수 조회 */
	int count();
	
	/* 게시글 비밀번호 조회 */
	int select_pw(int b_no);
	
	/* 조회 수 */
	int upHit(int b_no);
	
	
}
