package jdbc_ex;

import org.galapagos.common.cli.ui.Application;
import org.galapagos.common.cli.ui.Menu;
import org.galapagos.common.cli.ui.MenuItem;

import jdbc_ex.command.UserAddCommand;
import jdbc_ex.command.UserDeleteCommand;
import jdbc_ex.command.UserDetailCommand;
import jdbc_ex.command.UserListCommand;
import jdbc_ex.command.UserUpdateCommand;
import jdbc_ex.common.JDBCUtil;

public class UserManagementApp extends Application {

	public static void main(String[] args) {
		Application app = new UserManagementApp(); // 리스코프 치환
		app.run();
	}

	@Override
	public void createMenu(Menu menu) {
		super.createMenu(menu);

		menu.add(new MenuItem("목록", new UserListCommand()));
		menu.add(new MenuItem("상세보기", new UserDetailCommand()));
		menu.add(new MenuItem("추가", new UserAddCommand()));
		menu.add(new MenuItem("수정", new UserUpdateCommand()));
		menu.add(new MenuItem("삭제", new UserDeleteCommand()));

	}

	@Override
	public void cleanup() {
		super.cleanup();
//		System.out.println("DB Connection Close");
		JDBCUtil.close();
	}

}
