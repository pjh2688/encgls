package com.enc.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enc.config.SolutionConfig;

@Controller
@RequestMapping({"/front/about", "/front/05"})
public class BIZ05Controller {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
    /**
     * 회사소개
     * 
     * @return
     */
    @GetMapping({"", "/", "/index", "/01"})
	public ModelAndView biz05_01(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/05/01");
		return mv;
	}
    
    /**
     * 오시는길
     * 
     * @return
     */
    @GetMapping({"/02"})
	public ModelAndView biz05_02(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/05/02");
		return mv;
	}
}
