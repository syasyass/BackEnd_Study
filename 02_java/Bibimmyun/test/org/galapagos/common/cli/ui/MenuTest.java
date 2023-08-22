package org.galapagos.common.cli.ui;

import org.galapagos.bibimmyun.command.ExitCommand;
import org.galapagos.bibimmyun.command.ListCommand;
import org.galapagos.bibimmyun.command.SearchCommand;

public class MenuTest {

	public static void main(String[] args) {
		Menu menu = new Menu();

		menu.add(new MenuItem("목록", new ListCommand()));
		menu.add(new MenuItem("검색", new SearchCommand()));
		menu.add(new MenuItem("추가", null));
		menu.add(new MenuItem("종료", new ExitCommand()));

		while (true) {
			menu.print();
			MenuItem item = menu.select();
			if (item != null) {
				item.execute();
			}
		}
	}

}
