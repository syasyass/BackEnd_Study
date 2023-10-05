package algorithm01.sec03;

import java.util.Arrays;

class Solution {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (o1, o2) -> {
			int result = o1.charAt(n) - o2.charAt(n);
			return result != 0 ? result : o1.compareTo(o2);
		});
		
		return strings;
	}
}

public class SortEx03 {

	public static void main(String[] args) {
		String[] strings1 = {"sun", "bed", "car"};
		String[] strings2 = {"abce", "abcd", "cdx"};
		String[] answer;
		
		Solution sol = new Solution();
		answer = sol.solution(strings1, 1);
		System.out.println(Arrays.toString(answer));

		answer = sol.solution(strings2, 2);
		System.out.println(Arrays.toString(answer));
	}

}
