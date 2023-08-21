package org.galapagos.common.cli.ui;

import org.galapagos.command.ListCommand;

public class MenuItemTest {

	public static void main(String[] args) {
		MenuItem listItem = new MenuItem("목록", new ListCommand());

		System.out.println(listItem.getTitle());
		listItem.execute();
	}

}
