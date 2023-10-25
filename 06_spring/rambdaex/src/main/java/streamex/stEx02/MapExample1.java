package streamex.stEx02;

import java.util.Arrays;
import java.util.List;

public class MapExample1 {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("김소연", 10),
				new Student("박나리", 15),
				new Student("윤란", 20)
		);
		
		studentList.stream()
			.mapToInt(Student::getScore) // -> IntStream
			.forEach(score -> System.out.println(score));
	}

}
