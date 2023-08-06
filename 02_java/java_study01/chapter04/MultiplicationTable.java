package java_study01.chapter04;

public class MultiplicationTable {

	public static void main(String[] args) {
		for (int m = 2; m <= 9; m++) {
			System.out.println("*** " + m + "단 ***");
			for (int n = 1; n <= 9; n++) {
				System.out.printf("%d x %d = %d\n", m, n, (m * n));
			}
			System.out.println("************\n\n");
		}
	}
}