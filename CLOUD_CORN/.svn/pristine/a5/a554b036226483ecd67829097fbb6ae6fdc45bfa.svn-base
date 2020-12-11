package com.enc.business.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.enc.aop.AdminLoginAspect;
import com.enc.config.CODESET;
import com.enc.config.MemberSession;
import com.enc.config.SolutionConfig;
import com.typhoon.framework.HttpServletResponseUtil;
import com.typhoon.framework.STRINGUtil;
import com.typhoon.framework.aop.RESPONSE_TYPE;
import com.typhoon.framework.file.FileUploader;
import com.typhoon.framework.json.JSONResMessage;
import com.typhoon.framework.json.JSONUtil;


@Controller
@RequestMapping({ "/admin/04" })
public class ADM04Controller {
	private final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	
	@Autowired
	private SolutionConfig solutionConfig;

	@Autowired
	private ADM04Service aDM04Service;

	/**
	 * 관리자/패스워드변경 페이지
	 * 
	 * @return
	 */
	 @GetMapping({"", "/", "/index", "/01"})
	 @AdminLoginAspect(resType = RESPONSE_TYPE.MOVE)
	 public ModelAndView adm_01(HttpServletRequest request) {
		 ModelAndView mv = new ModelAndView("/admin/04/01");
		 return mv;
	 }
	
	

	 //확인하고 수정하기
	 @PostMapping("/01PA")
	 @AdminLoginAspect
	 public @ResponseBody ModelAndView adm_01PA(HttpServletResponse response, @RequestBody JSONObject paramJson) throws Exception {
	 	 ModelAndView mv = new ModelAndView("/admin/04/01");
		
		 JSONObject bean 			= null;
		 JSONResMessage resJson 		= null;
		 try {
		 	bean = this.aDM04Service.adm_01PA(paramJson, response);
		 	System.out.println("!!!!!!!!!!!!!!!!!!PASS!!!!!!!!!!!!!!!bean:"+bean);
		 } catch(Exception e) { 
		 	  LOGGER.error("adm_01AE", e); 
		 	  resJson = new JSONResMessage(JSONResMessage.FAIL, "요청작업 처리중 오류가 발생했습니다"); 
		 }
		 System.out.println("!!!!!!!!!!!!!!DONE!!!!!!!!!!!!!mv:"+mv);
		 
		 return mv;
	 }
	 
	 
}


