package algorithm01.sec03;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class SortEx06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int k = sc.nextInt();
		
		TreeSet<Integer> numbers2 = new TreeSet<Integer>(Collections.reverseOrder());
		
		System.out.println(count);
		for(int i = 0; i < count; i++) {
			numbers2.add(sc.nextInt());
			System.out.println(numbers2);
		}
		
		System.out.println("----------------");
		System.out.println(numbers2);
		System.out.println("----------------");
		int findIndex = numbers2.size() - k;
		
		System.out.println("찾는 위치 >> " + findIndex);
		System.out.println(numbers2.first());
		Object[] result = numbers2.toArray();
		System.out.println("찾은 값 >> " + result[findIndex]);
	}

}
