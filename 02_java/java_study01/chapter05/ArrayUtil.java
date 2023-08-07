package java_study01.chapter05;

import java.util.Random;
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

	static int findMinValue(int[] data, int start, int end) {
		int min = data[start];
		int minIx = start;
		for (int i = start; i < end; i++) {
			if (min > data[i]) {
				min = data[i];
				minIx = i;
			}
		}
		return minIx;
	}

	// data 배열에서 ix1 위치와 ix2 위치의 값을 서로 교환
	static void swapNumbers(int[] data, int ix1, int ix2) {
		int temp = 0;
		temp = data[ix1];
		data[ix1] = data[ix2];
		data[ix2] = temp;
	}

// length 길이의 배열을 생성해서, until까지의 랜덤한 값을 채운 후 배열을 리턴
	static int[] getRandomArray(int length, int until) {
		int[] data = new int[length];
		Random r = new Random(5); // 시드 값을 주면 매번 같은 랜덤값 얻기 가능
		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(until); // 0~330
		}
		return data;
	}
}