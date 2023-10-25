package streamex.stEx01;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
			new Member("유재명", Member.MALE, 30),
			new Member("박나리", Member.FEMALE, 20),
			new Member("이순근", Member.MALE, 35),
			new Member("윤란", Member.FEMALE, 27),
			new Member("황비", Member.FEMALE, 31),
			new Member("김소연", Member.FEMALE, 21)
		);
		
		double ageAvg = list.stream()
				.filter(m->m.getSex() == Member.MALE) // filter 특징: 스트림 타입 유지(Member), 개수는 변경 N개 -> M개
				.mapToInt(Member::getAge) // 개수 유지, 타입은 변경 Member -> int
				.average() //최종 처리
				.getAsDouble(); // Optional
		
		double ageAvg2 = list.stream()
				.filter(m->m.getSex() == Member.MALE) // filter 특징: 스트림 타입 유지(Member), 개수는 변경 N개 -> M개
				.mapToInt(Member::getAge) // 개수 유지, 타입은 변경 Member -> int
				.average() //최종 처리
				.getAsDouble(); // Optional
		
		System.out.println("남자 평균 나이: " + ageAvg);
		System.out.println("여자 평균 나이: " + ageAvg2);
	}

}
