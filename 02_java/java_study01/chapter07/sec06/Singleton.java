package java_study01.chapter07.sec06;

public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {

	}

	// 접근제한자:public
	// 정적 선언: static
	// return 타입: Singleton
	// 메소드명: getInstance
	public static Singleton getInstance() {
		return singleton;
	}

	private String dbname = "bbs 데이터베이스";

	public void open() {
		System.out.println("bbs 데이터베이스 열기");
	}

	public void read() {
		System.out.println("bbs 데이터베이스 읽기");
	}

	public void close() {
		System.out.println("bbs 데이터베이스 닫기");
	}
}