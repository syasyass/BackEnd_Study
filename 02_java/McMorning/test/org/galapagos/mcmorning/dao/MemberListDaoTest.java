package org.galapagos.mcmorning.dao;

import org.galapagos.mcmorning.vo.Member;

public class MemberListDaoTest {
	public static void main(String[] args) {
		// testSave();
		testLoad();
	}

	public static void testSave() {
		MemberDao dao = new MemberListDao();
		try {
			dao.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testLoad() {
		MemberDao dao = new MemberListDao();
		try {
			dao.load();
			for (Member m : dao.getMemberList()) {
				System.out.println(m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
