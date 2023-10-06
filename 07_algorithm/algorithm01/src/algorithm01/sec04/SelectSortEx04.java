package algorithm01.sec04;

import java.util.Arrays;

import algorithm.Util;

public class SelectSortEx04 { // O(N^2) 인 좋지 않은 알고리즘

	public static void main(String[] args) {
		int[] array = {6,4,2,1,3,5};

		// 배열의 길이 -1 (마지막 숫자 제외. 소팅 끝난 후 맨 끝 숫자는 소팅 불필요)
		for(int i = 0; i < array.length-1; i++) {
			int min = array[i];
			int ix = i;
			
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < min) {
					ix = j;
					min = array[j];
				}
			}
			Util.swap(array, i, ix);
		}
		
		System.out.println(Arrays.toString(array));
	}

}
