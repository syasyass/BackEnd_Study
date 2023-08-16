package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.dao.MemberListDao;
import org.galapagos.mcmorning.dao.MemberMapDao;
import org.galapagos.mcmorning.exception.UserIdCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberServiceTest {

	public static void main(String[] args) {
		// testInputMember();
		// testlogin();
		testSearchByName();
	}

	static void testInputMember() {
		MemberService service = new MemberService(new MemberMapDao());

		Member m;
		try {
			m = service.inputMember();
			System.out.println(m);

		} catch (UserIdCountOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	static void testlogin() {
		MemberService service = new MemberService(new MemberMapDao());
		Member m = service.login();

		// 로그인 성공시 'userid님 환영합니다.' 출력
		// 로그인 실패시 에러 메시지 출력
		if (m != null) { // 로그인 성공
			System.out.println(m.getUserid() + "님 환영합니다.");
			System.out.println(m);
		} else {// 로그인 실패
			System.out.println("사용자 ID 또는 비밀번호가 올바르지 않습니다.");
		}

	}

	static void testSearchByName() {
		MemberService service = new MemberService(new MemberListDao());
		service.searchByName();
	}
}