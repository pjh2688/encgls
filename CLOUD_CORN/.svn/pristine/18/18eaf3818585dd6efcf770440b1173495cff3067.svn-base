package com.enc.business.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.enc.aop.AdminLoginAspect;
import com.enc.config.SolutionConfig;
import com.typhoon.framework.HttpServletResponseUtil;
import com.typhoon.framework.STRINGUtil;
import com.typhoon.framework.aop.RESPONSE_TYPE;
import com.typhoon.framework.json.JSONResMessage;

@Controller
@RequestMapping({"/admin/03"})
public class ADM03Controller {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Autowired
	private ADM03Service aDM03Service;
	
    /**
     * 관리자/고객관리/고객정보
     * 
     * @return
     */
    @GetMapping({"", "/", "/index", "/01"})
    @AdminLoginAspect(resType = RESPONSE_TYPE.MOVE)
	public ModelAndView adm03_01(HttpServletRequest request) {
		/* String path = (new UrlPathHelper()).getPathWithinApplication(request); */
    	ModelAndView mv = new ModelAndView("/admin/03/01");
		return mv;
	}
    
    
    @PostMapping("/01AL")
	@AdminLoginAspect
	public @ResponseBody JSON adm_01AL(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= null;
		
		try {
			resJson 				= this.aDM03Service.adm_01AL(paramJson);
		} catch(Exception e) {
			LOGGER.error("adm_01AL", e);
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청작업 처리중 오류가 발생했습니다");
		}
		
		return resJson.getResponseMessage();
	}
   
	
	  @GetMapping(value = "/01PA/{USERID}")
	  @AdminLoginAspect(resType = RESPONSE_TYPE.MOVE) 
	  public ModelAndView adm_01PA(@PathVariable("USERID") String USERID) throws Exception {
		  ModelAndView mv = new ModelAndView("/admin/03/01PA");
		  
		  JSONObject bean 			= null;
		  JSONObject param = new JSONObject();
		  
		  param.put("userid", USERID);
			
		  try { 
			  bean = this.aDM03Service.adm_01PA(param);
		  
		  } catch(Exception e) { 
			  LOGGER.error("adm_01PA", e); 
		  }
		  mv.addObject("bean", bean);
	
		  return mv; 
	  }
	 
	  
	  @GetMapping(value = "/01PS/{USERID}")
	  @AdminLoginAspect(resType = RESPONSE_TYPE.MOVE) 
	  public ModelAndView adm_01PS(@PathVariable("USERID") String USERID) throws Exception {
		  ModelAndView mv = new ModelAndView("/admin/03/01PS");
		  
		  JSONObject bean 			= null;
		  JSONObject param = new JSONObject();
		  
		  param.put("userid", USERID);
			
		  try { 
			  bean = this.aDM03Service.adm_01PS(param);
		  
		  } catch(Exception e) { 
			  LOGGER.error("adm_01PS", e); 
		  }
		  
		  mv.addObject("bean", bean);
		  return mv; 
	  }
	  
	  
   
    
}
