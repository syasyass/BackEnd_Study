package algorithm01.sec02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx02 {
	
	public static void main(String[] args) {
		Queue subject = new LinkedList();
		subject.offer("국어");
		subject.offer("수학");
		subject.offer("영어");
		subject.offer("컴퓨터");
		subject.offer("과학");
		System.out.println(subject);
		
		for(int i = 0; !subject.isEmpty(); i++) {
			System.out.println("시험 본 과목: " + subject.poll());
			System.out.println((i+1) + "일차 시험 본 후 남은 과목: " + subject);
		}		
	}
}
