package jdbc_ex;

import java.util.List;

import jdbc_ex.common.JDBCUtil;
import jdbc_ex.dao.UserDAO;
import jdbc_ex.domain.UserVO;

public class UserDaoTes2 {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO user = new UserVO("ssamz3", "ssamz123", "쌤즈", "ADMIN");

		System.out.println("insertUser ==============");
		dao.insertUser(user);

		System.out.println("getUsesrList ============");
		List<UserVO> list = dao.getUserList();
		for (UserVO vo : list) {
			System.out.println(vo);
		}

		System.out.println("updateUser ==============");
		user.setName("쌤즈3");
		dao.updateUser(user);

		System.out.println("getUsesrList ============");
		UserVO user2 = dao.getUser("ssamz3");
		System.out.println(user2);

		System.out.println("deleteUser ==============");
		dao.deleteUser("ssamz3");

		JDBCUtil.close();
	}

}
