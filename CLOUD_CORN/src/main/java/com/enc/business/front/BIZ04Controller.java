package com.enc.business.front;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.enc.config.SolutionConfig;
import com.enc.dto.PageMaker;
import com.enc.dto.User;
import com.typhoon.framework.STRINGUtil;

@Controller
@RequestMapping({"/front/04"})
public class BIZ04Controller {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig solutionConfig;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BIZ04Service biz04Service;
	
    /**
     * 대시보드
     * 
     * @return
     */
    @GetMapping({"", "/", "/index", "/01"})
	public ModelAndView biz04_01(HttpServletRequest request, Model model) {
    	ModelAndView mv = new ModelAndView("/front/04/01");
   
    	HttpSession session = request.getSession(true);
    	
    	/* 1. session에 어떤 이름의 키값으로 들어가 있는지 확인 하는 작업.*/
    	Enumeration<String> e = session.getAttributeNames(); 
    	
    	/* 2. session에 저장된 값들을 Enumeration(열거형)에 저장한뒤 차례대로 출력(String으로 주면 키 값이 나온다.)*/
    	while(e.hasMoreElements()) {
    		String sessionAttribute = (String)e.nextElement();
    		System.out.println(sessionAttribute);
    	}
    	
    	System.out.println(session.getAttribute("MEMBER_USERID"));
    	
    	
    	String userid = (String)session.getAttribute("MEMBER_USERID");
    	
    	String value = biz04Service.statusInfo(userid);
    	
    	System.out.println(value);
    	
    	model.addAttribute("userid", userid);
    	model.addAttribute("service_status", value);
    	
		return mv;
	}
    
    @PostMapping("01")
   	@ResponseBody
   	public Map<String, Object> biz04_04(@RequestBody String service_status) { // ajax로 날라온 데이터가 여기에 저장됨
   			
   		Map<String, Object> map = new HashMap<String, Object>();
   			
   			
   		// 9. 응답 데이터 세팅(ajax랑 주고 받음)
   		map.put("service_status", service_status);
   			
   		return map;
   	}
    
    
    /**
     * 서비스이용현황  
     * 
     * @return
     */
    @GetMapping({"/02"})
	public ModelAndView biz04_02(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/04/02");
		return mv;
	}
    
    /**
     * 서비스관리
     * 
     * @return
     */
    @GetMapping({"/03"})
	public ModelAndView biz04_03(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/04/03");
		return mv;
	}
    
