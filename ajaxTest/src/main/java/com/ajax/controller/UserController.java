package com.ajax.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.dao.IBoardMapper;
import com.ajax.dao.IUserMapper;
import com.ajax.dto.PageMaker;
import com.ajax.dto.User;
import com.ajax.service.BoardServiceImpl;
import com.ajax.service.UserServiceImpl;
import com.ajax.util.CaptchaUtil;

import nl.captcha.Captcha;

@Controller
public class UserController {
	
	@Autowired
	IUserMapper um;
	
	@Autowired  // @Autowired : new로 객체 생성을 안해도 자동으로 객체를 만들어주고 사용할 수 있게 만들어주는 어노테이션 , 이것을 의존성 주입(dependency Injection)이라고 한다.
	UserServiceImpl us;
	
	@Autowired
	IBoardMapper bm;
	
	@Autowired
	BoardServiceImpl bs;
	
	PageMaker pageMaker = new PageMaker();
	
	@RequestMapping(value = {"/", "/index"})
	public String index(HttpServletRequest request, Model model) {
		
		// 전체 게시글 수와 한 페이지 당 뿌려줄 게시글 수를 가지고 전체 page 수를 구한다
		pageMaker.setContentNum(10);
		pageMaker.setTotalCount(bs.totalCnt());
		int totalPage = pageMaker.calcPage(pageMaker.getTotalCount(), pageMaker.getContentNum());
		
		model.addAttribute("totalPage", totalPage);
		
		System.out.println(totalPage);
		
		return "index";
	}
	
	// 1. 회원가입 1
	@GetMapping("/member/join")
	public String joinForm() {
		return "member/joinForm";
	}
		
	// 2. 회원가입 2
	@PostMapping("/member/join")
	@ResponseBody
	public Map<String, Object> join(@RequestBody User dto) { // ajax로 날라온 데이터가 여기에 저장됨
		Map<String, Object> map = new HashMap<String, Object>();
			
		int result = us.join(dto);
		
		// 7. 응답 데이터 세팅(ajax랑 주고 받음)
		map.put("result", result);
			
		return map;
	}
		
	// 3. 회원가입 3 - id 중복체크
	@PostMapping("/member/id_check")
	@ResponseBody
	public Map<String, Object> id_check(@RequestBody String id) { // ajax로 날라온 데이터가 여기에 저장됨
			
		Map<String, Object> map = new HashMap<String, Object>();
			
		int result = 0;
			
		result = um.id_check(id);
			
		// 9. 응답 데이터 세팅(ajax랑 주고 받음)
		map.put("check", result);
		map.put("value", id);
			
		return map;
	}
		
	// 4. 회원가입 4 - ktcloudid 중복체크
	@PostMapping("/member/ktcloudid_check")
	@ResponseBody
	public Map<String, Object> ktcloudid_check(@RequestBody String ktcloudid) { // ajax로 날라온 데이터가 여기에 저장됨
				
		Map<String, Object> map = new HashMap<String, Object>();
				
		int result = 0;

		result = um.ktIdCheck(ktcloudid);
				
		// 11. 응답 데이터 세팅(ajax랑 주고 받음)
		map.put("check", result);
		map.put("value", ktcloudid);
				
		return map;
	}
	
	// 5. 로그인
	@GetMapping("/member/login")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@PostMapping("/member/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request, @RequestBody User dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int result = 0;
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("userid"));
		
		/* session에 어떤 값으로 들어가 있는지 확인 하는 작업.*/
    	Enumeration<String> e = session.getAttributeNames();
    	
    	while(e.hasMoreElements()) {
    		String sessionAttribute = (String)e.nextElement();
    		System.out.println(sessionAttribute);
    	}
		
		// 1. 전달된 id,pw 정보로 db에서 사용자 정보를 가지고온다.
		result = us.userInfo(dto);
		
		// 아이디가 DB에 있는지 확인
		
		// 아이디가 DB에 있으면 비밀번호가 맞는지 확인
		
		
		map.put("check", result);
		map.put("userid", dto.getUserid());
		
		if(result == 0) {  // 2. 해당 사용자가 없다면 
			System.out.println("아이디와 비밀번호를 확인해주세요.");
		} else if(result == 1) {
			// 3. 브라우저 창 각각 마다 세션 값이 다르다.
			session.setAttribute("userid", dto.getUserid());
				
			System.out.println("안녕하세요. " + dto.getUserid() + "님");
			System.out.println(session.getAttribute("userid"));
			
		}
		
		return map;
	}
	// 6. 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		
		// 로그아웃시 null을 반환함.
		System.out.println("안녕히가세요. " + session.getAttribute("userid") + "님");
		System.out.println(session.getAttribute("userid"));
		session.removeAttribute("userid");
		System.out.println(session.getAttribute("userid"));
		return "redirect:/index";
	}
	
	// 내일 어떻게 돌아가는지 분석해야한
	
	// captcha 이미지 가져오는 메서드
	@GetMapping("/member/captchaImg")
	@ResponseBody
	public void captchaImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new CaptchaUtil().getImgCaptCha(request, response);
	}
	// 전달 받은 문자열로 음성 가져오는 메소드
	@GetMapping("/member/captchaAudio")
	@ResponseBody
	public void captchaAudio(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Captcha captcha = (Captcha)request.getSession().getAttribute(Captcha.NAME);
		String getAnswer = captcha.getAnswer();
		new CaptchaUtil().getAudioCaptCha(request, response, getAnswer);
	}
	
	// 사용자가 입력한 보안문자를 체크하는 메소드
	@PostMapping("/member/chkAnswer")
	@ResponseBody
	public Map<String, Object> chkAnswer(HttpServletRequest request, HttpServletResponse response, @RequestBody String ans) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String result = "";
		
		Captcha captcha = (Captcha)request.getSession().getAttribute(Captcha.NAME);
		
		System.out.println(captcha.getAnswer());
		
		String answer = ans;
		
		System.out.println(answer);
		
		if(answer != null && ! " ".equals(answer)) {
			if(captcha.isCorrect(answer)) {
				// request.getSession().removeAttribute(Captcha.NAME);  // 세션에서 캡차 제거
				result = "200";
			} else {
				result = "300";
			}
		} 
		System.out.println(result);
		map.put("check", result);
		
		return map;
	}
	
}
