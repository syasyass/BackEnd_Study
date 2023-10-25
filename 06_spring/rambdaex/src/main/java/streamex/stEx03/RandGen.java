package streamex.stEx03;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandGen {

	public static void main(String[] args) {
		// 1~100 사이의 랜덤한 숫자 50개를 List로 구성하세요.
		
		List<Integer> rlist = new Random().ints(50, 1, 101) //IntStream
			.sorted()
			.boxed()	// Stream<Integer>
			.collect(Collectors.toList()); // List<Integer>
		
		System.out.println(rlist);
		
		// 1~100 사이의 랜덤한 숫자 50개를 List로 구성하세요.
		// 단, 중복 없이 구성하세요.
		
		List<Integer> dlist = new Random().ints(1, 101) //IntStream
				.distinct()	// 중복제거
				.limit(50)	// 최대 횟수 (무한반복 중지)
				.sorted()
				.boxed()	// Stream<Integer>
				.collect(Collectors.toList()); // List<Integer>
			
		System.out.println(dlist);
		System.out.println(dlist.size());
	}
}