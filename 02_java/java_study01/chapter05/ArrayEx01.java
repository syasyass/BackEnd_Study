package java_study01.chapter05;

public class ArrayEx01 {

	public static void main(String[] args) {

		// new 는 Heap 영역에 할당됨
		double[] height = { 123.4, 234.2, 345.3 };
		double[] space = new double[500]; // 0으로 자동 초기화
		char[] gender = { '남', '여', '외' };
		String[] space2 = new String[333]; // 0으로 자동 초기화

		System.out.println(space);
		System.out.println(space[0]);
		System.out.println(space[100]);

		System.out.println(space2);
		System.out.println(space2[0]);
	}
}