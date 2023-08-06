package java_study01.chapter04;

import java.util.Scanner;

public class ConsoleTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력>> ");
		String name = scanner.next();

		System.out.print("소속을 입력>> ");
		String company = scanner.next();

		System.out.print("나이를 입력>> ");
		int age = scanner.nextInt();

		System.out.println("당신의 이름은 " + name);
		System.out.println("당신의 소속은 " + company);
		System.out.println("당신의 나이는 " + age);
	}

}