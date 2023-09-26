package algorithm01.sec01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayMinEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		double[] numbers = new double[5];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextDouble();
		}
		sc.close();
		for (double x : numbers) {
			System.out.println(x);
		}
		
		int count = 0;
		for(int i = 0; i < numbers.length; i++) {
			if( numbers[i] == 22.2 ) {
				count++;
			}
		}
		System.out.println(count);
		
		double[] numbers2 = {11.1, 22.2, 22.2, 55.5, 22.2, 11.1, 40.2};
		
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		
		for(double n: numbers2) {
			Integer count2 = map.get(n);
			if(count2 == null) {
				map.put(n, 1);
			} else {
				map.put(n, count+1);
			}
		}
		
		for(double n: map.keySet()) {
			System.out.printf("%.1f: %d°³\n", n, map.get(n));
		}
	}
}
