package algorithm01.sec05;

import java.util.Arrays;

import algorithm.Util;

public class BinarySearchEx01 {

	public static void main(String[] args) {
		int[] x = {5,7,1,4,6,2,3,9,8};
		Arrays.sort(x);
		System.out.println(Arrays.toString(x));
		
		int t = binSearch(x, x.length, 3);
		System.out.println(x[t]);
	}
	
	static int binSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n-1;
		
		do {
			int pc = (pl+pr) / 2;
			if(a[pc] == key) {
				return pc;
			}
			else if(a[pc] < key) {
				pl = pc + 1;
			}
			else {
				pr = pc - 1;
			}
		}while(pl <= pr);
		
		return -1;
	}
}
