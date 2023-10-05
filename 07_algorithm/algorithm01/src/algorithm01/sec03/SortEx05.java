package algorithm01.sec03;

import java.util.Set;
import java.util.TreeSet;

public class SortEx05 {

	public static void main(String[] args) {
		String s = "fbattsedc";
		
		String[] s2 = s.split("");
		
		Set<String> set = new TreeSet<>(); // 이미 여기에서 tree로 정렬이 됨
		for(String c: s2) {
			set.add(c);
		}
		
		System.out.println(set);

	}

}
