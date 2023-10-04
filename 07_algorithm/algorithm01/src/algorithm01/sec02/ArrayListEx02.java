package algorithm01.sec02;

import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		ArrayList ski = new ArrayList();
		ski.add("박스키");
		ski.add("송스키");
		ski.add("김스키");
		ski.add("정스키");
		
		System.out.println(ski);
		System.out.println("개수: " + ski.size());
		
		for(int i = 0; i < ski.size(); i++) {
			System.out.println(i + 1 + "등: " + ski.get(i));
		}
		System.out.println("-----");
		
		ski.remove(1);
		for(int i = 0; i < ski.size(); i++) {
			System.out.println(i + 1 + "등: " + ski.get(i));
		}
		
		ArrayList list2 = new ArrayList();
		list2.add("이스키");
		list2.add("박스키");
		list2.add("양스키");
		ski.addAll(list2);
		System.out.println(ski);
		
		System.out.println(list2.isEmpty());
		list2.clear();
		System.out.println(list2);
	}	
}
