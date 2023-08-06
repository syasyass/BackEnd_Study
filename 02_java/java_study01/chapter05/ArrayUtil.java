package java_study01.chapter05;

import java.util.Scanner;

public class ArrayUtil {

	static void getNumbers(String inputTitle, int[] data) {
		Scanner sc = new Scanner(System.in);

		System.out.print(inputTitle);
		for (int i = 0; i < data.length; i++) {
			data[i] = sc.nextInt();
		}
	}

	static void showNumbers(int[] data) {
		System.out.print("입력된 점수 >> ");
		for (int x : data) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	static int allAll(int[] data) {
		int sum = 0;
		for (int x : data) {
			sum = sum + x;
		}
		return sum;
	}

	static int findMaxValue(int[] data) {
		int max = data[0];
		int maxIx = 0;
		for (int i = 1; i < data.length; i++) {
			if (max < data[i]) {
				max = data[i];
				maxIx = i;
			}
		}
		return maxIx;
	}

	static int findMinValue(int[] data) {
		int min = data[0];
		int minIx = 0;
		for (int i = 1; i < data.length; i++) {
			if (min > data[i]) {
				min = data[i];
				minIx = i;
			}
		}
		return minIx;
	}

	static void swapNumbers(int[] data, int minIx) {
		int temp = 0;

		temp = data[0];
		data[0] = data[minIx];
		data[minIx] = temp;
	}
}
