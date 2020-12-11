package com.enc.business.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.enc.config.CODESET;
import com.enc.config.MemberSession;
import com.enc.config.SolutionConfig;

import com.enc.mapper.UserSQLMapper;
import com.typhoon.framework.json.JSONResMessage;
import com.typhoon.framework.security.MysqlCrypto;
import com.typhoon.framework.security.RandomString;


@Service
public class MemberService {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	
	@Autowired
    private SolutionConfig typhoonSolutionConfig;
    
	
    @Resource
	private UserSQLMapper userSQLMapper;
    
    /**
     * 사용자 조회
     * 
     * @param paramJson
     * @return
     * @throws Exception
     */
    public JSONResMessage findOne(JSONObject paramJson) throws Exception {
    	JSONResMessage resJson = new JSONResMessage();
    	MysqlCrypto crypto = new MysqlCrypto();
    	
    	try {
    		
    	} catch(Exception e) {
			resJson.setStatusAndMessage(JSONResMessage.FAIL, "요청처리중 오류 발생");
			LOGGER.error("mbr0100Service.register", e);
		}
    	
    	return resJson;
    }
	
	/**
	 * 사용자 정보하나를 반환
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONResMessage isdupleUserId(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			JSONObject bean 		= this.userSQLMapper.select_row(paramJson);
			resJson.put("isduple", (bean == null)? "N":"Y");
		} catch(Exception e) {
			LOGGER.error("mbr0100Service.login", e);
			throw e;
		}
		
		return resJson;
	}
	
    /**
     * 사용자 등록
     * 
     * @param paramJson
     * @return
     * @throws Exception
     */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage insert(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 			= new JSONResMessage();
		MysqlCrypto crypto 				= new MysqlCrypto();
		
		try {
			paramJson.put("password", crypto.password(paramJson.getString("password")));
			paramJson.put("statuscd", CODESET.MEMBER_STATUSCD_NORMAL);
			this.userSQLMapper.insert(paramJson);
		} catch(Exception e) {
			LOGGER.error("mbr0100Service.register", e);
			throw e;
		}
		
		return resJson;
	}
	
	public JSONResMessage userinfo(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 			= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			resJson.put("user", this.userSQLMapper.select_row(paramJson));
		} catch(Exception e) {
			LOGGER.error("MemberService.userinfo", e);
			throw e;
		}
		
