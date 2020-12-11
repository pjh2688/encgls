package com.enc.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enc.config.SolutionConfig;

@Controller
@RequestMapping({"/front/01"})
public class BIZ01Controller {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
    /**
     * 제품소개
     * 
     * @return
     */
    @GetMapping({"", "/", "/index", "/01"})
	public ModelAndView biz05_01(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/01/01");
		return mv;
	}
    
    @GetMapping("/01/corn-wms")
    public ModelAndView corn_wms() {
    	ModelAndView mv = new ModelAndView("/front/01/corn-wms");
    	return mv;
    }
    
    @GetMapping("/01/corn-cloud")
    public ModelAndView corn_cloud() {
    	ModelAndView mv = new ModelAndView("/front/01/corn-cloud");
    	return mv;
    }
    
    @GetMapping("/01/corn-block")
    public ModelAndView corn_block() {
    	ModelAndView mv = new ModelAndView("/front/01/corn-block");
    	return mv;
    }
    
    @GetMapping("/01/corn-iot")
    public ModelAndView corn_iot() {
    	ModelAndView mv = new ModelAndView("/front/01/corn-iot");
    	return mv;
    }
}
