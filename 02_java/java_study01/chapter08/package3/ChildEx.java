package java_study01.chapter08.package3;

public class ChildEx {

	static void run(Parent p) {
		p.method2();
	}

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child);

		Parent parent = child; // 자동 타입 변환
		System.out.println(parent);
		System.out.println();

		run(child);

		System.out.println();

		parent.method1();
		parent.method2(); // 재정의 된 메소드 호출. 가지고 있는 실체가 child이기 때문.
		// parent.method3(); // 호출 불가능. parent 타입에는 method3가 없기 때문.

		System.out.println();

		child.method1();
		child.method2();
		child.method3();
	}
}