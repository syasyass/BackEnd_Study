package algorithm01.sec02;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Shuffle {

	public static void main(String[] args) {
		// 1~10 ������ ���ڸ� �����ϰ� �̾� numbers�� ä�켼��.
		// ��, ���ڴ� �ߺ��Ǹ� �� ��.
		
		int[] cards = new int[52];
		Random r = new Random();		
		Set numbers = new HashSet();
		
		int i = 0;
		while(numbers.size() < 52) {
			int data = r.nextInt(52)+1;
			if(numbers.add(data)) {
				cards[numbers.size() - 1] = data;
			} // 0~9 => 1~10
			System.out.println(i); //�ݺ� Ƚ���� ����. set�� ���� �� ���� ����.
			i++;
		}
		System.out.println("�õ� Ƚ��: " + i);
		System.out.println("ũ��: " + numbers.size());
		System.out.println(numbers);

	}

}
