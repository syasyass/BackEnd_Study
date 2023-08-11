package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.cli.Input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.exception.UserIdCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberService {

	MemberDao dao = new MemberDao();

	public void singUp() {
		// Member 정보 입력
		// id 중복 체크
		// Member 인스턴스 생성
		// 리스트 넣기(Dao)

		Member member;
		try {
			member = inputMember();
			dao.add(member);

		} catch (UserIdCountOverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public Member inputMember() throws UserIdCountOverException {

		String userid = inputUserid();
		String password = Input.read("비밀번호 : ");
		String name = Input.read("이름 : ");
		String email = Input.read("email : ");

		Member m = new Member(userid, password, name, email);
		return m;
	}

	public String inputUserid() throws UserIdCountOverException {
		String userid = "";

		for (int i = 0; i < 3; i++) {
			userid = Input.read("사용자 ID : ");
			Member m = dao.findByUserid(userid);
			if (m != null) { // 중복이면
				System.out.println(userid + "는 중복된 id입니다. 다시 입력해 주세요.");
			} else {
				return userid;
			}
		}
		throw new UserIdCountOverException();
	}

}
