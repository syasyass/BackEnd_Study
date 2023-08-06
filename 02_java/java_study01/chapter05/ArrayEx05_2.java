package java_study01.chapter05;

import java.util.Scanner;

public class ArrayEx05_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] jumsu = new int[5];

		System.out.print("점수 >> ");
		for (int i = 0; i < jumsu.length; i++) {
			jumsu[i] = sc.nextInt();

			for (int x : jumsu) {
				System.out.print(x + " ");
			}
			System.out.println();
		}

		int sum = 0;
		for (int x : jumsu) {
			sum = sum + x;
		}
		System.out.println("전체합계: " + sum);
		double avg = (double) sum / jumsu.length;
		System.out.println("전체평균: " + avg);

		int sum2 = 0;
		for (int i = 0; i < jumsu.length; i++) {
			if (jumsu[i] >= 300) {
				sum2 += jumsu[i];
			}
		}
		System.out.println("300이상 되는 합계: " + sum2);

		for (int i = 0; i < jumsu.length; i++) {
			if (jumsu[i] >= 300) {
				System.out.println("300인 값이 저장된 인덱스: " + i);
			}
		}
	}
}