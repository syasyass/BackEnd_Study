package java_study01.chapter04;

import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1~100까지의 합: " + sum);

		sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1~100까지 짝수의 합: " + sum);

		sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1~100까지 짝수의 합: " + sum);

		// 사용자의 입력값까지 짝수의 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 >> ");
		int num = sc.nextInt();

		sum = 0;
		for (int i = 2; i <= num; i += 2) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.printf("1~%d까지 짝수의 합: %d", num, sum);
	}
}