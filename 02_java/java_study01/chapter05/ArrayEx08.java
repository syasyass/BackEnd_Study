package java_study01.chapter05;

public class ArrayEx08 {

	// 배열의 입력을 받아서 구성
	// 최소값을 찾아서, 인덱스 0번과 값을 교환
	public static void main(String[] args) {
		// int[] jumsu = new int[5];
		// ArrayUtil.getNumbers("숫자 입력 >> ", jumsu);

		int[] jumsu = ArrayUtil.getRandomArray(10, 100);

		for (int i = 0; i < jumsu.length; i++) {
			int minIx = ArrayUtil.findMinValue(jumsu, i, jumsu.length);
			System.out.printf("jumsu[0]: %d, 최소 점수: %d\n", jumsu[0], jumsu[minIx]);
			ArrayUtil.swapNumbers(jumsu, i, minIx);
			System.out.printf("jumsu[0]: %d, 최소 점수: %d\n", jumsu[0], jumsu[minIx]);
		}

		ArrayUtil.showNumbers(jumsu);
	}
}