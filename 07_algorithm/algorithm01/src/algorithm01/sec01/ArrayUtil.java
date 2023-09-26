package algorithm01.sec01;

import java.util.Random;

public class ArrayUtil {
	static int findMin(int[] arr) {
		int min = arr[0];
		
		for( int x : arr ) {
			if( min > x) min = x;
		}
		return min;
	}
	
	static int findMax(int[] arr) {
		int max = arr[0];
		
		for( int x : arr ) {
			if( max < x) max = x;
		}
		return max;
	}
	
	static int findRandomMin(int[] arr) {
		int min = 0;
		Random r = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(999) + 1; // +1에서 1은 start깂을 뜻함
			// 정수 1~999 사이
		}
		min = findMin(arr);
		return min;
	}
	
	static int findRandomMax(int[] arr) {
		int max = 0;
		Random r = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(999) + 1; // +1에서 1은 start깂을 뜻함
			// 정수 1~999 사이
		}
		max = findMin(arr);
		return max;
	}
	
	static int countNumber(int[] arr, int n) {
		int count = 0;
		
		for( int x : arr ) {
			if( x == n) {
				count++;
			}
		}
		return count;
	}
	
	static int countNumberAndAddress(int[] arr, int n) {
		int count = 0;
		
		for( int i = 0; i < arr.length; i++) {
			if( arr[i] == n) {
				System.out.println(arr[i] + "의 위치값" + i);
				count++;
			}
		}
		return count;
	}
	
	static int[] randomArr(int size, int end) {	
		return randomArr(size, 0, end);
	}
	
	static int[] randomArr(int size, int start, int end) {	
		int[] arr = new int[size];
		Random r = new Random();
		
		for(int i = 0; i < size; i++) {
			arr[i] = r.nextInt(end-start-1) + start;
		}
		return arr;
	}

}
