package com.enc.business.front;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.enc.config.SolutionConfig;
import com.enc.mapper.VmmonitorSQLMapper;

@Service
public class MonitoringService {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Resource
	private VmmonitorSQLMapper vmmonitorSQLMapper;
	
	
	public int monitoring(JSONObject paramJson) throws Exception {
		int result 				= 0;
		try {
			result 				= this.vmmonitorSQLMapper.insertORupdate(paramJson);
		} catch(Exception e) {
			LOGGER.error("monitoring", e);
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 모니터링 정보를 전부 반환
	 * 
	 * @return
	 * @throws Exception
	 */
	public JSONArray getServerMonitorList() throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		JSONArray list 			= new JSONArray();
		
		try {
			list 				= this.vmmonitorSQLMapper.select(sqlJson);
		} catch(Exception e) {
			LOGGER.error("getServerMonitorList", e);
			throw e;
		}
		
		return list;
	}
}
