package org.galapagos.controller;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.PageDTO;
import org.galapagos.domain.TravelVO;
import org.galapagos.service.BoardService;
import org.galapagos.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	private TravelService service; // 생성자를 통한 주입 
	
	@GetMapping("/list") // View이름: board/list (앞뒤 "/"과 확장자는 prefix, surfix가 붙여줌)
	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
			
		
		int total = service.getTotal(cri);
		
		// model에 list이름으로 실제 데이터가 있는가? => view에 전달 데이터 확인
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@GetMapping({"/get", "/modify"}) //get : 상세보기, modify: 수정 화면으로 가기
	public void get(@RequestParam("no") Long no,
					@ModelAttribute("cri") Criteria cri,
					Model model) {
		
		model.addAttribute("travel", service.get(no));
	}
	
	@PostMapping("/modify")
	public String modify(TravelVO travel, 
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		
		service.modify(travel);
		
		return "redirect:" + cri.getLink("/travel/get") + "&no=" + travel.getNo();
	}
	
	@GetMapping("/register") // 로직이 없어서 Test X
	public void register() {
	}

	@PostMapping("/register") // POST 요청의 리턴 타입은 String
	public String register(TravelVO travel, RedirectAttributes rttr) {
		service.register(travel);				
		return "redirect:/travel/list"; // 요청 url
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no,
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		service.remove(no);		
		return "redirect:" + cri.getLink("/travel/list"); // 요청 url
	}

}
