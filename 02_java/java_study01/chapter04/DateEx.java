package java_study01.chapter04;

import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		int hour = date.getHours(); // 취소선의 의미: 비권장. 초창기 만들어진 기능이라 불안정함
		int min = date.getMinutes(); // LocalDateTime << 이게 더 권장됨
		int sec = date.getSeconds();
		System.out.println(hour + "시" + min + "분" + sec + "초");

		int year = date.getYear(); // 밀레니엄 버그 있어서 +1900 해줘야 함
		int month = date.getMonth() + 1;
		int today = date.getDate();
		System.out.println(year + 1900 + "년" + month + "월" + today + "일");
		System.out.printf("%d년 %d월 %d일 \n", year + 1900, month, today);
		System.out.printf("%4d년-%02d월-%02d일 %02d:%02d:%02d\n", year + 1900, month, today, hour, min, sec);
	}
}