package java_study01.chapter04;

public class RandomBreakEx {

	public static void main(String[] args) throws Exception {
		while (true) {
			int num = (int) (Math.random() * 6) + 1; // 6:끝 정수, 1:시작 정수
			System.out.println(num);
			if (num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}