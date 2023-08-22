package org.galapagos.common.cli.ui;

import java.util.ArrayList;
import java.util.List;

import org.galapagos.common.cli.Input;

public class Menu {
	List<MenuItem> list;

	public Menu() {
		list = new ArrayList<MenuItem>();
	}

	// MenuItem을 목록에 추가
	public void add(MenuItem item) {
		list.add(item);
	}

	public void print() {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d]%s ", (i + 1), list.get(i).getTitle());
		}
		System.out.println();
	}

	public MenuItem select() {
		int i = Input.readInt("선택> ") - 1;

		if (i < list.size()) {
			return list.get(i);
		}
		return null;
	}

}
