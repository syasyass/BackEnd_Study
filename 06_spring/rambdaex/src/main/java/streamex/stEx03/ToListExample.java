package streamex.stEx03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import rambdaex.ramEx01.Student;

public class ToListExample {

	public static void main(String[] args) {
		List<Student2> totalList= Arrays.asList(
				new Student2("홍길동", 30, Student2.Sex.MALE),
				new Student2("황비", 10, Student2.Sex.FEMALE),
				new Student2("재무", 20, Student2.Sex.MALE),
				new Student2("란란", 6, Student2.Sex.FEMALE)
		);
		
		//남학생들만 묶어 List 생성
		List<Student2> maleList = totalList.stream()
				.filter(s -> s.getSex() == Student2.Sex.MALE)
				.collect(Collectors.toList()); // List로 수집
		maleList.stream()
			.forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		//남학생들만 묶어 Set 생성
		Set<Student2> maleSet = totalList.stream()
			.filter(s -> s.getSex() == Student2.Sex.MALE)
			.collect(Collectors.toSet());
		
		//여학생들만 묶어 HashSet 생성
		Set<Student2> femaleSet = totalList.stream()
				.filter(s -> s.getSex() == Student2.Sex.FEMALE)
				//.collect(Collectors.toCollection(HashSet::new));
				//.collect(Collectors.toCollection(
//							()->{return new HashSet<Student2>(); }) );
				.collect( Collectors.toCollection(()->new HashSet<Student2>()) );
		femaleSet.stream()
			.forEach(s -> System.out.println(s.getName()));

	}

}
