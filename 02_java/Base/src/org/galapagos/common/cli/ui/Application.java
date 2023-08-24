package org.galapagos.common.cli.ui;

import org.galapagos.common.cli.command.ExitCommand;

public abstract class Application { // 추상클래스로 만들어서 상속받지 않는 한은 선언할 수 없게 함

	private Menu menu;

	public void createMenu(Menu menu) {
	}

	public void init() {
		menu = new Menu();
		createMenu(menu);
		menu.add(new MenuItem("종료", new ExitCommand(this)));
	}

	public void cleanup() {
	}

	public void run() {
		init();
		while (true) {
			menu.print();
			MenuItem item = menu.select();
			if (item != null)
				item.execute();
			System.out.println("\n");
		}
	}
}
