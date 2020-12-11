package com.enc.business.admin;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.enc.config.SolutionConfig;
import com.enc.mapper.AdminSQLMapper;
import com.typhoon.framework.json.JSONResMessage;
import com.typhoon.framework.security.MysqlCrypto;

@Service
	public class ADM04Service {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
		
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Resource
	private AdminSQLMapper adminSQLMapper;
	
	
	
	  public JSONObject adm_01PE(String adminid) throws Exception { 
		  JSONObject 		  sqlJson = new JSONObject(); 
	  	  sqlJson.put("adminid", "admin");
		  
		  System.out.println("일치확인"+sqlJson);
		  
		  return this.adminSQLMapper.select_row(sqlJson); 
	  }
	 
	
	
	//일치확인
	@Transactional(rollbackFor = { Exception.class })
	public JSONObject adm_01PA(JSONObject paramJson, HttpServletResponse response) throws Exception {
		JSONObject sqlJson 		= new JSONObject();
		MysqlCrypto crypto 			= new MysqlCrypto();
		System.out.println("Service Came In");
		String old_passwd 			= crypto.password(paramJson.getString("password"));
		
		int checking = this.adminSQLMapper.count(old_passwd);
		if (checking==1) {
			String password 			= crypto.password(paramJson.getString("password_new"));
			sqlJson.put("password", password);

			this.adminSQLMapper.update(sqlJson);
		} else if (checking==0) {
			System.out.println("Service response PrintWriter out1");
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("Service response PrintWriter out2");
			PrintWriter out = response.getWriter();
			System.out.println("Service response PrintWriter out3");
			out.println("<script>alert('비밀번호 일치안함');</script>");
			System.out.println("Service response PrintWriter out4"); 
   		    out.flush(); 
			System.out.println("Service response PrintWriter out5");
		}
		return sqlJson; 
	}
	 
	

	
	/*
	 * public JSONResMessage adm_01AE(JSONObject paramJson) throws Exception {
	 * JSONResMessage resJson = new JSONResMessage(JSONResMessage.SUCCESS);
	 * 
	 * System.out.println("!!!!!!!!!!!!!!!!resJson from service1111!!!!paramJson"
	 * +resJson);
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * this.adminSQLMapper.update(paramJson); } catch(Exception e) {
	 * LOGGER.error("adm_01AE", e); throw e; }
	 * 
	 * System.out.println("!!!!!!!!!!!!!!!!resJson from service!!!!"+resJson);
	 * 
	 * return resJson; }
	 */
	

}
