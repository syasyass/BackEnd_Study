package org.galapagos.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Data;

@Data
public class MemberVO {
	private String username;
	private String password;
	private String email;
	private Date regDate;
	private Date updateDate;
	
	private List<AuthVO> authList;
	
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities =
			new ArrayList<>();
		for(AuthVO auth: authList) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuth()));
		}
		return authorities;
	}
}
