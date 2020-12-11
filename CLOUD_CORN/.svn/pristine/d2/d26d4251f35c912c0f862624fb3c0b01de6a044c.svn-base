package com.enc.business.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.enc.config.MemberSession;
import com.enc.config.SolutionConfig;
import com.enc.mapper.AdminSQLMapper;
import com.typhoon.framework.json.JSONResMessage;
import com.typhoon.framework.security.MysqlCrypto;

@Service
public class AdminService {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	
	@Autowired
    private SolutionConfig typhoonSolutionConfig;
	
    @Resource
	private AdminSQLMapper adminSQLMapper;
    
    
	/**
	 * 관리자 로그인
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
    @Transactional(rollbackFor = { Exception.class })
	public JSONResMessage login(HttpServletRequest request, JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage();
		MysqlCrypto crypto 			= new MysqlCrypto();
		
		try {
			// 사용자 계정은 모두 소문자만 사용한다
			paramJson.put("adminid", paramJson.getString("adminid").toLowerCase());
			paramJson.put("password", crypto.password(paramJson.getString("password")));
			JSONObject bean 		= this.adminSQLMapper.select_row(paramJson);
			if (bean != null) { 	// 아이디와 패스워드가 동일
				// 문제 없다. 세션정보 제공
				MemberSession.setMemberInfo(request, MemberSession.MEMBER_GRADE_ADMIN, bean.getString("ADMINID"), bean.getString("ADMINNM"));
				resJson.put("url", "/admin/01/01", JSONResMessage.SUCCESS);
				LOGGER.info("LOGIN:[RESULT:SUCCESS][USERID:" + paramJson.getString("userid") + "]");
			} else {
				resJson.setStatusAndMessage(JSONResMessage.FAIL, "아이디나 패스워드가 올바르지 않습니다");
				LOGGER.info("LOGIN:[RESULT:FAIL][USERID:" + paramJson.getString("adminid") + "][MESSAGE:아이디 또는패스워드가 올바르지않음]");
			}
		} catch(Exception e) {
			LOGGER.error("login", e);
			throw e;
		}
		
		return resJson;
	}
    
}
