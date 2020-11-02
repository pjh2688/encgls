package com.ajax.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ajax.dao.IMemberMapper;
import com.ajax.dto.Member;
import com.ajax.dto.TestDto;

@Controller
public class HomeController {
	
	@Autowired
	IMemberMapper mm;

	@RequestMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello");
		return "hello";
	}
	
	@RequestMapping("member")
	public String member(Model model) {
		model.addAttribute("member", mm.listMembers());
		return "member";
	}
	
	// 1. @ResponseBody를 이용해 JSON 형태로 view로 전송
	@RequestMapping("ajax01")
	@ResponseBody
	public Map<String, Object> ajaxTest01() {
		Map<String, Object> map = new HashMap<String, Object>();
				
		map.put("member", mm.listMembers());
		
		return map;
	}
	
	// 2. @ResponseBody를 이용해 JSON 형태로 view로 전송
	@RequestMapping("ajax02")
	@ResponseBody
	public ModelAndView ajaxTest02(Model model) {
		
		// list
		List<Member> list = new ArrayList<Member>();
			
		list.addAll(mm.listMembers());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ajaxTest01");
		mav.addObject("list", list);
		
		// map
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 2-1.
		map.put("member_id", mm.listMembers().get(0).getMember_id());
		map.put("member_name", mm.listMembers().get(0).getMember_name());
		map.put("member_age", mm.listMembers().get(0).getMember_age());
		
		// 2-2. map를 통채로
//		map.put("m", mm.listMembers());
		
		mav.addObject("map", map);
		
		return mav;
	}
	
	// 다음에 json으로 보낸 데이터를 ajax로 걸러내는 작업 해야한다.
	@RequestMapping("ajax03")
	@ResponseBody
	public ModelAndView ajaxTest03(Model model) {
		
		// map
		Map<String, Object> map = new HashMap<String, Object>();
				
		// 2-1.
		map.put("member_id", mm.listMembers().get(0).getMember_id());
		map.put("member_name", mm.listMembers().get(0).getMember_name());
		map.put("member_age", mm.listMembers().get(0).getMember_age());
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	
	// 1. ajax 테스트 get
	@GetMapping("/test/ajax")
	public String testAjax() {
		return "testForm";
	}
	
	// 2. ajax 테스트 post
	@PostMapping("/test/ajax")
	@ResponseBody
	public Map<String, Object> testAjax(@RequestBody TestDto dto) {  // ajax로 날라온 데이터가 여기에 저장됨
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		
		// 응답 데이터 세팅(ajax랑 주고 받음)
		result.put("id", dto.getId()+dto.getId());
		result.put("pw", dto.getPw()+dto.getPw());
		
		return result;
	}
	
	
}
