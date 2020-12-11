package com.enc.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.enc.aop.MemberLoginAspect;
import com.enc.aop.MemberNotLoginAspect;
import com.enc.aop.ValidationAspect;
import com.enc.config.MemberSession;
import com.enc.config.SolutionConfig;
import com.typhoon.framework.json.JSONResMessage;

@Controller
@RequestMapping("/front/member")
public class MemberController {
	private final org.slf4j.Logger LOGGER 			= org.slf4j.LoggerFactory.getLogger("TYPHOON_LOG");
	
	@Autowired
    private SolutionConfig typhoonSolutionConfig;
	
	@Autowired
	private MemberService mbr0100Service;
	
	
	@GetMapping({"/join"})
	public String join(HttpServletRequest request) {
		return "/front/member/join";
	}
	
	/**
	 * 사용자 등록시 userid가 중복되는지 여부 반환
	 * 
	 * @param request
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/checkduple")
	public @ResponseBody JSON checkduple(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= null;
		try {
			// 사용자 계정은 모두 소문자만 사용한다
			if (paramJson.containsKey("userid")) {
				paramJson.put("userid", paramJson.getString("userid").toLowerCase());
			}
			
			// KT 계정은 모두 소문자만 사용한다
			if (paramJson.containsKey("ktcloudid")) {
				paramJson.put("ktcloudid", paramJson.getString("ktcloudid").toLowerCase());
			}
			resJson 				= this.mbr0100Service.isdupleUserId(paramJson);
		} catch(Exception e) {
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청처리중 오류 발생");
		}
		
		return resJson.getResponseMessage();
	}
	
	/**
	 * 회원가입
	 * 
	 * @param request
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/join")
	@MemberNotLoginAspect
	@ValidationAspect(stringIds= {"userid", "ktcloudid", "password", "usernm", "hphone", "email", "comp_name", "biznum", "comp_addr"}, stringTitles= {"사용자 아이디", "kt클라우드ID", "비밀번호", "담당자 이름", "휴대전회번호", "이메일", "사업자 상호", "사업자 등록번호", "사업장 주소"})
	public @ResponseBody JSON register(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		// 사용자 계정은 모두 소문자만 사용한다
		if (paramJson.containsKey("userid")) {
			paramJson.put("userid", paramJson.getString("userid").toLowerCase());
		}
		
		// KT 계정은 모두 소문자만 사용한다
		if (paramJson.containsKey("ktcloudid")) {
			paramJson.put("ktcloudid", paramJson.getString("ktcloudid").toLowerCase());
		}
		
		JSONResMessage resJson 		= null;
		JSONObject sqlJson 			= new JSONObject();
		try {
			sqlJson.put("userid", paramJson.get("userid"));
			JSONResMessage chkJson 	= this.mbr0100Service.isdupleUserId(sqlJson);
			if (((JSONObject)chkJson.getBody()).getString("isduple").equalsIgnoreCase("Y")) {
				// 아이디 중복
				resJson 			= new JSONResMessage(JSONResMessage.FAIL, "아이디가 중복됩니다");
			} else {
				sqlJson.clear();
				sqlJson.put("ktcloudid", paramJson.get("ktcloudid"));
				chkJson 	= this.mbr0100Service.isdupleUserId(sqlJson);
				if (((JSONObject)chkJson.getBody()).getString("isduple").equalsIgnoreCase("Y")) {
					// KT아이디 중복
					resJson 		= new JSONResMessage(JSONResMessage.FAIL, "KT 아이디가 중복됩니다");
				} else {
					resJson 		= this.mbr0100Service.insert(paramJson);
					resJson.put("url", "/");
					resJson.setStatusAndDefaultMessage(JSONResMessage.SUCCESS);
					// 센선 생성
					MemberSession.setMemberInfo(request, MemberSession.MEMBER_GRADE_USER, paramJson.getString("userid"), paramJson.getString("usernm"));
				}
			}
		} catch(Exception e) {
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청처리중 오류 발생");
		}
		
		return resJson.getResponseMessage();
	}
	
	
	
	@GetMapping({"", "/", "/index", "/login"})
	public String login(HttpServletRequest request) {
		return "/front/member/login";
	}
	
	/**
	 * 로그인
	 * 
	 * @param request
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	@MemberNotLoginAspect
	@ValidationAspect(stringIds= {"userid", "password"}, stringTitles= {"사용자 아이디", "패스워드"})
	public @ResponseBody JSON login(HttpServletRequest request, @RequestBody JSONObject paramJson) throws Exception {
		JSONResMessage resJson 		= null;
		try {
			resJson 				= this.mbr0100Service.login(request, paramJson);
		} catch(Exception e) {
			resJson 				= new JSONResMessage(JSONResMessage.FAIL, "요청처리중 오류 발생");
		}
		
		return resJson.getResponseMessage();
	}
	
	@GetMapping({"/logout"})
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		ModelAndView mv 	= new ModelAndView(new RedirectView("/"));
		MemberSession.logout(request.getSession());
		
        return mv;
	}
	
	
	
}
