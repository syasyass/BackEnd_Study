package algorithm01.sec03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringListEx02 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		String[] s2 = s.split("");
		
		List<String> list = Arrays.asList(s2);
		System.out.println("---���ĵ� ����> "+list);
		Collections.reverse(list);
		System.out.println("---�����ĵ� ����> "+ list);
		String answer = "";
		for(String x : list) {
			answer += x;
		}
		System.out.println("---���ڿ��� ��ȯ> "+ answer);
	}

}
