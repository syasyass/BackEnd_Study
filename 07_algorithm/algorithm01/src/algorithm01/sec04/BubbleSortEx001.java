package algorithm01.sec04;

import java.util.Arrays;

public class BubbleSortEx001 { // O(N^2) �� ���� ���� �˰���

	public static void main(String[] args) {
		int[] array = {6,4,2,1,3,5};
		
		int temp = 0;
		
		// �迭�� ���� -1 (������ ���� ����. ���� ���� �� �� �� ���ڴ� ���� ���ʿ�)
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
