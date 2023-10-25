package rambdaex.referEx1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Member {
	private String name;
	private String id;
	
	public Member() { // () -> new Member();
		System.out.println("Member() 실행");
	}
	public Member(String id) { // (id) -> new Member(id);
		System.out.println("Member(String id) 실행");
		this.id = id;
	}
	public Member(String name, String id) { // (name, id) -> new Member(name, id);
		System.out.println("Member(String name, String id) 실행");
		this.name = name;
		this.id = id;
	}
	
	public String getId() { return id; }
	
	public static void main(String[] args) {
		Function<String, Member> function1 = Member::new;
		Member member1 = function1.apply("angel"); // new Member("angel");
		
		BiFunction<String, String, Member> function2 = Member::new;
		Member member2 = function2.apply("신천사", "angel"); // new Member("신천사", "angel");
	}

}
