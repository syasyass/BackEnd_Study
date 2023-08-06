package java_study01.chapter05;

public class CallByValueEx {

	public static void main(String[] args) {
		int x = 100;
		int y = 200;

		swap(x, y);

		System.out.printf("x: %d, y: %d\n", x, y);
	}

	static void swap(int x, int y) {
		System.out.printf("교환전 x: %d y: %d\n", x, y);

		int temp = 0;
		temp = x;
		x = y;
		y = temp;

		System.out.printf("교환중 x: %d y: %d\n", x, y);
	}
}