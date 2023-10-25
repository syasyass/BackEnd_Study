package rambdaex.ramEx02;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class PredicateEx1 {
	public static class PredicateExample{
		private static List<Student> list = Arrays.asList(
		new Student("홍길동", "남자", 90),
		new Student("김순희", "여자", 55),
		new Student("감자바", "남자", 45),
		new Student("박한나", "여자", 92)
	);
		
	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		for(Student student : list) {
			if(predicate.test(student)) { //필터링(boolean)
				count++;
				sum += student.getScore();
			}
		}
		return (double) sum / count;
	}

	public static void main(String[] args) {
		double maleAvg = avg( t -> t.getSex().equals("남자") );
		System.out.println("남자 평균 점수: " + maleAvg);
		
		double femaleAvg= avg( t -> t.getSex().equals("여자") );
		System.out.println("여자 평균 점수: " + femaleAvg);
		
		// 과락자(60점 미만)들의 평균 점수
		System.out.println("과락자 평균 점수: " + avg( t -> t.getScore() < 60));
		
		// 통과한(60점 이상) 학생의 평균 점수
		System.out.println("통과자 평균 점수: " + avg( t -> t.getScore() >= 60));
		
		//list를 성적순으로 정렬하세요.
		list.sort((o1, o2) -> o1.getScore() - o2.getScore()); //BiFunction
		System.out.println(list);
		
		BiFunction<Student, Student, Integer> f = (o1, o2) -> o1.getScore() - o2.getScore();
		System.out.println(f);
	}
}
}
