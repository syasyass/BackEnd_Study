package org.galapagos.common.cli;

import java.util.List;
import java.util.Scanner;

public class Input {
	static Scanner sc = new Scanner(System.in);

	// Facade Pattern : 복잡한 절차를 일반화 시켜서 하나로 외형을 다시 잡은 것
	public static String read(String title) {
		System.out.print(title);
		return sc.nextLine();
	}

	public static String read(String title, String defaultValue) {
		// 이름(김길동): 엔터치면 김길동으로 입력
		System.out.printf("%s(%s): ", title, defaultValue);
		String answer = sc.nextLine();

		// 그냥 엔터 쳤으면 defaultValue 리턴, 입력값이 있으면 answer 리턴
		return (answer.isEmpty()) ? defaultValue : answer;
	}

	public static int readInt(String title) {
		System.out.print(title);
		int answer = sc.nextInt();
		sc.nextLine(); // 엔터 제거용
		return answer;
	}

	public static boolean confirm(String title) {
		return confirm(title, true);
	}

	public static boolean confirm(String title, boolean defaultValue) {
		String yesNo = defaultValue ? "(Y/n)" : "(y/N)";

		System.out.printf("%s (%s): ", title, yesNo);
		String answer = sc.nextLine();

		if (answer.isEmpty()) {
			return defaultValue;
		}

		return answer.equalsIgnoreCase("y");

//		return answer.isEmpty() ? defaultValue : answer.equalsIgnoreCase("y");

	}

	public static <T> T select(String string, List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			T el = list.get(i);
			System.out.printf("%d) %s\n", (i + 1), el); // el의 toString() 호출
		}

		int sel = readInt(string);
		return list.get(sel - 1);
	}
}