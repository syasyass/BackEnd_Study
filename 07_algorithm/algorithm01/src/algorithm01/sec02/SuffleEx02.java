 package algorithm01.sec02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SuffleEx02 {
	static final int SIZE_FINAL = 10;
	
	public static void swap(int[] arr, int i1, int i2) {
		int t = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = t;
	}

	public static void main(String[] args) {
		int[] cards = new int[SIZE_FINAL];
		Random r = new Random();		

		for(int i = 0; i < SIZE_FINAL; i++) {
			cards[i] = i+1;
		}
		System.out.println(Arrays.toString(cards));
		
		for(int end = SIZE_FINAL-1 ; end > 0; end--) {
			int i = r.nextInt(end+1);
			swap(cards, i, end);
			System.out.println(i + "±³Ã¼ " + Arrays.toString(cards));
		}
		System.out.println(Arrays.toString(cards));

	}

}
    