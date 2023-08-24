package jdbc_ex.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;

import jdbc_ex.dao.UserDAO;
import jdbc_ex.dao.UserDAOImpl;
import jdbc_ex.domain.UserVO;

public class UserDetailCommand implements Command {

	UserDAO dao = UserDAOImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[User 상세보기]");

		String userid = Input.read("사용자 ID: ");
		UserVO user = dao.getUser(userid);

		if (user == null) {
			System.out.println("존재하지 않는 ID입니다.");
			return;
		} else {
			System.out.println("이름: " + user.getName());
			System.out.println("비밀번호: " + user.getPassword());
			System.out.println("역할: " + user.getRole());
		}
		System.out.println("==========================");
	}

}
