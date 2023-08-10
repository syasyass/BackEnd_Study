package java_study01.chapter09.sec07;

import java.util.Arrays;

public class SortEx {

	public static void main(String[] args) {
		int[] scores = { 99, 97, 98, 64, 57, 36, 102 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println(Arrays.toString(scores));
		System.out.println("찾은 인덱스: " + index);

		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println(Arrays.toString(names));
		System.out.println("찾은 인덱스: " + index);

		Member[] members = { new Member("홍길동", 32), new Member("박동수", 24), new Member("김민수", 10), };
		Arrays.sort(members);
		index = Arrays.binarySearch(members, new Member("홍길동", 32));
		System.out.println(Arrays.toString(members));
		System.out.println("찾은 인덱스: " + index);
	}
}