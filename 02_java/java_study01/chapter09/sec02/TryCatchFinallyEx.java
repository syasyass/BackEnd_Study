package java_study01.chapter09.sec02;

public class TryCatchFinallyEx {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.lang.String2");
			System.out.println(clazz);
			return;
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
			// e.printStackTrace();
		} finally { // 항상 실행
			System.out.println("====================");
		}
		System.out.println("프로그램 종료!!");
	}
}