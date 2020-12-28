package com.ajax.controller;

import java.util.HashMap;
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

import com.ajax.dao.IBoardMapper;
import com.ajax.dao.IUserMapper;
import com.ajax.dto.Board;
import com.ajax.dto.PageMaker;
import com.ajax.dto.User;
import com.ajax.service.IBoardService;
import com.ajax.service.IUserService;


@Controller
public class BoardController {
	
	@Autowired
	IBoardMapper bm;
	
	@Autowired
	IBoardService bs;
	
	@Autowired
	IUserMapper um;
	
	@Autowired
	IUserService us;
	
	PageMaker pageMaker = new PageMaker();
	
	
	/*
	 *  1. 조회.
	 */
	@RequestMapping("/board/list")
	public ModelAndView list(HttpServletRequest request, Model model, HttpSession session) {
	
		System.out.println(session.getAttribute("userid"));
		
		
		String page = request.getParameter("page");
		
		int contentNum = 10;
		
		if(page == null) {
			page = "1";
			
		}
		
		int cpage = Integer.parseInt(page);  // 현재 페이지 번호를 int로 변환.
		
		pageMaker.setTotalCount(bm.count());  // 전체 게시글 수 지정
		pageMaker.setPageNum(cpage);  // 현재 페이지로 설정
		pageMaker.setContentNum(contentNum);  // 한 페이지당 보여줄 게시글 수 지정.
		pageMaker.setCurrentBlock(cpage);  // 현재 페이지 번호로 페이지 블록의 번호를 지정한다. (endPae 계산을 위해 필요)
		pageMaker.setLastBlock(pageMaker.getTotalCount());  // 전체 게시글 수로 마지막 페이지 블록의 번호를 지정한다.
		pageMaker.setStartPage(pageMaker.getCurrentBlock());  // 현재 페이지 블록의 번호르 시작페이지 번호를 구해온다.
		pageMaker.setEndPage(pageMaker.getCurrentBlock(), pageMaker.getLastBlock());  // 현재 페이지 블록번호와 마지막 블록의 번호로 현제 페이지 블록의 끝 페이지 번호를 구해온다.
		pageMaker.prevnext(cpage);  // 현재 페이지 번호로 화살표를 나타낼지 구해온다.
		
		ModelAndView mav = new ModelAndView("/board/list");
		
		System.out.println("총 페이지 수 : " + pageMaker.calcPage(pageMaker.getTotalCount(), pageMaker.getContentNum()));
		
		mav.addObject("list", bs.listAllService(pageMaker));
		mav.addObject("page", pageMaker);
		
		return mav;
	}
	
	/*
	 * 2. 글쓰기  - get
	 */
	@GetMapping("/board/write")
	public String write(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(true);
		String userid = (String)session.getAttribute("userid");
		User user = us.findById(userid); 
	
		model.addAttribute("user", user);
		
		return "/board/writeForm";
	}
	
	/*
	 * 3. 글쓰기 - post
	 */
	@PostMapping("/board/write")
	@ResponseBody
	public Map<String, Object> write(HttpServletRequest request, @RequestBody Board board) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println("제목 : " + board.getB_tit());
		System.out.println("내용 : " + board.getB_cont());
		System.out.println("아이디 : " + board.getUserid());
		System.out.println("게시글 비밀번호 : " + board.getB_pw());
		
		bs.createService(board);
		
		int totalPage = pageMaker.calcPage(pageMaker.getTotalCount(), pageMaker.getContentNum());
		
		System.out.println("총 페이지 수 : " + totalPage);
		
		map.put("board", board);
		map.put("totalPage", totalPage);
		
		return map;
	}
	
	/*
	 * 4. 글 상세보기 - get 2020-12-24 여기서부터 다시 : 가상 글번호 list로 뿌려줬지만 읽을때도 가상번호르 읽고 조회할때만 진짜 번호로 조회
	 */
	@GetMapping("/board/contentView")
	public String content_view(HttpServletRequest request, Model model) {
		String b_no = request.getParameter("b_no");
		
		Board board = bs.readService(Integer.parseInt(b_no));
		
		System.out.println(board.getUsernm());
		
		model.addAttribute("board", board);
		
		System.out.println(b_no);
		
		return "/board/contentView";
	}
	
	/*
	 * 5. 작성 글 비밀번호 체크
	 */
	@PostMapping("/board/pwdChk")
	@ResponseBody
	public Map<String, Object> passwordCheck(HttpServletRequest request, @RequestBody int b_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("b_pw", bs.board_pw(b_no));
		map.put("result", "success");
		return map;
	}
	
	
	/*
	 * 6. 글 상세보기(수정) - post -> 주의 : 로그인 세션이 만료되면 오류 발생.
	 */
	@PostMapping("/board/modify")
	@ResponseBody
	public Map<String, Object> modify(HttpServletRequest request, @RequestBody Board board) {  //  @RequestParam(value = "file") @Nullable MultipartFile file,
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(board.getB_no());
		System.out.println(board.getB_tit());
		System.out.println(board.getB_cont());
		System.out.println(board.getB_pw());
		
		String page = request.getParameter("page");
		
		if(page == null) {
			page = "1";
		}
		
		if(board.getB_pw() == bs.board_pw(board.getB_no())) {
			bs.modifyService(board);
		}
		
		map.put("result", "성공");
		map.put("b_pw", bs.board_pw(board.getB_no()));

		return map;
	}
	
	/*
	 * 7. 글 상세보기(삭제) - post
	 */
	@PostMapping("/board/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, @RequestBody Board board) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String page = request.getParameter("page");
		
		if(page == null) {
			page = "1";
		}
		
		map.put("b_pw", bs.board_pw(board.getB_no()));  // 1. 순서 중요
		
		if(board.getB_pw() == bs.board_pw(board.getB_no())) {  // 2. 왜냐하면 ajax로 통신하는데 게시글이 삭제되면 b_no이 사라지기 때문.
			bs.deleteService(board.getB_no());
			map.put("result", "성공");
		}
	
		return map;
	}
	
	/*
	 * - 구글맵 ifram으로 가져와서 html에 붙이기
	 	https://www.google.co.kr/maps -> 공유하기
	 */
}
