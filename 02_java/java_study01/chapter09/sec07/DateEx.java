package java_study01.chapter09.sec07;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초"); // 대문자는 24시간제, 소문자는 12시간제
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);

	}

}
