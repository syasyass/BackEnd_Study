package org.galapagos.controller;

import org.galapagos.domain.HeartVO;
import org.galapagos.mapper.TravelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + 모든 메소드에 @ResponseBody 응답 인코딩: application/json
@RequestMapping("/api/travel/heart")
public class TravelHeartController {
	@Autowired
	TravelMapper mapper;
	
	@PostMapping("/add")
	public HeartVO addHeart(@RequestBody HeartVO heart) {
		mapper.addHeart(heart);
		return heart;
	}
	
	@DeleteMapping("/delete")
	public String deleteHeart(HeartVO heart) {
		mapper.deleteHeart(heart);
		return "OK";
	}

}
