package java_study01.chapter06.sec04;

public class BuildHouse {

	public static void main(String[] args) {
		Block bk1 = new Block();
		bk1.x = 50;
		bk1.y = 50;
		bk1.color = "회색";
		System.out.println(bk1);

		Block bk2 = new Block();
		bk2.x = 150;
		bk2.y = 150;
		bk2.color = "파랑색";
		System.out.println(bk2);

		bk1.put();
		bk2.put();
	}
}