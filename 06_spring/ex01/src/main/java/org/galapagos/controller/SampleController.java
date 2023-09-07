package org.galapagos.controller;

import java.util.ArrayList;
import java.util.Date;

import org.galapagos.domain.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller //Bean 등록
@RequestMapping("/sample/") //요청 url 중에 "/sample/"로 시작하는 요청은 이 컨트롤러로 처리한다는 의미
@Log4j // log static 멤버가 이 클래스에 추가됨. INFO: 클래스명 -메시지 형태로 로그 출력
public class SampleController {
	
	@RequestMapping("") // basic 메소드에만 적용. /sample/"" --> 결국 /sample/ --> Handler Mapping에 등록
	public void basic( ) {
		log.info("basic...............");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST}) //java 스타일
	public void basicGet() {
		log.info("basic get................");
		//리턴 값이 없을 때, view의 이름은 url의 마지막 요소로 결정이 됨
		//return "basic";
	}
	
	@GetMapping("/basicOnlyGet") // 앞으로는 이렇게 어노테이션으로 요청을 처리함 
	public void basicGet2() {
		log.info("basic get only get................");
	}
	
	//IoC : 제어의 역전 : 내가 Spring에 부탁하고 Spring이 알아서 해줌
	@GetMapping("/ex01") // 앞으로는 이렇게 어노테이션으로 요청을 처리함 
	public String ex01(SampleDTO dto) { //일종의 의존성 주입(DI : Dependency Injection)
		log.info("" + dto);
		
		return "ex01"; //View의 이름으로 간주
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, //DTO와 혼용 가능
						@RequestParam("age") int age) { //DTO를 안 쓰고 받기. request.getParameter를 해주는 것
		log.info("name: " + name);
		log.info("age: " + age);
		
		return "ex02"; //View의 이름으로 간주
	}
	
	@GetMapping("/ex02List")
	public String ex02List( @RequestParam("ids") ArrayList<String> ids) { //List말고 String[]도 가능
		log.info("ids: " + ids);
		
		return "ex02List"; //View의 이름으로 간주
	}
	
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute("sample") SampleDTO dto,
						@ModelAttribute("page")
						@RequestParam("page") int page,
						Model model) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		
		model.addAttribute("now", new Date());
		
		return "ex04";
	}
}
