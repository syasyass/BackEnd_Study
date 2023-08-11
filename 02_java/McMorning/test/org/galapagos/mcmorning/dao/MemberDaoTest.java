package org.galapagos.mcmorning.dao;

import java.util.List;

import org.galapagos.mcmorning.vo.Member;

//Test파일은 업무에 대한 example로 사용할 수 있다. 인수인계로도 사용.
public class MemberDaoTest {

	public static void main(String[] args) {
		testRead();
		testAdd();
		testFindByUserid();
		testUpdate();
		testDelete();
	}

	static void testRead() {
		MemberDao dao = new MemberDao();

		List<Member> list = dao.getMemberList();
		for (Member m : list) {
			System.out.println(m);
		}
	}

	static void testAdd() {
		MemberDao dao = new MemberDao();

		List<Member> list = dao.getMemberList();
		int l = list.size();
		Member m2 = new Member("dooli", "1234", "둘리", "dooli@gmail.com");
		dao.add(m2);

//		if (list.size() != 5) {
//			System.out.println("추가 실패");
//		}

		// 단정문 VM 매개변수로 -ea ==> java -em MemberDaoTest
		assert list.size() == l + 1 : "추가 실패";
	}

	static void testFindByUserid() {
		MemberDao dao = new MemberDao();

		String userid = "hong";
		Member m = dao.findByUserid(userid);
		assert m != null && userid.equals(m.getUserid()) : userid + "검색 실패";

		userid = "donut";
		m = dao.findByUserid(userid);
		assert m == null : userid + "검색 실패";
	}

	static void testUpdate() {
		MemberDao dao = new MemberDao();

		Member m = new Member("na", "1234", "나지형", "na@gmail.com");
		Member m2 = dao.update(m);
		System.out.println(m2);
		assert m2 != null && m == m2 : "업데이트 실패";

		m = dao.findByUserid("hong");
		m.setEmail("hong@gmail.com");
		m2 = dao.update(m);
		System.out.println(m2);
		assert m2 != null && m == m2 : "업데이트 실패";
	}

	static void testDelete() {
		MemberDao dao = new MemberDao();

		Member m = dao.delete("na");
		assert m != null && m.getUserid().equals("na") : "업데이트 실패";

		List<Member> list = dao.getMemberList();
		for (Member m2 : list) {
			System.out.println(m2);
		}
	}
}