package java_study01.chapter09.sec07;

public class Member implements Comparable<Member> {
	String name;
	int age;

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		return -name.compareTo(o.name);
		// return -age - o.age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

}
