package streamex.stEx01;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndReduceExample { // map: 람다식 Function

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
			new Student("홍길동", 90),
			new Student("신용권", 92),
			new Student("유미선", 30)	
		);
		
		double avg = studentList.stream() // stream<Student>
			//중간처리 (학생 객체를 점수로 매핑)
			.mapToInt(Student::getScore) // stream<Integer>
			//최종 처리(평균 점수)
			.average()
			.getAsDouble();
		
		System.out.println("평균 점수: " + avg);
		
		Stream<Student> stream1 = studentList.stream();
		IntStream stream2 = stream1.mapToInt(Student::getScore);
		OptionalDouble optional = stream2.average();
		double avg2 = optional.getAsDouble();
		
		System.out.println("평균 점수2: " + avg2);
		
		stream1 = studentList.stream(); // 스트림은 1회성이기 때문에, 위에서 지나갔으니 다시 선언해주어야 함.
		IntStream stream3 = stream1.mapToInt(Student::getScore);
		stream3.forEach(System.out::println);		
	}

}
