package algorithm01.sec02;

import java.util.ArrayList;

public class ArrayListEx02 {

	public static void main(String[] args) {
		ArrayList ski = new ArrayList();
		ski.add("�ڽ�Ű");
		ski.add("�۽�Ű");
		ski.add("�轺Ű");
		ski.add("����Ű");
		
		System.out.println(ski);
		System.out.println("����: " + ski.size());
		
		for(int i = 0; i < ski.size(); i++) {
			System.out.println(i + 1 + "��: " + ski.get(i));
		}
		System.out.println("-----");
		
		ski.remove(1);
		for(int i = 0; i < ski.size(); i++) {
			System.out.println(i + 1 + "��: " + ski.get(i));
		}
		
		ArrayList list2 = new ArrayList();
		list2.add("�̽�Ű");
		list2.add("�ڽ�Ű");
		list2.add("�罺Ű");
		ski.addAll(list2);
		System.out.println(ski);
		
		System.out.println(list2.isEmpty());
		list2.clear();
		System.out.println(list2);
	}	
}
