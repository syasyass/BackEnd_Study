package java_study01.chapter04;

import java.util.Scanner;

public class WeekendIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("요일 입력: 주중 1) 주말 2) 공휴일 3) ");

		int data = sc.nextInt();
		if (data == 1) {
			System.out.println("열심히 공부합시다!");
		} else if (data == 2) {
			System.out.println("열심히 놀아봅시다!");
		} else {
			System.out.println("공식적으로 놀아봅시다!");
		}
	}
}