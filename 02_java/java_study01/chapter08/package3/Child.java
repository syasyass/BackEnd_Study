package java_study01.chapter08.package3;

public class Child extends Parent {

	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}

	public void method3() {
		System.out.println("Child-method3()");
	}

	@Override
	public String toString() {
		return "Child []";
	}
}