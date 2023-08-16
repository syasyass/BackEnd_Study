package java_study01.chapter09.sec10;

import java.util.Objects;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

//	public boolean equals(Object obj) {
//		if (obj instanceof Member) {
//			Member member = (Member) obj;
//			return member.name.equals(name) && (member.age == age);
//		} else {
//			return false;
//		}		
//	}	
//
//	public int hashCode() {
//		return name.hashCode() + age;
//	}

}
