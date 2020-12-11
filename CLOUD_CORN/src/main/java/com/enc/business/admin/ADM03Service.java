package com.enc.business.admin;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.config.SolutionConfig;
import com.enc.mapper.ServiceContSQLMapper;
import com.enc.mapper.UserSQLMapper;
import com.typhoon.framework.json.JSONResMessage;

@Service
public class ADM03Service {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Resource
	private UserSQLMapper userSQLMapper;

	@Resource
	private ServiceContSQLMapper serviceContSQLMapper;
	
	/**
	 * 목록
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
			int count 				= this.userSQLMapper.count(paramJson);
			JSONArray list 			= this.userSQLMapper.select(paramJson);
			
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
	 * 글읽기
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	
	  public JSONObject adm_01PA(JSONObject param) throws Exception { 
		  return this.userSQLMapper.select_row(param);
	  }
	  
	  
	  
	  public JSONObject adm_01PS(JSONObject param) throws Exception {
		  return this.serviceContSQLMapper.select_row(param);
	  }
	  
}
