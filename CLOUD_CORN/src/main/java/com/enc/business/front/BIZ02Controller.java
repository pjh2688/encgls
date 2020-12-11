package com.enc.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enc.config.SolutionConfig;

@Controller
@RequestMapping({"/front/02"})
public class BIZ02Controller {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
    /**
     * 서비스 이용절차
     * 
     * @return
     */
    @GetMapping({"", "/", "/index", "/01"})
	public ModelAndView biz02_01(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/02/01");
		return mv;
	}
    
    /**
     * 클라우드(Saas) WMS 요금체계
     * 
     * @return
     */
    @GetMapping({"/02"})
	public ModelAndView biz02_02(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/02/02");
		return mv;
	}
    
}
