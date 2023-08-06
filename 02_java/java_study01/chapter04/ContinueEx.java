package java_study01.chapter04;

public class ContinueEx {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println("i");
		}
	}
}