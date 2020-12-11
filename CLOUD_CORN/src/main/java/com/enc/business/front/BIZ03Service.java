package com.enc.business.front;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.config.SolutionConfig;
import com.enc.dto.BoardNotice;
import com.enc.dto.BoardQna;
import com.enc.dto.BoardQnaRepl;
import com.enc.dto.PageMaker;
import com.enc.mapper.BbsFaqSQLMapper;
import com.enc.mapper.BbsNoticeSQLMapper;
import com.enc.mapper.BbsQnaReplSQLMapper;
import com.enc.mapper.BbsQnaSQLMapper;
import com.enc.mapper.IBbsNoticeMapper;
import com.enc.mapper.IBbsQnaMapper;
import com.typhoon.framework.json.JSONResMessage;

@Service
public class BIZ03Service {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Resource
	private BbsNoticeSQLMapper bbsNoticeSQLMapper;
	
	@Resource
	private BbsFaqSQLMapper bbsFaqSQLMapper;
	
	@Resource
	private BbsQnaSQLMapper bbsQnaSQLMapper;
	
	@Resource
	private BbsQnaReplSQLMapper bbsQnaReplSQLMapper;
	
	@Autowired
	private IBbsQnaMapper bbsQnaMapper;
	
	@Autowired
	private IBbsNoticeMapper bbsNoticeMapper;
	
	
	/**
	 * 공지사항 목록
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONResMessage adm_01AL(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		if (!paramJson.containsKey("cpage")) {
			paramJson.put("cpage", 1);
		}
		int pageSize 				= 12;
		int iDisplayStart 			= (paramJson.getIntValue("cpage")-1)*pageSize;
		paramJson.put("iDisplayStart", iDisplayStart);
		paramJson.put("iDisplayEnd", pageSize);
		paramJson.put("sort", "REGDT DESC");
		
		try {
			int count 				= this.bbsNoticeSQLMapper.count(paramJson);
			JSONArray list 			= this.bbsNoticeSQLMapper.select(paramJson);
			resJson.put("aaData", list);
			resJson.put("iTotalRecords", count);
			resJson.put("iTotalDisplayRecords", count);
			resJson.put("pageSize", pageSize);
			resJson.put("cpage", paramJson.getIntValue("cpage"));
			resJson.put("pagecount", ((count-1)/pageSize) + 1);
			resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
		} catch(Exception e) {
			LOGGER.error("adm_01AL", e);
			throw e;
		}
		
		return resJson;
	}
	
	
	/**
	 * 공지사항 글읽기
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONObject adm_01PA(JSONObject paramJson, String userip) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		sqlJson.put("readip", userip);
		sqlJson.put("bbs_noticeuid", paramJson.getIntValue("bbs_noticeuid"));
		this.bbsNoticeSQLMapper.update_hit(sqlJson);
		return this.bbsNoticeSQLMapper.select_row(paramJson);
	}
	
	
	/**
	 * FAQ 목록
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONArray biz_02(JSONObject paramJson) throws Exception {
		JSONArray list 		= null;

		try {
			paramJson.put("sort", "BBS_FAQUID DESC");
			list 			= this.bbsFaqSQLMapper.select(paramJson);
		} catch(Exception e) {
			LOGGER.error("biz_02", e);
			throw e;
		}
		
		return list;
	}
	
	
	/**
	 * 공지사항 게시글 읽기 여러개(페이징)
	 * 
	 * @param  PageMaker page
	 * @return
	 * @throws 
	 */
	public List<BoardNotice> selectNoticeService(PageMaker page) {
		return bbsNoticeMapper.selectNotice(page);
	}
	
	/**
	 * 문의하기 총 게시글 수 
	 * 
	 * @param  
	 * @return
	 * @throws 
	 */
	public int countNoticeService() {
		return bbsNoticeMapper.countNotice();
	}
	
	
	/**
	 * 문의하기 글 쓰기
	 * 
	 * @param  BoardQna qna
	 * @return
	 * @throws 
	 */
	public int insertQnaService(BoardQna qna) {
		
		int result = bbsQnaMapper.insertQna(qna);
		
		return result;
	}
	
	/**
	 * 이메일 검색
	 * 
	 * @param  String userid
	 * @return
	 * @throws 
	 */
	public String selectEmailService(String userid) {
		 
		return bbsQnaMapper.selectEmail(userid);
	}
	
	/**
	 * 문의하기 총 게시글 수 
	 * 
	 * @param  
	 * @return
	 * @throws 
	 */
	public int countQnaService() {
		return bbsQnaMapper.countQna();
	}
	
	/**
	 * 문의하기 게시글 읽기 여러개(페이징)
	 * 
	 * @param  PageMaker page
	 * @return
	 * @throws 
	 */
	public List<BoardQna> selectQnaService(PageMaker page) {
		return bbsQnaMapper.selectQna(page);
	}
	
	/**
	 * 문의하기 게시글 읽기 1개(상세보기)
	 * 
	 * @param  PageMaker page
	 * @return
	 * @throws 
	 */
	public BoardQna selectOneService(String bbs_qnauid) {
		bbsQnaMapper.upHit(bbs_qnauid);
		return bbsQnaMapper.selectOne(bbs_qnauid);
	}
	
	/**
	 * 문의하기 게시글 수정
	 * 
	 * @param  PageMaker page
	 * @return
	 * @throws 
	 */
	
	public List<BoardQnaRepl> selectQnaReplService(String bbs_qnauid) {
		return bbsQnaMapper.selectQnaRepl(bbs_qnauid);
	}
	
	
	/**
	 * 문의하기 게시글 수정
	 * 
	 * @param  PageMaker page
	 * @return
	 * @throws 
	 */
	public int updateQnaService(BoardQna qna) {
		int result = bbsQnaMapper.updateQna(qna);
		return result;
	}
}
