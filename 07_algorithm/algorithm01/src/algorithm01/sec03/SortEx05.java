package algorithm01.sec03;

import java.util.Set;
import java.util.TreeSet;

public class SortEx05 {

	public static void main(String[] args) {
		String s = "fbattsedc";
		
		String[] s2 = s.split("");
		
		Set<String> set = new TreeSet<>(); // �̹� ���⿡�� tree�� ������ ��
		for(String c: s2) {
			set.add(c);
		}
		
		System.out.println(set);

	}

}
