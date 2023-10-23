package org.galapagos.controller;

import org.galapagos.domain.BasketballVO;
import org.galapagos.domain.TitanicVO;
import org.galapagos.service.BasketballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basketball")
public class BasketballController {

	@Autowired
	BasketballService service;
	
	@GetMapping("/predict")
	public void getPredict(BasketballVO vo) {
		
	}
	
	@PostMapping("/predict")
	public void postPredict(BasketballVO vo, Model model) {
		String result = service.predict(vo);
		model.addAttribute("result", result);
	}
	
}
