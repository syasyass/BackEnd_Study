package java_study01.chapter05;

public class ArrayEx02 {

	public static void main(String[] args) {
		int[] jumsu = new int[1000];
		System.out.println(jumsu);

		jumsu[0] = 100;
		jumsu[10] = 200;
		jumsu[999] = 1000;
		// jumsu[1000] = 100000; //에러남. 인덱스는 0~999가 마지막.

		System.out.println("첫번째 값" + jumsu[0]);
		System.out.println("11번째 값" + jumsu[10]);
		System.out.println("마지막 값" + jumsu[999]);
		System.out.println("500번째 값" + jumsu[499]);

		for (int i = 0; i < jumsu.length; i++) { // 인덱스 기반, .length(상수)
			System.out.println(i + ": " + jumsu[i]);
		}

		int sum = 0;
		for (int value : jumsu) { // 값을 기반
			System.out.println(value);
			sum += value;
		}
	}
}