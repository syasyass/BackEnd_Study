package java_study01.chapter05;

public class ArrayEx06 {

	public static void main(String[] args) {
		// 5개의 점수를 받아서 평균을 출력
		final int JUMSU_NUM = 5;

		int[] jumsu = new int[JUMSU_NUM];

		ArrayUtil.getNumbers("점수 >> ", jumsu);
		ArrayUtil.showNumbers(jumsu);
		int sum = ArrayUtil.allAll(jumsu);

		double avg = (double) sum / jumsu.length;

		System.out.println("전체평균: " + avg);
	}
}