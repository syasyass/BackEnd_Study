package org.galapagos.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	@Setter(onMethod_ = { @Autowired }) // 자동으로 Setter 호출 후 Chef를 참조하게 만들어 줌
	private Chef chef;
}
