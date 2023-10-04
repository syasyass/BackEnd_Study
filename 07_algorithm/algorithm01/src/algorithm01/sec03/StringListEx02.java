package algorithm01.sec03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringListEx02 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		String[] s2 = s.split("");
		
		List<String> list = Arrays.asList(s2);
		System.out.println("---정렬된 상태> "+list);
		Collections.reverse(list);
		System.out.println("---역정렬된 상태> "+ list);
		String answer = "";
		for(String x : list) {
			answer += x;
		}
		System.out.println("---문자열로 전환> "+ answer);
	}

}
