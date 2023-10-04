package algorithm01.sec02;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Shuffle {

	public static void main(String[] args) {
		// 1~10 범위의 숫자를 랜덤하게 뽑아 numbers를 채우세요.
		// 단, 숫자는 중복되면 안 됨.
		
		int[] cards = new int[52];
		Random r = new Random();		
		Set numbers = new HashSet();
		
		int i = 0;
		while(numbers.size() < 52) {
			int data = r.nextInt(52)+1;
			if(numbers.add(data)) {
				cards[numbers.size() - 1] = data;
			} // 0~9 => 1~10
			System.out.println(i); //반복 횟수가 많음. set을 쓰면 안 좋은 문제.
			i++;
		}
		System.out.println("시도 횟수: " + i);
		System.out.println("크기: " + numbers.size());
		System.out.println(numbers);

	}

}
