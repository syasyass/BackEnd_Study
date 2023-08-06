package java_study01.chapter05;

public class ArrayEx07 {

	public static void main(String[] args) {
		int[] jumsu = new int[5];

		ArrayUtil.getNumbers("숫자 입력 >> ", jumsu);

		int maxIx = ArrayUtil.findMaxValue(jumsu);
		System.out.println("최고 점수는 " + jumsu[maxIx]);

		int minIx = ArrayUtil.findMinValue(jumsu);
		System.out.println("최저 점수는 " + jumsu[minIx]);
	}
}