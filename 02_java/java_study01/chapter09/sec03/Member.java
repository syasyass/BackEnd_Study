package java_study01.chapter09.sec03;

public class Member {
	public String id; // 테스트를 위해 편의상 public으로. 평소에 쓰면 안 됨.
	public int age;

	public Member(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { // 매개값이 Member 타입인지 확인
			Member member = (Member) obj; // 타입 변환 후
			if (id.equals(member.id) && age == member.age) {// id,age 필드 동일 여부 확인
				return true;
			}
		}
		return false;
	}
}