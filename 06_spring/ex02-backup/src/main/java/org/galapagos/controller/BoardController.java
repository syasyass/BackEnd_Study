package org.galapagos.controller;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.PageDTO;
import org.galapagos.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri)); // model에 list이름으로 실제 데이터가 있는가? => view에 전달 데이터 확인
		
		int total = service.getTotal(cri);
		log.info("total: " + total);
		
		//model.addAttribute("pageMaker", new PageDTO(cri, 274)); // 임의로 273 요청
		model.addAttribute("pageMaker", new PageDTO(cri, total));
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
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, 
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		
		log.info("modify: " + board);
		
		// Criteria 값을 넘겨주는 getLink() (UriComponentsBuilder)를 사용하게 되면서 필요 없어짐
//		if(service.modify(board)) {
		// Flash --> 1회성으로 정보를 전달함
//		rttr.addFlashAttribute("result", "success");
//		rttr.addAttribute("bno", board.getBno());
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//		}
//		return "redirect:/board/get"; // 요청 url
		
		// 위의 코드를 Criteria의 getLinkWithBno를 활용해 값 넘기기
		service.modify(board);
		
		return "redirect:" + cri.getLinkWithBno("/board/get", board.getBno());
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		log.info("remove..." + bno);
		
		// Criteria 값을 넘겨주는 getLink() (UriComponentsBuilder)를 사용하게 되면서 필요 없어짐
//		if(service.remove(bno)) {		
//		rttr.addFlashAttribute("result", "success");
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//		}
//		
		service.remove(bno);
		
		return "redirect:" + cri.getLink("/board/list"); // 요청 url
	}
	
}
