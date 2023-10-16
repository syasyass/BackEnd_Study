package org.galapagos.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.galapagos.domain.Criteria;
import org.galapagos.domain.PageDTO;
import org.galapagos.domain.TravelVO;
import org.galapagos.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	private TravelService service; // 생성자를 통한 주입 
	
	@ModelAttribute("searchTypes")
	public Map<String, String> searchTypes() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("", "-- 검색대상선택 --");
		map.put("R", "권역");
		map.put("T", "제목");
		map.put("D", "내용");
		map.put("TD", "제목+내용");
		map.put("TR", "권역+제목");
		map.put("TRD", "권역+제목+내용");
		
		return map;		
	}
	
	@GetMapping("/list") // View이름: board/list (앞뒤 "/"과 확장자는 prefix, surfix가 붙여줌)
	public void list(@ModelAttribute("cri") Criteria cri, 
					Principal principal, Model model) {
			
		
		int total = service.getTotal(cri);
		
		// model에 list이름으로 실제 데이터가 있는가? => view에 전달 데이터 확인
		model.addAttribute("list", service.getList(cri, principal));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@GetMapping({"/get", "/modify"}) //get : 상세보기, modify: 수정 화면으로 가기
	public void get(@RequestParam("no") Long no,
					@ModelAttribute("cri") Criteria cri,
					Principal principal,
					Model model) {
		
		model.addAttribute("travel", service.get(no, principal));
	}
	
	@PostMapping("/modify")
	public String modify(
			@Valid @ModelAttribute("travel") TravelVO travel,
			Errors errors,
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		
		if(errors.hasErrors()) {
			return "travel/modify";
		}
		
		service.modify(travel);
		
		return "redirect:" + cri.getLink("/travel/get") + "&no=" + travel.getNo();
	}
	
	@GetMapping("/register") // 로직이 없어서 Test X
	public void register(@ModelAttribute("travel") TravelVO travel) {
	}

	@PostMapping("/register") // POST 요청의 리턴 타입은 String
	public String register(@Valid @ModelAttribute("travel") TravelVO travel,
							Errors errors,
							RedirectAttributes rttr) {
		
		if(errors.hasErrors()) {		// 유효성 검사 실패하면
			return "travel/register";	// view의 이름 리턴 - forwarding
		}
		
		service.register(travel);		// 유효성 검사 성공하면 DB에 저장하고,		
		return "redirect:/travel/list"; // 요청 url redirect
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no,
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		service.remove(no);		
		return "redirect:/travel/list" + cri.getLink(); // 요청 url
	}

}
