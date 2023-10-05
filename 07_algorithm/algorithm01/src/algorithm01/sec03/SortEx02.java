package algorithm01.sec03;

import java.util.Arrays;
import java.util.Collections;

class Member implements Comparable<Member> {
	private String name;
	private int age;	
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}
}


public class SortEx02 {

	public static void main(String[] args) {
		
		Member[] members = {
				new Member("홍길동", 20),
				new Member("고길동", 40),
				new Member("박길동", 30),
				new Member("이길동", 10),
				new Member("김길동", 50)
		};
		
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
		
		// 나이로 정렬
		// Comparable을 상속받지 않은 함수일 경우 Comparator를 사용.
		// or Comparable가 구현되어 있지만, 다른 기준으로 정렬하고 싶을 때.(이번 케이스)
		Arrays.sort(members, (o1, o2) -> o1.getAge() - o2.getAge());
		System.out.println(Arrays.toString(members));
		
//		Collections.reverse(members);
//		System.out.println(Arrays.toString(members));
	}

}
