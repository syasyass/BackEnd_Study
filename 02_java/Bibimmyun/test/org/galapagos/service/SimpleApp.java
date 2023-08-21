package org.galapagos.service;

import org.galapagos.bibimmyun.Application;
import org.galapagos.common.cli.Input;

public class SimpleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firstPage();
	}

	public static void firstPage() {
		Application app = new Application();

		while (true) {
			System.out.println("1)목록 2)검색 3)종료");
			int sel = Input.readInt("선택> ");
			if (sel == 1) {
				app.showList();
			} else if (sel == 2) {
				app.searchList();
			} else if (sel == 3) {
				app.exit();
			} else {
				System.out.println("잘못된 선택입니다.");
			}
		}
	}

}
