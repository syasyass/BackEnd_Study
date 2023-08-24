package jdbc_ex.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;

import jdbc_ex.dao.UserDAO;
import jdbc_ex.dao.UserDAOImpl;
import jdbc_ex.domain.UserVO;

public class UserUpdateCommand implements Command {
	UserDAO dao = UserDAOImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[사용자 수정]");

		String userid = Input.read("사용자 ID: ");
		UserVO user = dao.getUser(userid);

		if (user == null) {
			System.out.println("존재하지 않는 ID입니다.");
			return;
		} else {
			browse(user);
			System.out.println();

			System.out.println("수정할 내용을 입력하세요. 수정이 필요 없으면 엔터를 치세요.");
			System.out.println();

			String name = Input.read("이름", user.getName());
			String role = Input.read("역할", user.getRole());

			user.setName(name);
			user.setRole(role);
			dao.updateUser(user);

			System.out.println();
			System.out.println("수정 완료된 내용입니다.");

			browse(user);
		}
		System.out.println("==========================");

	}

	private void browse(UserVO user) {
		System.out.println("사용자 id: " + user.getId());
		System.out.println("이름: " + user.getName());
		System.out.println("비밀번호: " + user.getPassword());
		System.out.println("역할: " + user.getRole());
	}

}
