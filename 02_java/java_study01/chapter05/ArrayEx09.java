package java_study01.chapter05;

public class ArrayEx09 {

	public static void main(String[] args) {
		int[] jumsu = ArrayUtil.getRandomArray(10000, 331);

		// 수능 만점자 수는 몇 명일까요?
		int count = 0;
		for (int i = 0; i < jumsu.length; i++) {
			if (jumsu[i] == 330) {
				count++;
				System.out.println(count + ": 만점자 번호는" + i + "번");
			}
		}
		System.out.printf("전체 만점자 수는 %d 명\n", count);
	}
}