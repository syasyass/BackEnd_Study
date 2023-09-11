package org.galapagos.controller;

import org.galapagos.config.RootConfig;
import org.galapagos.config.ServletConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //@WebAppConfiguration에 스프링 MVC 구조가 있음
@ContextConfiguration(classes= {RootConfig.class, ServletConfig.class})
@Log4j
public class BoardControllerTest {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc; //스프링 MVC의 목업(겉모양/모양새) Mock 객체
	
	@Before //JUnit // 각 테스트 메소드 호출 이전에 이 메소드부터 호출해야 된다는 뜻
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test
	public void testList() throws Exception {
		log.info( //MVC 구조를 통해 호출. (이제까지는 직접 호출했으나, 여기서는 MVC 구조를 통해 호출함)
				//controller가 호출됨 + 요청 구성(get(("/board/list")). Controller의 list 구조로 맵핑
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
					.andReturn()
					.getModelAndView() // 모델 객체, View 이름
					.getModelMap()
				);
	}
	
//	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(
					MockMvcRequestBuilders.post("/board/register")
						.param("title", "테스트 새글 제목")
						.param("content", "테스트 새글 내용")
						.param("writer", "user00")) // POST 요청 BODY 구성
					.andReturn().getModelAndView().getViewName();

				log.info(resultPage);
	}
	
//	@Test
	public void testGet() throws Exception {
		log.info(
				mockMvc
					.perform(MockMvcRequestBuilders.get("/board/get").param("bno","7")) // board/get?bno=4 요청
					.andReturn()
					.getModelAndView() // 모델 객체, View 이름
					.getModelMap() // 모델 데이터 확인. "board" 값?
				);
	}
	
	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(
					MockMvcRequestBuilders.post("/board/modify")
						.param("bno", "10")	
						.param("title", "수정된 테스트 새글 제목")
						.param("content", "수정된 테스트 새글 내용")
						.param("writer", "user00")) // POST 요청 BODY 구성
					.andReturn().getModelAndView().getViewName();

				log.info(resultPage);
	}
	
//	@Test
	public void testRemove() throws Exception {
		//삭제 전 데이터베이스 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(
					MockMvcRequestBuilders.post("/board/remove")
						.param("bno", "10")	) // POST 요청 BODY 구성
					.andReturn().getModelAndView().getViewName();

				log.info(resultPage);
	}


}
