package streamex.stEx02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {

	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {5,3,2,1,4});
		intStream
			.sorted()
			.forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 30),
				new Student("황비", 10),
				new Student("황비2", 20)
		);
		
		studentList.stream()
			.peek(System.out::println)
			.sorted() // Comparable
			.forEach(s -> System.out.print(s.getScore() + ","));
		System.out.println();
		
		studentList.stream()
			.sorted() // Comparable
			.forEach(s -> System.out.print(s.getScore() + ","));
		System.out.println();
		
		studentList.stream()
			.sorted( Comparator.reverseOrder() ) // 내림차순
			.forEach(s -> System.out.print(s.getScore() + ","));
	}

}
