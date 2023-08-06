package java_study01.chapter04;

public class ForLoop {

	public static void main(String[] args) {
		System.out.println("시작");
		long sum = 0;
		for (int i = 0; i < 1000000; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("끝 " + sum);
	}
}