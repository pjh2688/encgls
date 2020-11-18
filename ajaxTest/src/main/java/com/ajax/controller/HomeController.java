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
import com.ajax.dao.IUserMapper;
import com.ajax.dto.Member;
import com.ajax.dto.TestDto;
import com.ajax.service.UserServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	IMemberMapper mm;
	
	@Autowired
	IUserMapper um;
	
	@Autowired  // @Autowired : new로 객체 생성을 안해도 자동으로 객체를 만들어주고 사용할 수 있게 만들어주는 어노테이션 , 이것을 의존성 주입(dependency Injection)이라고 한다.
	UserServiceImpl us;

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
	
	
	// 1. ajax 테스트 get 1
	@GetMapping("/test/ajax01")
	public String testAjax01() {
		return "testForm01";
	}
	
	// 4. ajax 테스트 post 1
	@PostMapping("/test/ajax01")
	@ResponseBody
	public Map<String, Object> testAjax01(@RequestBody TestDto dto) { // ajax로 날라온 데이터가 여기에 저장됨
		Map<String, Object> result = new HashMap<String, Object>();

		// 3. 응답 데이터 세팅(ajax랑 주고 받음)
		result.put("id", dto.getId());
		result.put("pw", dto.getPw());

		System.out.println(result.get("id"));
		System.out.println(result.get("pw"));

		return result;
	}
	
	// 3. ajax 테스트 get 2
	@GetMapping("/test/ajax02")
	public String testAjax02() {
		return "testForm02";
	}
	
	// 4. ajax 테스트 post 2
	@PostMapping("/test/ajax02")
	@ResponseBody
	public Map<String, Object> testAjax(@RequestBody TestDto dto) {  // ajax로 날라온 데이터가 여기에 저장됨
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 3. 응답 데이터 세팅(ajax랑 주고 받음)
		result.put("id", dto.getId());
		result.put("pw", dto.getPw());
		
		// 4. DB에 insert
		um.signUp(dto);
		
		System.out.println(result.get("id"));
		System.out.println(result.get("pw"));
		
		return result;
	}
}

