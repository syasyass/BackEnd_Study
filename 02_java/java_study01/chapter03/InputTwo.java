package java_study01.chapter03;

public class InputTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 10;
		int n2 = 4;

		System.out.println(n1 + n2);
		System.out.println(n1 - n2);
		System.out.println(n1 * n2);
		System.out.println(n1 / n2); // * 정수/정수 -> 정수
		System.out.println(n1 / 4.0); // 정수/실수 -> 실수

		// /를 실수 계산값으로 출력
		System.out.println((double) n1 / n2);
	}

}
