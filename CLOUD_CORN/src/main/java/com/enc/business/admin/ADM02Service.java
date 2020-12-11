package com.enc.business.admin;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.config.SolutionConfig;
import com.enc.mapper.BbsFaqSQLMapper;
import com.enc.mapper.BbsNoticeSQLMapper;
import com.enc.mapper.BbsQnaReplSQLMapper;
import com.enc.mapper.BbsQnaSQLMapper;
import com.typhoon.framework.json.JSONResMessage;

@Service
public class ADM02Service {
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
	
	/**
	 * 공지사항 입력
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_01AW(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsNoticeSQLMapper.insert(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_01AW", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * 공지사항 수정
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_01AE(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsNoticeSQLMapper.update(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_01AE", e);
			throw e;
		}
		
		return resJson;
	}
	
	
	
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
	 * 글 삭제
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_01AD(JSONObject paramJson, String userid) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		paramJson.put("adminid", userid);
		if (!paramJson.containsKey("bbs_noticeuid")) {
			resJson.setStatusAndMessage(JSONResMessage.FAIL, "글번호가 존재하지않습니다");
			return resJson;
		} else {
			try {
				JSONObject rowObj		= this.bbsNoticeSQLMapper.select_row(paramJson);
				if (rowObj != null) {
					if (rowObj.containsKey("FILE_NAME")) {
						String fileName 	= rowObj.getString("FILE_NAME");
						String realDirPath 	= solutionConfig.getUploaddir();
						File dir 				= new File(realDirPath, ADM02Controller.FILE_SUB_DIR_BBS);
						File file 				= new File(dir, fileName);
						if (file.isFile()) {
							file.delete();
						}
					}
					
					this.bbsNoticeSQLMapper.delete(paramJson);
					resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
				} else {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "권한이 없거나 존재하지않는 글입니다");
				}
			} catch(Exception e) {
				LOGGER.error("adm_01AD", e);
				throw e;
			}
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
	 * 글 수정을 위한  데이터 하나를 읽어온다
	 * 
	 * @param paramJson
	 * @param userip
	 * @return
	 * @throws Exception
	 */
	public JSONObject adm_01PE(int bbsNoticeuid) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		
		sqlJson.put("bbs_noticeuid", bbsNoticeuid);
		
		
		return this.bbsNoticeSQLMapper.select_row(sqlJson);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * FAQ 목록
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONResMessage adm_02AL(JSONObject paramJson) throws Exception {
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
			int count 				= this.bbsFaqSQLMapper.count(paramJson);
			JSONArray list 			= this.bbsFaqSQLMapper.select(paramJson);
			resJson.put("aaData", list);
			resJson.put("iTotalRecords", count);
			resJson.put("iTotalDisplayRecords", count);
			resJson.put("pageSize", pageSize);
			resJson.put("cpage", paramJson.getIntValue("cpage"));
			resJson.put("pagecount", ((count-1)/pageSize) + 1);
			resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
		} catch(Exception e) {
			LOGGER.error("adm_02AL", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * FAQ 입력
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_02AW(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsFaqSQLMapper.insert(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_02AW", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * FAQ 글읽기
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONObject adm_02PA(JSONObject paramJson, String userip) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		sqlJson.put("readip", userip);
		sqlJson.put("bbs_faquid", paramJson.getIntValue("bbs_faquid"));
		return this.bbsFaqSQLMapper.select_row(paramJson);
	}
	
	/**
	 * FAQ글 삭제
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_02AD(JSONObject paramJson, String userid) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		paramJson.put("adminid", userid);
		if (!paramJson.containsKey("bbs_faquid")) {
			resJson.setStatusAndMessage(JSONResMessage.FAIL, "글번호가 존재하지않습니다");
			return resJson;
		} else {
			try {
				JSONObject rowObj		= this.bbsFaqSQLMapper.select_row(paramJson);
				if (rowObj != null) {
					if (rowObj.containsKey("FILE_NAME")) {
						String fileName 	= rowObj.getString("FILE_NAME");
						String realDirPath 	= solutionConfig.getUploaddir();
						File dir 				= new File(realDirPath, ADM02Controller.FILE_SUB_DIR_FAQ);
						File file 				= new File(dir, fileName);
						if (file.isFile()) {
							file.delete();
						}
					}
					
					this.bbsFaqSQLMapper.delete(paramJson);
					resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
				} else {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "권한이 없거나 존재하지않는 글입니다");
				}
			} catch(Exception e) {
				LOGGER.error("adm_02AD", e);
				throw e;
			}
		}
		
		return resJson;
	}
	
	/**
	 * FAQ 수정
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_02AE(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsFaqSQLMapper.update(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_02AE", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * 글 수정을 위한  데이터 하나를 읽어온다
	 * 
	 * @param paramJson
	 * @param userip
	 * @return
	 * @throws Exception
	 */
	public JSONObject adm_02PE(int bbs_faquid) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		sqlJson.put("bbs_faquid", bbs_faquid);
		
		return this.bbsFaqSQLMapper.select_row(sqlJson);
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * 문의하기 목록
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONResMessage adm_03AL(JSONObject paramJson) throws Exception {
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
			int count 				= this.bbsQnaSQLMapper.count(paramJson);
			JSONArray list 			= this.bbsQnaSQLMapper.select(paramJson);
			resJson.put("aaData", list);
			resJson.put("iTotalRecords", count);
			resJson.put("iTotalDisplayRecords", count);
			resJson.put("pageSize", pageSize);
			resJson.put("cpage", paramJson.getIntValue("cpage"));
			resJson.put("pagecount", ((count-1)/pageSize) + 1);
			resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
		} catch(Exception e) {
			LOGGER.error("adm_03AL", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * 문의하기 입력
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_03AW(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsQnaSQLMapper.insert(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_03AW", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * 문의하기 글읽기
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONObject adm_03PA(JSONObject paramJson, String userip) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		sqlJson.put("readip", userip);
		sqlJson.put("bbs_qnauid", paramJson.getIntValue("bbs_qnauid"));
		this.bbsQnaSQLMapper.update_hit(sqlJson);
		return this.bbsQnaSQLMapper.select_row(paramJson);
	}
	
	/**
	 * 글 수정을 위한  데이터 하나를 읽어온다
	 * 
	 * @param paramJson
	 * @param userip
	 * @return
	 * @throws Exception
	 */
	public JSONObject adm_03PE(int bbs_qnauid) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		sqlJson.put("bbs_qnauid", bbs_qnauid);
		
		return this.bbsQnaSQLMapper.select_row(sqlJson);
	}
	
	
	/**
	 * 문의하기 수정
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_03AE(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsQnaSQLMapper.update(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_03AE", e);
			throw e;
		}
		
		return resJson;
	}

	/**
	 * 문의하기글 삭제
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_03AD(JSONObject paramJson, boolean isAdmin) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		if (isAdmin) {
			paramJson.put("SUPER_USER", "YES");
		}
		if (!paramJson.containsKey("bbs_qnauid")) {
			resJson.setStatusAndMessage(JSONResMessage.FAIL, "글번호가 존재하지않습니다");
			return resJson;
		} else {
			JSONObject sqlJson 		= new JSONObject();
			sqlJson.put("bbs_qnauid", paramJson.getIntValue("bbs_qnauid"));
			
			try {
				// 질문을 반환하여 패스워드가 같은지 확인
				JSONObject qRow 		= this.bbsQnaSQLMapper.select_row(sqlJson);
				if (qRow != null) {
					if (isAdmin || qRow.getString("PASSWORD").equals(paramJson.getString("password"))) {
						// 본인 맞다. 이후 작업을 처리한다
						// 파일을 삭제하기위해 하위 리플목록을 반환
						sqlJson.clear();
						sqlJson.put("bbs_qnauid", paramJson.getIntValue("bbs_qnauid"));
						JSONArray list 	= this.bbsQnaReplSQLMapper.select(sqlJson);
						// 리플의 파일 삭제
						int size 		= 0;
						if (list != null && (size=list.size()) > 0) {
							JSONObject tmpJson = null;
							for (int i = 0; i < size; i++) {
								tmpJson 	= list.getJSONObject(i);
								if (tmpJson.containsKey("FILE_NAME")) {
									String fileName 	= tmpJson.getString("FILE_NAME");
									String realDirPath 	= solutionConfig.getUploaddir();
									File dir 				= new File(realDirPath, ADM02Controller.FILE_SUB_DIR_QNA);
									File file 				= new File(dir, fileName);
									if (file.isFile()) {
										file.delete();
									}
								}
								// repl 삭제
								JSONObject tmp2Json = new JSONObject();
								tmp2Json.put("bbs_qna_repluid", tmpJson.getIntValue("BBS_QNA_REPLUID"));
								tmp2Json.put("bbs_qnauid", tmpJson.getIntValue("BBS_QNAUID"));
								this.bbsQnaReplSQLMapper.delete(tmp2Json);
							}
						}
						
						// 파일삭제
						if (qRow.containsKey("FILE_NAME")) {
							String fileName 	= qRow.getString("FILE_NAME");
							String realDirPath 	= solutionConfig.getUploaddir();
							File dir 				= new File(realDirPath, ADM02Controller.FILE_SUB_DIR_QNA);
							File file 				= new File(dir, fileName);
							if (file.isFile()) {
								file.delete();
							}
						}
						// 질문삭제
						this.bbsQnaSQLMapper.delete(paramJson);
					} else {
						resJson.setStatusAndMessage(JSONResMessage.FAIL, "패스워드가 올바르지않습니다");
					}
				} else {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "글번호가 존재하지않습니다");
				}
			} catch(Exception e) {
				LOGGER.error("adm_02AD", e);
				throw e;
			}
		}
		
		return resJson;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	/**
	 * 문의하기 답글 입력
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_03AR(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 				= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.bbsQnaReplSQLMapper.insert(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_03AR", e);
			throw e;
		}
		
		return resJson;
	}
	
	/**
	 * 문의하기 답변 리스트 글읽기
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONArray adm_03PR(JSONObject paramJson) throws Exception {
		return this.bbsQnaReplSQLMapper.select(paramJson);
	}
	
	/**
	 * 답글 하나 삭제
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage adm_03ARD(JSONObject paramJson, String userid) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		paramJson.put("adminid", userid);
		if (!paramJson.containsKey("bbs_qna_repluid")) {
			resJson.setStatusAndMessage(JSONResMessage.FAIL, "답글번호가 존재하지않습니다");
			return resJson;
		} else {
			try {
				JSONObject rowObj		= this.bbsQnaReplSQLMapper.select_row(paramJson);
				if (rowObj != null) {
					if (rowObj.containsKey("FILE_NAME")) {
						String fileName 	= rowObj.getString("FILE_NAME");
						String realDirPath 	= solutionConfig.getUploaddir();
						File dir 				= new File(realDirPath, ADM02Controller.FILE_SUB_DIR_QNA);
						File file 				= new File(dir, fileName);
						if (file.isFile()) {
							file.delete();
						}
					}
					
					this.bbsQnaReplSQLMapper.delete(paramJson);
					resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
				} else {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "권한이 없거나 존재하지않는 글입니다");
				}
			} catch(Exception e) {
				LOGGER.error("adm_03ARD", e);
				throw e;
			}
		}
		
		return resJson;
	}
	
}
