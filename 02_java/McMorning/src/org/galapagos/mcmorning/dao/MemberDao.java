package org.galapagos.mcmorning.dao;

import java.util.List;

import org.galapagos.mcmorning.vo.Member;

public interface MemberDao {

	List<Member> getMemberList();

	void add(Member m);

	// userid로 찾기
	Member findByUserid(String userid);

	// 수정
	Member update(Member m);

	// 삭제
	Member delete(String userid);

	List<Member> searchByName(String name); // name: 홍길동, 길동, 길, 동... 여러 개일 수 있음

	// 파일 저장
	void save() throws Exception;

	// 파일 불러오기
	void load() throws Exception;

}