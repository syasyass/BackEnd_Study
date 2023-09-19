package org.galapagos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Configuration		// 설정이라는 뜻
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/security/all").permitAll()
			.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");
		
		http.formLogin()	// 로그인 설정 시작
			.loginPage("/security/login")	// 로그인 페이지 URL. GET요청. 직접 만들기
			.loginProcessingUrl("/security/login")	//로그인 POST URL. Security가 해 줌. Form action에 제시할 URL
			.defaultSuccessUrl("/")		// 로그인 성공시 이동할 페이지. 디폴트 home 페이지
			.failureUrl("/security/login?error=true");	//el에서 접근 : param.error
		
		http.logout()
			.logoutUrl("/security/logout")		// 로그아웃 호출 url. post일 경우
			.invalidateHttpSession(true)		// 세션invalidate
			.deleteCookies("remember-me", "JSESSION-ID")	// 삭제할 쿠키 목록
			.logoutSuccessUrl("/security/logout");	//로그아웃 이후 이동할 페이지. get
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		log.info("configure......................");
		
		auth.inMemoryAuthentication()	// 메모리에서 사용자 정보 설정
			.withUser("admin")			// username, 사용자id
			.password("$2a$10$YpK24Ik1JCkZUCSMM5rEI.1lRLVdiamjr.Fp0SIqD7b3KFVr7yqx6")
			.roles("ADMIN");			// 역할 설정. 앞에 ROLE_ 안 붙여도 자동으로 붙음
		
		auth.inMemoryAuthentication()
			.withUser("member")
//			.password("{noop}1234")	// 비밀번호, {noop}는 암호화 없음 의미 (no operation 약자)
			.password("$2a$10$YpK24Ik1JCkZUCSMM5rEI.1lRLVdiamjr.Fp0SIqD7b3KFVr7yqx6")
			.roles("MEMBER");
	}

}
