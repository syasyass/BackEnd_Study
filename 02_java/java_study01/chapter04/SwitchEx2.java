package java_study01.chapter04;

import java.util.Date;

public class SwitchEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		int month = date.getMonth() + 1;
		int day = date.getDay();
		System.out.println(day);

		switch (day) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6: // 주
			System.out.println("자바공부하러가");
			break;

		default:
			break;
		}

	}

}
