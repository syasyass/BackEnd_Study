package algorithm01.sec04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx01 {

	public static void main(String[] args) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		String ana = sc.next();
		
		char[] data2 = data.toCharArray();
		char[] ana2 = ana.toCharArray();
		
		System.out.println(ana2.length);
		for(int i = 0; i < ana2.length; i++) {
			map1.put(ana2[i],map1.getOrDefault(ana2[i], 0) + 1);
		}
		System.out.println(map1);
		
		System.out.println("-----------------------");
		int count =0;
		for(int i = 0; i < (data2.length - ana2.length +1); i++) {
			int start = i;
			int end = i + ana2.length -1;
//			if(end < data2.length) {
			System.out.println(start + " : " + end);
//			}
			char[] window = Arrays.copyOfRange(data2, start, end+1);
			System.out.println(Arrays.toString(window));
			
			for(int j = 0; j < window.length; j++) {
				map2.put(window[j],map2.getOrDefault(window[j], 0) + 1);
			}
			System.out.println(map2);
			
			// map1, map2를 비교해서 에너그램인지 판정
			if(map1.equals(map2)) {
				count++;
				System.out.println(count + "===>" + map2);
			}
			
			map2.clear();
		}
		
	}

}
