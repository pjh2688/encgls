package com.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajax.dao.IBoardMapper;
import com.ajax.dto.Board;
import com.ajax.dto.PageMaker;

@Service("IBoardService")
public class BoardServiceImpl implements IBoardService {
	
	@Autowired
	IBoardMapper bm;

	@Override
	public List<Board> listAllService(PageMaker page) {
		// TODO Auto-generated method stub
		return bm.select(page);
	}

	@Override
	public Board readService(int b_no) {
		// TODO Auto-generated method stub
		bm.upHit(b_no);  // 조회수도 서비스에다가 추가.
		return bm.select_row(b_no);
	}

	@Override
	public int createService(Board board) {
		// TODO Auto-generated method stub
		return bm.insert(board);
	}

	@Override
	public int modifyService(Board board) {
		// TODO Auto-generated method stub
		return bm.update(board);
	}

	@Override
	public int totalCnt() {
		// TODO Auto-generated method stub
		return bm.count();
	}

	@Override
	public int board_pw(int b_no) {
		// TODO Auto-generated method stub
		return bm.select_pw(b_no);
	}

	@Override
	public int deleteService(int b_no) {
		// TODO Auto-generated method stub
		return bm.delete(b_no);
	}
	
	

	

}