		return resJson;
	}
	
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage update(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 			= new JSONResMessage(JSONResMessage.SUCCESS);
		
		try {
			this.userSQLMapper.update(paramJson);
		} catch(Exception e) {
			LOGGER.error("mbr0100Service.update", e);
			throw e;
		}
		
		return resJson;
	}
	
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage updatePasswd(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 			= new JSONResMessage(JSONResMessage.SUCCESS);
		MysqlCrypto crypto 				= new MysqlCrypto();
		JSONObject  sqlJson 			= new JSONObject();
		sqlJson.put("userid", paramJson.getString("userid"));
		sqlJson.put("password", crypto.password(paramJson.getString("password_old")));
		
		try {
			JSONObject userJson 		= this.userSQLMapper.select_row(sqlJson);
			if (userJson == null) {
				resJson.setStatusAndMessage(JSONResMessage.FAIL, "작성한 패스워드가 올바르지 않습니다");
			} else {
				paramJson.put("password", crypto.password(paramJson.getString("password")));
				this.userSQLMapper.update(paramJson);
			}
		} catch(Exception e) {
			LOGGER.error("mbr0100Service.updatePasswd", e);
			throw e;
		}
		
		return resJson;
	}
	
	

	
	/**
	 * 사용자 로그인
	 * 
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	public JSONResMessage login(HttpServletRequest request, JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= new JSONResMessage();
		MysqlCrypto crypto 			= new MysqlCrypto();
		
		try {
			// 사용자 계정은 모두 소문자만 사용한다
			paramJson.put("userid", paramJson.getString("userid").toLowerCase());
			paramJson.put("password", crypto.password(paramJson.getString("password")));
			JSONObject bean 		= this.userSQLMapper.select_row(paramJson);
			if (bean != null) { 	// 아이디와 패스워드가 동일
				if (CODESET.MEMBER_STATUSCD_NORMAL.equalsIgnoreCase(bean.getString("STATUSCD"))) { 	// N:정상, F:탈퇴, P:일시정지, E:기간만료
					// 문제 없다. 세션정보 제공
					MemberSession.setMemberInfo(request, MemberSession.MEMBER_GRADE_USER, bean.getString("USERID"), bean.getString("USERNM"));
					resJson.put("url", "/", JSONResMessage.SUCCESS);
					LOGGER.info("LOGIN:[RESULT:SUCCESS][USERID:" + paramJson.getString("userid") + "]");
				} else if (CODESET.MEMBER_STATUSCD_FIRED.equalsIgnoreCase(bean.getString("STATUSCD"))) {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "요청하신 계정은 탈퇴한 계정입니다");
					LOGGER.info("LOGIN:[RESULT:FAIL][USERID:" + paramJson.getString("userid") + "][MESSAGE:탈퇴한 계정]");
				} else if (CODESET.MEMBER_STATUSCD_PAUSE.equalsIgnoreCase(bean.getString("STATUSCD"))) {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "요청하신 계정은 일시 정지된 계정입니다");
					LOGGER.info("LOGIN:[RESULT:FAIL][USERID:" + paramJson.getString("userid") + "][MESSAGE:일시 정지된 계정]");
				} else if (CODESET.MEMBER_STATUSCD_EXPIRED.equalsIgnoreCase(bean.getString("STATUSCD"))) {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "요청하신 계정은 사용기간이 만료된 계정입니다");
					LOGGER.info("LOGIN:[RESULT:FAIL][USERID:" + paramJson.getString("userid") + "][MESSAGE:만료된 계정]");
				} else {
					resJson.setStatusAndMessage(JSONResMessage.FAIL, "요청하신 계정은 상태정보가 올바르지 않은 계정입니다");
					LOGGER.info("LOGIN:[RESULT:FAIL][USERID:" + paramJson.getString("userid") + "][MESSAGE: 상태정보가 올바르지 않은 계정]");
				}
			} else {
				resJson.setStatusAndMessage(JSONResMessage.FAIL, "아이디나 패스워드가 올바르지 않습니다");
				LOGGER.info("LOGIN:[RESULT:FAIL][USERID:" + paramJson.getString("userid") + "][MESSAGE:아이디 또는패스워드가 올바르지않음]");
			}
		} catch(Exception e) {
			LOGGER.error("mbr0100Service.login", e);
			throw e;
		}
		
		return resJson;
	}
	
	
    /**
     * 패스워드 분실
     * 
     * @param paramJson
     * @return
     * @throws Exception
     */
	@Transactional(rollbackFor = { Exception.class })
	public JSONResMessage forgotpwd(JSONObject paramJson) throws Exception {
		JSONResMessage resJson 			= new JSONResMessage();
		MysqlCrypto crypto 				= new MysqlCrypto();
		JSONObject sqlParam 			= new JSONObject();
		
		try {
			sqlParam.put("email", paramJson.getString("email"));
			JSONObject bean 			= this.userSQLMapper.select_row(sqlParam);
			if (bean != null) {
				String randomPasswd 	= RandomString.randomAlphaNumeric(7);
				sqlParam.clear();
				sqlParam.put("useruid", bean.getLong("USERUID"));
				sqlParam.put("password", crypto.password(randomPasswd));
				this.userSQLMapper.update(sqlParam);
				
				resJson.setStatusAndMessage(JSONResMessage.SUCCESS, "요청하신 메일주소로 임시패스워드를 발송하였습니다. 메일을 확인하세요");
			} else {
				resJson.setStatusAndMessage(JSONResMessage.FAIL, "존재하지 않는 메일 주소입니다");
			}
		} catch(Exception e) {
			resJson.setStatusAndMessage(JSONResMessage.FAIL, "요청처리중 오류 발생");
			LOGGER.error("mbr0100Service.register", e);
		}
		
		return resJson;
	}
}
