package algorithm01.sec02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx01 {

	public static void main(String[] args) {
		Queue milk = new LinkedList();
		
		milk.offer("어제의 우유");
		milk.offer("오늘의 우유");
		milk.offer("내일의 우유");
		System.out.println(milk);
		System.out.println(milk.poll());
		
		milk.offer("모레의 우유");
		System.out.println(milk.peek());	//다음 아이템을 한 번 들여다 보는 기능
		System.out.println(milk);
	}
}
