package algorithm01.sec04;

import java.util.Arrays;

import algorithm.Util;

public class SelectSortEx04 { // O(N^2) �� ���� ���� �˰���

	public static void main(String[] args) {
		int[] array = {6,4,2,1,3,5};

		// �迭�� ���� -1 (������ ���� ����. ���� ���� �� �� �� ���ڴ� ���� ���ʿ�)
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
