package org.galapagos.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.galapagos.domain.MemberVO;
import org.galapagos.service.MemberService;
import org.galapagos.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnails;

@Log4j
@RequestMapping("/security")
@Controller
public class SecurityController {
	
	@Autowired
	private MemberService service;

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
			Errors errors,
			MultipartFile avatar) throws IOException {
		
		//1. 비밀번호, 비밀번호 확인 일치 여부
		if(!member.getPassword().equals(member.getPassword2())) {
			//에러 추가
			errors.rejectValue("password2", "비밀번호 불일치", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		// 2. 아이디 중복
		if(!errors.hasFieldErrors("username")) { // 특정 필드에 에러가 있는가.
			//DB에서 username 검사
			if(service.get(member.getUsername()) != null) { //중복이라면
				errors.rejectValue("username", "ID 중복", "이미 사용 중인 ID입니다.");
			}
		}
		
		if(errors.hasFieldErrors()) {
			return "security/signup";
		}
		//DB 저장
		service.register(member, avatar);
		
		//성공했을 때
		return "redirect:/";
	}
	
	@GetMapping("/avatar/{size}/{username}")
	@ResponseBody
	public void avatar(@PathVariable("size") String size,
						@PathVariable("username") String username,
						HttpServletResponse response) throws IOException {
		File src = new File(MemberServiceImpl.AVATAR_UPLOAD_DIR, username + ".png");
		
		if(!src.exists()) { //파일이 존재하지 않으면
			src = new File(MemberServiceImpl.AVATAR_UPLOAD_DIR, "unknown.png");
		}
		
		response.setHeader("Content-Type", "image/png");
		
		if(size.equals("sm")) {
			Thumbnails.of(src)
					.size(25,25)
					.toOutputStream(response.getOutputStream());
		} else {
			Thumbnails.of(src)
			.size(50, 50)
			.toOutputStream(response.getOutputStream());
		}
	}
	
	@GetMapping("/profile")
	public void profile(@ModelAttribute("member") MemberVO member) {
	}
	
	@PostMapping("/profile")
	public String profile(
				@ModelAttribute("member") MemberVO member,
				Errors errors,
				MultipartFile avatar) throws IOException {
		
		//1. 비밀번호, 비밀번호 확인 일치 여부
		if(!member.getPassword().equals(member.getPassword2())) {
			//에러 추가
			errors.rejectValue("password2", "비밀번호 불일치", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		if(errors.hasFieldErrors()) {
			return "security/profile";
		}
		//DB 저장
		service.modify(member, avatar);
		
		//성공했을 때
		return "redirect:/";
	}
	
}
