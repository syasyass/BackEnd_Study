package algorithm01.sec04;

import java.util.Arrays;

import algorithm.Util;

public class SelectSortEx02 { // O(N^2) �� ���� ���� �˰���

	public static void main(String[] args) {
		int[] array = {6,4,2,1,3,5};
		System.out.println(Arrays.toString(array));

		// �迭�� ���� -1 (������ ���� ����. ���� ���� �� �� �� ���ڴ� ���� ���ʿ�)
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
