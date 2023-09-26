package algorithm01.sec01;

import java.util.Arrays;

public class StringEx01 {

	public static void main(String[] args) {
		String s = "나는 프로그래머프야";
		String s2 = "진짜!!";
		
		System.out.println(s + s2);				// 스트링 결합
		System.out.println(s.concat(s2));		// 스트링 결합
		System.out.println(s.charAt(0));		// 문자 1글자 추출
		System.out.println(s.startsWith("나"));		// 특정한 문자로 시작하는지 확인
		System.out.println(s.endsWith("야"));		// 특정한 문자로 끝나는지 확인
		System.out.println(s.substring(3));		// 인텍스3 이후 글자들 모두 추출
		System.out.println(s.substring(3, 8));		// 인덱스 3~7까지 추출
		System.out.println(s.contains(s2));		// s에 s2가 포함되어 있는지?
		System.out.println(s.lastIndexOf("프"));		// s 중 프글자 위치, 뒤에서부터
		System.out.println(s.indexOf("프"));		// s 중 프글자 위치, 앞에서부터
		System.out.println(s.toUpperCase());		// 대문자로
		System.out.println(s.toLowerCase());		// 소문자로
		System.out.println(s.length());		// 글자수
		System.out.println(s.replace("나", "너"));		// 교체
		
		String s3 = "참좋다";
		String s4 = "진짜좋다";
		
		if(s3.equals(s4)) {
			System.out.println("두 문자열이 동일합니다.");
		} else {
			System.out.println("두 문자열이 동일하지 않습니다.");
		}
		
		if(s3.length() > s4.length()) {
			System.out.println(s3 + "가 더 긴 문자열입니다.");
		} else {
			System.out.println(s4 + "가 더 긴 문자열입니다.");
		}
		
		
		String s7 = "2056521";
		if (s7.charAt(0) == '1') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		String s5 = "나는 진짜 java programmer가 되었어";
		int num1 = s5.indexOf("j");
		int num2 = s5.lastIndexOf("r");
		String s6 = s5.substring(num1, num2+1);
		System.out.println(s6.toUpperCase());	
		
		
		String s8 = " [ 10, 20, 30, 40, 50]";
		s8 = s8.replace("[", "");
		s8 = s8.replace("]", "");
		System.out.println(s8);
		
		s8 = s8.trim();
		System.out.println(s8);
		
		String[] s88 = s8.split(", ");
		System.out.println(s88[0]);
		System.out.println(s88[1]);
		System.out.println(s88[2]);
		
		int sum = 0;
		
		for (String x : s88) {
			int x2 = Integer.parseInt(x);
			sum = sum + x2;
		}
		
		System.out.println(sum);
		System.out.println(s88.length);
		
		int[] newArray = new int[s88.length];
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = Integer.parseInt(s88[i]);
		}
		System.out.println(Arrays.toString(newArray));
	}

}
