package algorithm01.sec01;

import java.util.Arrays;

public class ArrayMinEx03 {

	public static void main(String[] args) {
		
		int[] numbers = new int[1000];
		
		int min = ArrayUtil.findRandomMin(numbers);
		
		int count = ArrayUtil.countNumber(numbers, min);
		
		System.out.println("1000개의 랜덤값 중 최소값은 " + min);
		System.out.println("1000개의 랜덤값 중 최소값은 " + count + "개");
		
		int size = 1000;
		int start = 1;
		int end = 999;
		
		numbers = ArrayUtil.randomArr(size, start, end);
		
		Arrays.sort(numbers);
		
		for (int x : numbers) {
			System.out.println(x);
		}
		System.out.println("제일 큰 수 >>> " + numbers[numbers.length-1]);
		System.out.println("제일 작은 수 >>> " + numbers[0]);
	}

}
