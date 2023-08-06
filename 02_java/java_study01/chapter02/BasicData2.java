package java_study01.chapter02;

public class BasicData2 {

	public static void main(String[] args) {
		// 정수 => int
		byte age = 100;
		short wallet = 20000;
		int money = 5000000;
		long space = 1000000000000L; // L,l 필수
		System.out.println("내 은행에 든 돈: " + money + "원");

		// 실수 => double
		double height = 185.5;
		float weight = 88.8f; // F,f 필수
		System.out.println("내 키는: " + height);

		// 문자 => 1글자
		char gender = '남';
		System.out.println("내 성별은: " + gender);

		// 기본 데이터는 아닌데, 일상 생활에서 문자들을 더 많이 사용하므로,
		// 이 부품을 기본 데이터처럼 쓸 수 있게 만들어 놓음.
		String name = "홍길동";
		System.out.println("내 이름은: " + name);
	}

}
