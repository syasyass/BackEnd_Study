package algorithm01.sec03;

import java.util.Arrays;
import java.util.Comparator;

class StringLengthComp implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
}

public class SortEx01 {
	public static void main(String[] args) {
		String[] total = {"i", "am", "a", "boy"};
		
		Arrays.sort(total);
		System.out.println(Arrays.toString(total));
		
		// Arrays.sort(total, new StringLengthComp());
		Arrays.sort(total, (o1, o2) -> o1.length() - o2.length());
		System.out.println(Arrays.toString(total));
	}

}
