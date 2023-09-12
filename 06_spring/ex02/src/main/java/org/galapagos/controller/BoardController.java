package org.galapagos.controller;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
//	@Autowired //Autowired로 주입
	private BoardService service; // 생성자를 통한 주입 
	
	@GetMapping("/list") // View이름: board/list (앞뒤 "/"과 확장자는 prefix, surfix가 붙여줌)
	public void list(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri)); // model에 list이름으로 실제 데이터가 있는가? => view에 전달 데이터 확인
	}
	
	@GetMapping("/register") // 로직이 없어서 Test X
	public void register() {
		log.info("register");
	}

	@PostMapping("/register") // POST 요청의 리턴 타입은 String
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list"; // 요청 url
	}
	
	@GetMapping({"/get", "/modify"}) //get : 상세보기, modify: 수정 화면으로 가기
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		
		if(service.modify(board)) {
		// Flash --> 1회성으로 정보를 전달함
		rttr.addFlashAttribute("result", "success");
		rttr.addAttribute("bno", board.getBno());
		rttr.addAttribute("name", "hong");
		}
		return "redirect:/board/get"; // 요청 url
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		
		if(service.remove(bno)) {		
		rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list"; // 요청 url
	}
	
}
