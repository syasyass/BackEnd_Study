package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.exception.UserIdCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberServiceTest {

	public static void main(String[] args) {
		testInputMember();
	}

	static void testInputMember() {
		MemberService service = new MemberService();

		Member m;
		try {
			m = service.inputMember();
			System.out.println(m);

		} catch (UserIdCountOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}