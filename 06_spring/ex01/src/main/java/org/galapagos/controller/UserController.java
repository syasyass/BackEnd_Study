package org.galapagos.controller;

import org.galapagos.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/")
@Log4j
public class UserController {

	@GetMapping("/join")
	public String joinGet() {
		return "user/join"; // foward 처리
	}
	
	@PostMapping("/join")
	public String joinPost(UserDTO user) {
		//DB에 INSERT 작업을 함
		log.info(user);
		
		// "redirect:이동할 url" 즉, 이제 view의 이름이 아님
		return "redirect:/user/join_result";
	}
	
	@GetMapping("/join_result")
	public String joinResult(UserDTO user) {
		log.info(user);
		return "user/join_result";
	}
	
}
