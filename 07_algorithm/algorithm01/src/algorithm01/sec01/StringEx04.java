package algorithm01.sec01;

import java.util.Arrays;
import java.util.List;

public class StringEx04 {
	public static void main(String[] args) {
		String all = "  011-123-4567 ";
		
		//1.공백 모두 제거
		all = all.trim();
		
		
		
		//2.String[]으로 바꾸기
		String[] all2 = all.split("-");
		System.out.println(all2[0]);
		
		//3.첫 번째 문자열에 따른 통신사는?
		if(all2[0] == "011") {
			System.out.println("통신사는 SK");
		} else if(all2[0] == "019") {
			System.out.println("통신사는 LG");
		} else {
			System.out.println("통신사는 APPLE");
		}

		//4.두 번째 문자열 길이에 따른 최신/올드폰 여부는?
		if(all2[1].length() <= 4) {
			System.out.println("최신폰");
		} else {
			System.out.println("올드폰");
		}
		
		//5.전체 전화번호의 길이가 10글자 이상이면 유효한 번호, 아니면 유효하지 않은 번호
		if(all2[0].length() + all2[1].length() + all2[2].length() <= 10) {
			System.out.println("유효한 번호입니다.");
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}
}
