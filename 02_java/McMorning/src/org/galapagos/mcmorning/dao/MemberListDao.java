package org.galapagos.mcmorning.dao;

import java.util.ArrayList;
import java.util.List;

import org.galapagos.mcmorning.vo.Member;

import lombok.Getter;

//Member에 대한 CRUD
public class MemberListDao implements MemberDao {
	@Getter
	private List<Member> memberList;

	public MemberListDao() {
		memberList = new ArrayList<Member>();
		memberList.add(new Member("hong", "1234", "홍길동", "hong@naver.com"));
		memberList.add(new Member("go", "1234", "고미향", "go@naver.com"));
		memberList.add(new Member("kim", "1234", "김철민", "kim@naver.com"));
		memberList.add(new Member("na", "1234", "나지형", "na@naver.com"));
	}

	@Override
	public void add(Member m) {
		memberList.add(m);
	}

	// userid로 찾기
	@Override
	public Member findByUserid(String userid) {

//		for (Member m : memberList) {
//			if (userid.equals(m.getUserid())) {
//				return m;
//			}
//		}

		int ix = indexOf(userid);

		return ix != -1 ? memberList.get(ix) : null;
	}

	@Override
	public Member update(Member m) {
//		for (int i = 0; i < memberList.size(); i++) {
//			if (m.getUserid().equals(memberList.get(i).getUserid())) {
//				memberList.set(i, m);
//				return m;
//			}
//		}
		int ix = indexOf(m.getUserid());
		if (ix != -1) {
			return m;
		}
		return null;
	}

	private int indexOf(String userid) {
		for (int i = 0; i < memberList.size(); i++) {
			if (userid.equals(memberList.get(i).getUserid())) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Member delete(String userid) {
		int ix = indexOf(userid);

//		if (ix != -1) {
//			return memberList.remove(ix);
//		}
//
//		return null;

		return ix != -1 ? memberList.remove(ix) : null;
	}

	@Override
	public List<Member> searchByName(String name) {
		List<Member> list = new ArrayList<>();

		for (Member m : memberList) {
			if (m.getName().contains(name)) { // contains() 또는 substring()
				list.add(m);
			}
		}
		return list;
	}

}