/*
   * Ajax란? 
  -> Ajax는 JavaScript의 라이브러리중 하나이며 Asynchronous Javascript And Xml(비동기식 자바스크립트와 xml)의 약자입니다. 
           브라우저가 가지고있는 XMLHttpRequest 객체를 이용해서 전체 페이지를 새로 고치지 않고도 페이지의 일부만을 위한 데이터를 로드하는 기법이며 
     Ajax를 한마디로 정의하자면 JavaScript를 사용한 비동기 통신, 클라이언트와 서버간에 XML 데이터를 주고받는 기술이라고 할 수 있겠습니다. 
 
   * 비동기(async)방식이란?
  -> 비동기 방식은 웹페이지를 리로드하지 않고 데이터를 불러오는 방식입니다. 
           이 방식의 장점은 페이지 리로드의 경우 전체 리소스를 다시 불러와야하는데 이미지,스크립트,기타 코드등을 모두 재요청할 경우
           불 필요한 리소스 낭비가 발생하게 되지만 비동기식 방식을 이용할 경우 필요한 부분만 불러와 사용할 수 있으므로 매우 큰 장점이 있습니다.
           
   * 왜 사용하는가? 
  -> 기본적으로 HTTP프로토콜은 클라이언트쪽에서 Request를 보내고 Server쪽에서 Response를 받으면 이어졌던 연결이 끊기게 되어있습니다. 
           그래서 화면의 내용을 갱신하기 위해서는 다시 request를 하고 response를 하면서 페이지 전체를 갱신하게 됩니다. 
           하지만 이렇게 할 경우 페이지의 일부분만 갱신할 경우에도 페이지 전체를 다시 로드해야하는데 엄청난 자원낭비와 시간낭비를 초래하고 말것입니다. 
           하지만 ajax는 html 페이지 전체가 아닌 일부분만 갱신할수 있도록 XML HttpRequest객체를 통해 서버에 request를 합니다. 
           이 경우 Json이나 xml형태로 필요한 데이터만 받아 갱신하기 때문에 그만큼의 자원과 시간을 아낄 수 있습니다. 
           요새 웹페이지에서 가장 중요한것은 속도가 아닐까싶습니다. 이 이유하나만으로도 Ajax를 사용해야 하는 이유로써 충분합니다.
           
   * Ajax의 장점
	1. 웹페이지의 속도향상
	2. 서버의 처리가 완료 될때까지 기다리지 않고 처리 가능하다.
	3. 서버에서 Data만 전송하면 되므로 전체적인 코딩의 양이 줄어든다.
	4. 기존 웹에서는 불가능했던 다양한 UI[User Interface]를 가능하게 해준다. 
	사진공유 사이트 Flickr의 경우 사진의 제목이나 태그를 페이지 리로드 없이 수정할 수 있다.

   * Ajax 의 단점
	1. 히스토리 관리가 안 된다. (보안에 좀 더 신경을 써야한다.)
	2. 연속으로 데이터를 요청하면 서버 부하가 증가할 수 있다.
	3. XMLHttpRequest를 통해 통신을 하는 경우사용자에게 아무런 진행 정보가 주어지지 않는다. 
	그래서 아직 요청이 완료되지 않았는데 사용자가 페이지를 떠나거나 오작동할 우려가 발생하게 된다. 
	
   * Jquery와의 시너지  
  -> Ajax하면 Jquery에 대한 설명을 빼놓을 수 없습니다. 
  	  일반 Javascript만으로 Ajax를 하게되면 코딩량도 많아지고 브라우저별로 구현방법이 다르다는 단점이 있는데 
  	 jquery를 이용하면 더 적은 코딩량과 동일한 코딩방법으로 대부분의 브라우저에서 같은 동작을 할 수 있게 됩니다. 
  	 jquery ajax를 사용하면, HTTP Get방식과 HTTP Post방식 모두를 사용하여 원격 서버로부터 데이터를 요청할 수 있습니다. 
  	 Jquery는 Ajax처럼 JavaScript의 라이브러리 중 하나인데 자바스크립트를 좀 더 사용하기 쉽게 패키징화 시켜놓은 것입니다. 
  	 
   * 싱글톤(Singleton)이란?
  -> 웹 서버는 구조적으로 서버에 접근하는 각 클라이언트들을 스레드의 개념으로 접근시키게 한다. 스프링을 사용하지 않고 웹 프로젝트를 만든다면
           일반적인 구조에서는 만약 3명의 사용자가 서버에 접근한다고 가정해보면 사용자가 3명이나 3개의 객체를 생성하고 그에 따라 3개의 스레들을 또 따로 만든다.
           사용자만큼 스레들을 생성하게 되고 그 객체의 메모리가 서버의 힙 메모리 공간에 저장되게 된다. 말 그대로 100명이 접근하면 100개 객체를 만들고 100개의 스레드를 할당한다는 말.
    
  -> 반면 스프링프레임워크에서 제공하는 방식은 일반적인 구조처럼 클라이언트 수에 맞춰 new를 해서 객체를 계속 만들어 주는 것이 아니라
     xml 파일에 bean(db정보 같은 것)을 정의(등록)해놓고 각각의 스레드들이 해당 자원(bean)을 공유하면서 사용하게 하는 방식이다.
           이렇게 하면 결과적으로 서버의 힙 공간에는 스레드마다 객체의 메모리가 계속 생성되는 것이 아니라
           서버의 힙 공간에는 1개의 bean만  처음 프로젝트가 부팅될 때 생성되고 그 bean을 가지고 해당 스레드들이 공유하는 방식을 사용하게 된다.
           보통 등록된 bean은 @Autowired 어노테이션으로 주입해서 사용한다.

 */

