package org.galapagos.mcmorning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.galapagos.mcmorning.util.Serializer;
import org.galapagos.mcmorning.vo.Member;

public class MemberMapDao implements MemberDao {

	static final String FILE_PATH = "E:/Temp/McMorning_member_list.dat";

	private Map<String, Member> memberMap;

	public MemberMapDao() {
//		memberList = new ArrayList<Member>();
//		memberList.add(new Member("hong", "1234", "홍길동", "hong@naver.com"));
//		memberList.add(new Member("go", "1234", "고미향", "go@naver.com"));
//		memberList.add(new Member("kim", "1234", "김철민", "kim@naver.com"));
//		memberList.add(new Member("na", "1234", "나지형", "na@naver.com"));

		memberMap = new HashMap<String, Member>();
		memberMap.put("hong", new Member("hong", "1234", "홍길동", "hong@naver.com"));
		memberMap.put("go", new Member("go", "1234", "고미향", "go@naver.com"));
		memberMap.put("kim", new Member("kim", "1234", "김철민", "kim@naver.com"));
		memberMap.put("na", new Member("na", "1234", "나지형", "na@naver.com"));
	}

	@Override
	public List<Member> getMemberList() {
		return new ArrayList<>(memberMap.values());
	}

	@Override
	public void add(Member m) {
		memberMap.put(m.getUserid(), m);
	}

	@Override
	public Member findByUserid(String userid) {
		return memberMap.get(userid);
	}

	@Override
	public Member update(Member m) {
		return memberMap.put(m.getUserid(), m);
	}

	@Override
	public Member delete(String userid) {
		return memberMap.remove(userid);
	}

	@Override
	public List<Member> searchByName(String name) {
		List<Member> list = new ArrayList<>();

		for (Member m : memberMap.values()) {
			if (m.getName().contains(name)) { // contains() 또는 substring()
				list.add(m);
			}
		}
		return list;
	}

	@Override
	public void save() throws Exception {
		// memberList 직렬화 하면 되고,
		Serializer.save(FILE_PATH, memberMap);
	}

	@Override
	public void load() throws Exception {
		// memberList 역직렬화 하면 됨
		memberMap = (Map<String, Member>) Serializer.load(FILE_PATH);
	}
}
