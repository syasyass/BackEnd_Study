package org.galapagos.service;

import org.galapagos.domain.MemberVO;
import org.springframework.stereotype.Service;

public interface MemberService {
	public MemberVO get(String username);
	
	public void register(MemberVO member);
}
