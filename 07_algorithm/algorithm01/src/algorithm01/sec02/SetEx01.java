package algorithm01.sec02;

import java.util.HashSet;
import java.util.Random;

public class SetEx01 {

	public static void main(String[] args) {
		Random r = new Random();
		
		HashSet lotto = new HashSet();
		for(int i = 0; lotto.size() < 6; i++) {
			lotto.add(r.nextInt(45)+1); // 0~44 => 1~45
		}
		System.out.println(lotto.size());
		System.out.println(lotto);
	}

}
