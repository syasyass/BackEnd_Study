package streamex.stEx01;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList(
				"유재명", "박나리", "윤란", "이순근", "김소연", "황비", "황비");
		
		names.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
		.filter(n -> n.startsWith("황"))
		.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
		.distinct()
		.filter(n -> n.startsWith("윤"))
		.forEach(n -> System.out.println(n));
		System.out.println();
	}

}
