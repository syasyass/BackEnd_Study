package jdbc_ex.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import jdbc_ex.domain.UserVO;

class UserDAOTest {

	UserDAO dao = UserDAOImpl.getInstance();

	// insert,delete,update 테스트를 하면 testGetUserList등 길이를 보는 것은 에러가 나게 되므로,
	// 보통 testGetUserList등의 테스트는 막아두고 함

	@Test
	void testInsertUser() {
		UserVO user = new UserVO("test", "1234", "테스트", "Normal");
		dao.insertUser(user);

		user = dao.getUser("test");
		assertNotNull(user);
		assertEquals("test", user.getId());
	}

//	@Test
//	void testGetUserList() {
//		List<UserVO> list = dao.getUserList();
//		assertEquals(4, list.size(), "목록의 개수가 일치하지 않습니다.");
////		for (UserVO user : list) {
////			System.out.println(user);
////		}
//	}
//
//	@Test
//	void testGetUser() {
//		UserVO user = dao.getUser("admin");
//		assertNotNull(user);
//		assertEquals("admin", user.getId());
//	}
//
//	@Test
//	void testUpdateUser() {
//		UserVO user = dao.getUser("admin");
//		user.setName("최고관리자");
//
//		dao.updateUser(user);
//		user = dao.getUser("admin");
//
//		assertNotNull(user);
//		assertEquals("최고관리자", user.getName());
//	}

	@Test
	void testDeleteUser() {
		dao.deleteUser("test");

		UserVO user = dao.getUser("test");
		assertNull(user);
	}

}
