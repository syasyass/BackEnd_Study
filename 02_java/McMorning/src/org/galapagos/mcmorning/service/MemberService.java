package org.galapagos.mcmorning.service;

import java.util.List;

import org.galapagos.mcmorning.cli.Input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.exception.UserIdCountOverException;
import org.galapagos.mcmorning.vo.Member;

public class MemberService {

	MemberDao dao;

	public MemberService(MemberDao dao) {
		this.dao = dao;
	}

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

	public Member login() {
		System.out.println("[로그인]");
		String userid = Input.read("사용자 ID : ");
		String password = Input.read("비밀번호 : ");

		// 로그인 검사!
		Member m = dao.findByUserid(userid);
		if (m != null) { // 사용자 ID가 존재하는지 검사
			if (password.equals(m.getPassword())) {// 비밀번호가 일치하는지 검사
				// 로그인 성공
				return m;
			}
		}
		// 로그인 실패
		return null;
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

	public void searchByName() {
		System.out.println("[이름으로 찾기]");
		String keyword = Input.read("검색어 : ");

		List<Member> list = dao.searchByName(keyword);

		System.out.printf("검색 결과: %d건\n", list.size());

		for (Member m : list) {
			System.out.println(m);
		}
	}
}
