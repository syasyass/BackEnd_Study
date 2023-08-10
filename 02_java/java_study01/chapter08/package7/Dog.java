package java_study01.chapter08.package7;

public class Dog extends Animal {

	public Dog() {
		this.kind = "포유류";
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}