package java_study01.chapter04;

public class MakeStars {

	public static void main(String[] args) {
		for (int m = 1; m <= 5; m++) {
			for (int n = 1; n <= m; n++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}