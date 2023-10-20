package org.galapagos.service;

import java.io.IOException;

import org.galapagos.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
	public MemberVO get(String username);
	
	public void register(MemberVO member, MultipartFile avatar) throws IOException;

	public void modify(MemberVO member, MultipartFile avatar) throws IOException;
}
