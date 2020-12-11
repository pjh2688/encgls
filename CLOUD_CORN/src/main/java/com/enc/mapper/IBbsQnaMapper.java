package com.enc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enc.dto.BoardQna;
import com.enc.dto.BoardQnaRepl;
import com.enc.dto.PageMaker;

@Mapper
public interface IBbsQnaMapper {
	
	/* 문의하기 */
	int insertQna(BoardQna qna);
	
	/* user 테이블에서 이메일 가져오기 */
	String selectEmail(String userid);
	
	/* list 가져오기 */
	List<BoardQna> selectQna(PageMaker page);
	
	/* 게시글 수 조회 */
	int countQna();
	
	/* 조회 수 */
	int upHit(String bbs_qnauid);
	
	/* list 1개 가지고오기 */
	BoardQna selectOne(String bbs_qnauid);
	
	/* 문의글 수정 */
	int updateQna(BoardQna qna);
	
	/* 문의글 답변 list 가져오기*/
	List<BoardQnaRepl> selectQnaRepl(String bbs_qnauid);
	
	
}
