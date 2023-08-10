package java_study01.chapter08.package7;

public abstract class Animal {
	public String kind;

	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	public abstract void sound(); // 추상 메소드
}