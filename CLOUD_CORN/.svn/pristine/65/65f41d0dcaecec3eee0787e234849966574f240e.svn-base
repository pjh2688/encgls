package com.enc.business.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.enc.aop.ValidationAspect;
import com.enc.config.SolutionConfig;
import com.typhoon.framework.json.JSONResMessage;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping({"", "/", "/index", "/login"})
	public String login(HttpServletRequest request) {
		return "/admin/member/login";
	}
	
	/**
	 * 로그인
	 * 
	 * @param request
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/do_login")
	@ValidationAspect(stringIds= {"adminid", "password"}, stringTitles= {"관리자 아이디", "패스워드"})
	public @ResponseBody JSON login(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= null;
		
		try {
			resJson 				= this.adminService.login(request, paramJson);
		} catch(Exception e) {
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청처리중 오류 발생");
		}
		
		return resJson.getResponseMessage();
	}
}
