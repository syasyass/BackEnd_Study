package algorithm01.sec04;

import java.util.Arrays;

import algorithm.Util;

public class SelectSortEx02 { // O(N^2) 인 좋지 않은 알고리즘

	public static void main(String[] args) {
		int[] array = {6,4,2,1,3,5};
		System.out.println(Arrays.toString(array));

		// 배열의 길이 -1 (마지막 숫자 제외. 소팅 끝난 후 맨 끝 숫자는 소팅 불필요)
		for(int i = 1; i < array.length; i++) {
			int j = i;
			int tmp = array[i];
			
			while(j > 0 && array[j-1] > tmp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = tmp;

			System.out.println(Arrays.toString(array));
		}
	}

}
