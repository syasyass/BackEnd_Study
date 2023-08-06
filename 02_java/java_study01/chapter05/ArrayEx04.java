package java_study01.chapter05;

public class ArrayEx04 {

	public static void main(String[] args) {
		// 친구이름
		String[] names = { "홍길동", "김길동", "박길동", "송길동", "정길동" };
		int[] ages = { 50, 40, 30, 20, 10 };
		int[] shoes = { 134, 235, 245, 255, 300 };
		char[] gender = { '남', '여', '남', '남', '여' };

		System.out.print("\t이름\t나이\t발크기\t성별\t\n");
		System.out.print("-------------------------------------\n");

		for (int i = 0; i < names.length; i++) {
			System.out.printf("%d\t%s\t%d\t%d\t%s\n", i + 1, names[i], ages[i], shoes[i], gender[i]);
		}

		System.out.println();
		/*
		 * // 우리가족 5명의 나이를 넣어보세요. 전체 출력 int[] ages = { 50, 40, 30, 20, 10 }; for (int i
		 * = 0; i < ages.length; i++) { System.out.print(ages[i] + " "); }
		 * 
		 * System.out.println();
		 * 
		 * // 친구들의 발 사이즈를 넣어보세요. 전체 출력 int[] shoes = { 134, 235, 245, 255, 300 }; for
		 * (int i = 0; i < shoes.length; i++) { System.out.print(shoes[i] + " "); }
		 * 
		 * System.out.println();
		 * 
		 * // 친구들의 성별을 넣어보세요. 전체 출력 char[] gender = { '남', '여', '남', '남', '여' }; for
		 * (int i = 0; i < gender.length; i++) { System.out.print(gender[i] + " "); }
		 */
	}

}
