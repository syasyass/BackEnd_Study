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
				new Member("ȫ�浿", 20),
				new Member("��浿", 40),
				new Member("�ڱ浿", 30),
				new Member("�̱浿", 10),
				new Member("��浿", 50)
		};
		
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
		
		// ���̷� ����
		// Comparable�� ��ӹ��� ���� �Լ��� ��� Comparator�� ���.
		// or Comparable�� �����Ǿ� ������, �ٸ� �������� �����ϰ� ���� ��.(�̹� ���̽�)
		Arrays.sort(members, (o1, o2) -> o1.getAge() - o2.getAge());
		System.out.println(Arrays.toString(members));
		
//		Collections.reverse(members);
//		System.out.println(Arrays.toString(members));
	}

}
