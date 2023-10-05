package algorithm01.sec03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringEx03 {

	public static void main(String[] args) {
		String[] s = {"aaa", "bbb", "ccc", "aaa"};
		System.out.println(Arrays.binarySearch(s, "aaa"));
		
		Arrays.fill(s, 0, 2, "haha");
		System.out.println(Arrays.toString(s));

		//����
		List<String> list = Arrays.asList(s);
		Collections.sort(list);
		System.out.println(list);
		
		//���� ������
		Collections.reverse(list);
		System.out.println(list);
		//���� ����
		System.out.println(Collections.frequency(list, "haha"));
		System.out.println(Collections.frequency(list, "ccc"));
	}

}
