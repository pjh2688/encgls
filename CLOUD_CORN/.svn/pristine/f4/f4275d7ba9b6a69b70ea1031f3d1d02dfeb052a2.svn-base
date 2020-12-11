package com.enc.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
    /**
     * 기업소개
     * 
     * @return
     */
    @GetMapping({"", "/", "/index"})
	public ModelAndView index(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/index");
		return mv;
	}
}
