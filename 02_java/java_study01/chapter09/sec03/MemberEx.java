package java_study01.chapter09.sec03;

public class MemberEx {

	public static void main(String[] args) {
		Member obj1 = new Member("blue", 23);
		Member obj2 = new Member("blue", 23);
		Member obj3 = new Member("red", 25);

		String obj4 = new String("blue");

		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}

		if (obj1.equals(obj3)) {
			System.out.println("obj1과 obj3는 동등합니다.");
		} else {
			System.out.println("obj1과 obj3는 동등하지 않습니다.");
		}

		System.out.println(obj1.equals(obj4));
	}
}