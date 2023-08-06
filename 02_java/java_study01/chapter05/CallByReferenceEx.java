package java_study01.chapter05;

public class CallByReferenceEx {

	public static void main(String[] args) {
		int[] data = { 100, 200 };

		System.out.printf("교환 전 %d %d\n", data[0], data[1]);

		swap(data);

		System.out.printf("교환 완료 %d %d\n", data[0], data[1]);
	}

	static void swap(int[] data) {
		int temp;
		temp = data[0];
		data[0] = data[1];
		data[1] = temp;
	}
}