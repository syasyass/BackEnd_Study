package algorithm01.sec05;

import java.util.Arrays;

public class BinarySearchEx02 {
	
	public static void main(String[] args) {
		int[] num = { 1, 4, 5, 2, 7, 8, 9, 6 };
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.binarySearch(num, 5));
		System.out.println(Arrays.binarySearch(num, 10));
		// -이면 존재하지 않는다는 의미
		System.out.println(Arrays.binarySearch(num, 1, 5, 2)); //1과 5는 구간
		System.out.println(Arrays.binarySearch(num, 1, 5, 8));
	}

}
