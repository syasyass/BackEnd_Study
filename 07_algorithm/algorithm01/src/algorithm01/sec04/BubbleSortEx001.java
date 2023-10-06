package algorithm01.sec04;

import java.util.Arrays;

public class BubbleSortEx001 { // O(N^2) 인 좋지 않은 알고리즘

	public static void main(String[] args) {
		int[] array = {6,4,2,1,3,5};
		
		int temp = 0;
		
		// 배열의 길이 -1 (마지막 숫자 제외. 소팅 끝난 후 맨 끝 숫자는 소팅 불필요)
		for(int i = array.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j+ 1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
	}

}
