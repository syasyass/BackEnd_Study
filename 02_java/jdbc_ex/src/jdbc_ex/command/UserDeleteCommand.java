package jdbc_ex.command;

import org.galapagos.common.cli.Input;
import org.galapagos.common.cli.command.Command;

import jdbc_ex.dao.UserDAO;
import jdbc_ex.dao.UserDAOImpl;
import jdbc_ex.domain.UserVO;

public class UserDeleteCommand implements Command {
	UserDAO dao = UserDAOImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[사용자 삭제]");

		String userid = Input.read("사용자 ID: ");
		UserVO user = dao.getUser(userid);

		if (user == null) {
			System.out.println("존재하지 않는 ID입니다.");
			return;
		} else {
			// 정말 삭제할까요?
			boolean answer = Input.confirm("정말로 삭제하시겠습니까?", true);
			// 대문자 Y는 그냥 엔터치면 Y로 인정된다는 뜻의 관례.

			if (answer) {
				System.out.println(userid + " 사용자를 삭제합니다.");
				dao.deleteUser(user.getId());

			} else {
				System.out.println("삭제를 취소합니다.");
				return;
			}
		}
		System.out.println("==========================");
	}
}
