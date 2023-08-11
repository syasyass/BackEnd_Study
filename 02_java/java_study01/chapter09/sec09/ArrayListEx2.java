package java_study01.chapter09.sec09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx2 {

	public static void main(String[] args) {
		List<String> initList = Arrays.<String>asList("홍길동", "신용권", "감자바"); // 읽기 전용. 크기 고정. 수정 불가.
		List<String> list1 = new ArrayList(initList); // 추가삭제 가능

		list1.set(0, "고길동");
		list1.remove(0);
		list1.add("고길동");

		List<String> list2 = new ArrayList(); // 추가삭제 가능
		list2.addAll(initList);

		for (String name : list1) {
			System.out.println(name);
		}

		List<Integer> list3 = Arrays.asList(1, 2, 3);
		for (int value : list3) {
			System.out.println(value);
		}
	}
}