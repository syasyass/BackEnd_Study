package org.galapagos.config;

import javax.sql.DataSource;

import org.galapagos.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		
		return repo;
	}
		
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		http.addFilterBefore(filter, CsrfFilter.class);
		
		http.csrf().ignoringAntMatchers("/api/**");
		
		http.authorizeRequests()
			.antMatchers("/security/profile").authenticated()
			.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

		http.formLogin()
			.loginPage("/security/login?error=login_required")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/")
			.failureUrl("/security/login?error=true");
		
		http.logout()
			.logoutUrl("/security/logout")
			.invalidateHttpSession(true)
			.deleteCookies("remember-me", "JSESSION-ID")
			.logoutSuccessUrl("/");
		
		http.rememberMe()
			.key("Galapagos")
			.tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(7*24*60*60);		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		log.info("configure......................");		 

		auth.userDetailsService(customUserService())
			.passwordEncoder(passwordEncoder());

	}

}
