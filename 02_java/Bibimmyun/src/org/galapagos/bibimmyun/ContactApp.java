package org.galapagos.bibimmyun;

import org.galapagos.bibimmyun.command.ListCommand;
import org.galapagos.bibimmyun.command.SearchCommand;
import org.galapagos.common.cli.ui.Application;
import org.galapagos.common.cli.ui.Menu;
import org.galapagos.common.cli.ui.MenuItem;

public class ContactApp extends Application {

	@Override
	public void createMenu(Menu menu) {
		super.createMenu(menu);

		menu.add(new MenuItem("목록", new ListCommand()));
		menu.add(new MenuItem("검색", new SearchCommand()));
		menu.add(new MenuItem("추가", null));
	}

	public static void main(String[] args) {
		ContactApp app = new ContactApp();
		app.run();
	}

}
