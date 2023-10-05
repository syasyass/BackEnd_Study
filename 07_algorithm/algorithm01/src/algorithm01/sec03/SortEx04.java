package algorithm01.sec03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEx04 {

	public static void main(String[] args) {
		String[] s = {"aaa", "bbb", "ccc", "abc"};
		
		List<String> list = Arrays.asList(s);
		
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		System.out.println(list);

	}

}
