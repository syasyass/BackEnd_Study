package java_study01.chapter04;

import java.util.Scanner;

public class SwitchEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("저녁에 먹을 음식 종류는 짜장면, 우동, 라면 ? ");
		String food = scanner.next();

		switch (food) {
		case "짜장면":
			System.out.println("중국집으로 가요!");
			break;
		case "우동":
			System.out.println("우동집으로 가요!");
			break;
		case "라면":
			System.out.println("라면집으로 가요!");
			break;
		default:
			System.out.println("집으로");
		}

	}

}
