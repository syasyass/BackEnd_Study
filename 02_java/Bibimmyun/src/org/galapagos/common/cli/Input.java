package org.galapagos.common.cli;

import java.util.Scanner;

public class Input {
	static Scanner sc = new Scanner(System.in);

	// Facade Pattern : 복잡한 절차를 일반화 시켜서 하나로 외형을 다시 잡은 것
	public static String read(String title) {
		System.out.print(title);
		return sc.nextLine();
	}

	public static int readInt(String title) {
		System.out.print(title);
		int answer = sc.nextInt();
		return answer;
	}
}