    /**
     * 공실정보 - get -> 2020-12-01 -> 공실정보 뿌려주는거 하고 있는중
     * 
     * @return
     */
    @GetMapping({"/04"})
	public ModelAndView biz04_04(HttpServletRequest request) {
    	
    	PageMaker pageMaker = new PageMaker();
    	
    	String pageNum = request.getParameter("pageNum");
    	int contentNum = 10;
		int cpageNum = STRINGUtil.getParam(pageNum, 1);  // 현재 페이지 번호를 int로 변환.
		
		pageMaker.setTotalCount(biz04Service.totalCnt());  // 전체 게시글 수 지정
		pageMaker.setPageNum(cpageNum);  // 현재 페이지로 설정
		pageMaker.setContentNum(contentNum);  // 한 페이지당 보여줄 게시글 수 지정.
		pageMaker.setCurrentBlock(cpageNum);  // 현재 페이지 번호로 페이지 블록의 번호를 지정한다. (endPae 계산을 위해 필요)
		pageMaker.setLastBlock(pageMaker.getTotalCount());  // 전체 게시글 수로 마지막 페이지 블록의 번호를 지정한다.
		pageMaker.setStartPage(pageMaker.getCurrentBlock());  // 현재 페이지 블록의 번호르 시작페이지 번호를 구해온다.
		pageMaker.setEndPage(pageMaker.getCurrentBlock(), pageMaker.getLastBlock());  // 현재 페이지 블록번호와 마지막 블록의 번호로 현제 페이지 블록의 끝 페이지 번호를 구해온다.
		pageMaker.prevnext(cpageNum);  // 현재 페이지 번호로 화살표를 나타낼지 구해온다.
		
		ModelAndView mv = new ModelAndView("/front/04/04");
			
		System.out.println("전체 게시글 수 : " + pageMaker.getTotalCount());
	    System.out.println("현재 페이지 번호 : " + pageMaker.getPageNum());
	    System.out.println("한 페이지 당 보여줄 게시글 수 : " + pageMaker.getContentNum());
	    System.out.println("현재 페이지 블록 번호 : " + pageMaker.getCurrentBlock());
	    System.out.println("마지막 페이지의 블록 번호 : " + pageMaker.getLastBlock());
	    System.out.println("현재 페이지 블록의 시작 페이지 번호 : " + pageMaker.getStartPage());
	    System.out.println("현재 페이지 블록의 마지막 페이지 번호 : " + pageMaker.getEndPage());
	    System.out.println("한 블록 당 페이지 수 : " + pageMaker.getPageCount());
	    System.out.println("prev : " + pageMaker.isPrev());
	    System.out.println("next : " + pageMaker.isNext());
	    
		mv.addObject("list", biz04Service.cwlInfo());
		mv.addObject("page", pageMaker);
    	
		return mv;
	}

    
    /**
     * 정보수정
     * 
     * @return
     */
    @GetMapping({"/05"})
	public ModelAndView biz04_05(HttpServletRequest request) throws Exception {
    	ModelAndView mv = new ModelAndView("/front/04/05");
    	
    	HttpSession session = request.getSession(true);
    	
    	String userid = (String)session.getAttribute("MEMBER_USERID");
    	
    	
    	try {
    		
    		User user = biz04Service.userInfo(userid);
    		mv.addObject("user", user);
    		

    	} catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	
		return mv;
	}
    
    // ajax 통신할땐 dto에 변수들을 소문자로 해줘야 된다. 만약 _바가 있다면 문제가 생긴다. 예를 들어 모두 대문자로 썼을때 A_B로 어떤 변수를 설정했다면 a_B로 json으로 넘어갈때 바뀌어서 데이터가 제대로 전달이 안된다.(dto에서는 그냥 전부 언더바를 사용하든 안하든 소문자로)
    @PostMapping("05")
   	@ResponseBody
   	public Map<String, Object> biz04_05(@RequestBody User user) throws Exception { // ajax로 날라온 데이터가 여기에 저장됨
    	Map<String, Object> map = new HashMap<String, Object>();	
    	
    	try {
    		// 9. 응답 데이터 세팅(ajax랑 주고 받음)
		
    		biz04Service.userUpdate(user);
		
    		map.put("user", user);
		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
   	
   		return map;
   	}
    
    @PostMapping("05/emailDupCheck")
   	@ResponseBody
   	public Map<String, Object> biz04_05(@RequestBody String input_email) throws Exception { // ajax로 날라온 데이터가 여기에 저장됨
    	Map<String, Object> map = new HashMap<String, Object>();	
    	
   
    	int result = biz04Service.isEmail(input_email);
    	
    	if(result == 1)  // 데이터베이스에 이미 해당 이메일이 있다면 이쪽
    	{
    		map.put("result", result);
    	}
    	
   	
   		return map;
   	}
    
    
    /**
     * 서비스탈퇴
     * 
     * @return
     */
    @GetMapping({"/06"})
	public ModelAndView biz04_06(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("/front/04/06");
		return mv;
	}
    
   
    
    /*
    	public static final String SERVICE_STATUS_APPLY 			= "A"; 	// 서비스 신청(서비스 신청 및 VM 자동 생성중)
		public static final String SERVICE_STATUS_ERROR          	= "E";  // 서비스 생성중 에러 발생
		public static final String SERVICE_STATUS_COMPLETE 			= "C"; 	// 서비스 신청 완료
		public static final String SERVICE_STATUS_DESTROY           = "D";  // 서비스 계약 종료, 완료일 업데이트할 것
		public static final String SERVICE_STATUS_NOT               = "N";  // 서비스 신청 내역 없음.
    */
    

}
