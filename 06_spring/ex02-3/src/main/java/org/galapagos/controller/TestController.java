package org.galapagos.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.galapagos.domain.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test")
@Log4j
public class TestController {
	
//	public int[] years = { 2000, 2001, 2002, 2003 };
//	private String[] hobbies = { "야구", "축구", "배구" };
//	private String[] genders = {"남자", "여자"};
	
//	1950년부터 2023년도까지 구성하기	
	@ModelAttribute("years") // 자동으로 메서드 호출됨, 리턴 값이 모델에 추가됨
	public List<Integer> years() { // Url과 상관없이 view를 호출할 때 무조건 호출됨
		List<Integer> years = new ArrayList<Integer>();		
		for(int i = 1950; i <= 2023; i++) {
			years.add(i);
		}
		return years;
	}
	
	@ModelAttribute("roles")
	public Map<String, String> getRoles() {
		Map<String, String> map = new LinkedHashMap<>();
		// put 한 순서로 순회
		map.put("ROLE_ADMIN", "Admin"); //option value, title 순서
		map.put("ROLE_MANAGER", "관리자");
		map.put("ROLE_MEMBER", "일반회원");
		
		return map;
	}
	
	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies() {
		Map<String, String> hobbies = new LinkedHashMap<>();
		// put 한 순서로 순회
		hobbies.put("BASEBALL", "야구"); //option value, title 순서
		hobbies.put("FOOTBALL", "축구");
		hobbies.put("VOLLYBALL", "배구");
		
		return hobbies;
	}
	
	@ModelAttribute("genders")
	public String[] genders() {
		return new String[] {"남자","여자"};
	}
	
	@GetMapping("/join")
	public void join(
			@ModelAttribute("member") MemberVO member,
			Model model) {
//		model.addAttribute("years", years);
//		model.addAttribute("hobbies", hobbies);
	}
	
	@PostMapping("/join")
	public String Join(@Valid @ModelAttribute("member") MemberVO member,
						Errors errors, Model model) {
		
		if(!member.getPassword().equals(member.getPassword2())) {
			errors.rejectValue("password2", "비밀번호 확인 에러", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		log.info("POST: " + member);
//		model.addAttribute("years", years);
//		model.addAttribute("hobbies", hobbies);
		
		if(errors.hasErrors()) {
		return "test/join"; 	// 에러가 있다고 가정. forwarding --> form을 다시 입력하도록 함(이전 값으로 복원)
		}
		
		// DB 처리 작업
		return "redirect:/"; // 에러가 없으면 redirect
	}
}
