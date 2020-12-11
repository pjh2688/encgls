package com.enc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.enc.dto.BoardNotice;
import com.enc.dto.PageMaker;

@Mapper
public interface IBbsNoticeMapper {

	/* list 가져오기 */
	List<BoardNotice> selectNotice(PageMaker page);
	
	/* 게시글 수 조회 */
	public int countNotice();
}
