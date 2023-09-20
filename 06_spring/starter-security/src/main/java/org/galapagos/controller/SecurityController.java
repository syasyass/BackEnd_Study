package org.galapagos.controller;

import javax.validation.Valid;

import org.galapagos.domain.MemberVO;
import org.galapagos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/security")
@Controller
public class SecurityController {
	
	@Autowired //Autowired로 주입
	private MemberService service; // 생성자를 통한 주입 
	
	@GetMapping("/login")
	public void login() {
		log.info("login page");
	}
	
	@GetMapping("/signup")
	public void signup(@ModelAttribute("member") MemberVO member) {
		
	}
	
	@PostMapping("/signup")
	public String signup(
			@Valid @ModelAttribute("member") MemberVO member,
			Errors errors) {
		
		// 1. 비밀번호, 비밀번호 확인 일치 여부
		if(!member.getPassword().equals(member.getPassword2())) {
			// 에러 추가
			errors.rejectValue("password2", "비밀번호 불일치", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		// 2. 아이디 중복
		if(!errors.hasFieldErrors("username")) { // 특정 Field에 에러가 있는가. username 유효성 통과한 경우
			// DB에서 username을 검사
			if(service.get(member.getUsername()) != null) { // 중복임
				errors.rejectValue("username", "ID 중복", "이미 사용 중인 ID입니다.");
			}			
		}
		
		if(errors.hasFieldErrors()) {
			return "security/signup";
		}
		// DB 저장
		
		// 성공했을 때
		return "redirect:/";
	}	
}
