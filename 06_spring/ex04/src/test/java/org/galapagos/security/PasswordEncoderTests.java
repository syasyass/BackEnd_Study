package org.galapagos.security;

import org.galapagos.config.RootConfig;
import org.galapagos.config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RootConfig.class,
		SecurityConfig.class
})
@Log4j
public class PasswordEncoderTests {
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Test
	public void testEncode() {
		String str = "1234";
		
		String enStr = pwEncoder.encode(str);	// 회원 가입할 때 직접 구현
		log.info("password: " + enStr);
		log.info(enStr.length());
		
		String enStr2 = pwEncoder.encode(str);
		log.info("password: " + enStr2);
		log.info(enStr2.length());
		
		log.info("match: " + pwEncoder.matches(str, enStr));
		log.info("match: " + pwEncoder.matches(str, enStr2));
	}
}
