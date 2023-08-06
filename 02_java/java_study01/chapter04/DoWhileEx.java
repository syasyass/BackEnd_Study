package java_study01.chapter04;

import java.util.Scanner;

public class DoWhileEx {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");

		Scanner scanner = new Scanner(System.in);
		String inputString;

		do {
			System.out.print(">");
			inputString = scanner.nextLine(); // 키보드로 입력한 문자열 얻기
			System.out.println(inputString);
		} while (!inputString.equalsIgnoreCase("q"));

		System.out.println();
		System.out.println("프로그램 종료");

	}

}
