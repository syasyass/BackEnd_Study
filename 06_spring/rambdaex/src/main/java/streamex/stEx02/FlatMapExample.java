package streamex.stEx02;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList(
				"java8 lambda", "stream mapping");
		
		inputList1.stream()
			.map(data -> Arrays.stream(data.split(" "))) // "java8", "lambda" // string으로 출력하려면 Stream<Stream<String>>이어야 함
			.forEach(word -> System.out.println(word));
		System.out.println();
		
		inputList1.stream()
			.flatMap(data -> Arrays.stream(data.split(" "))) // flatMap은 Stream<String>
			.forEach(word -> System.out.println(word));
		System.out.println();
		
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputList2.stream()
			.flatMapToInt(data -> {
				String[] strArr = data.split(",");
				int[] intArr = new int[strArr.length];
				for(int i =0; i <strArr.length; i++) {
					intArr[i] = Integer.parseInt(strArr[i].trim());
				}
				return Arrays.stream(intArr);
			})
			.forEach(number -> System.out.println(number));
		
		System.out.println("===========================");
		inputList2.stream()
			.map(data->data.replace(" ", "")) //공백 제거
			.flatMap(data -> Arrays.stream(data.split(",")))	// Stream<String>
			.mapToInt(Integer::parseInt)	// IntStream
			.forEach(System.out::println);
	}

}
