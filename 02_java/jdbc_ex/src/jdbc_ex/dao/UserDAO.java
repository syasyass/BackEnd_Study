package jdbc_ex.dao;

import java.util.List;

import jdbc_ex.domain.UserVO;

public interface UserDAO {

	// 회원 등록
	void insertUser(UserVO user);

	// 회원 목록 조회
	List<UserVO> getUserList();

	// 회원 정보 조회
	UserVO getUser(String id);

	// 회원 수정
	void updateUser(UserVO user);

	// USERS 테이블 관련 CRUD 메소드
	// 회원 삭제
	void deleteUser(String id);

}