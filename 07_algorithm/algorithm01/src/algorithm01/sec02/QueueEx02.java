package algorithm01.sec02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx02 {
	
	public static void main(String[] args) {
		Queue subject = new LinkedList();
		subject.offer("����");
		subject.offer("����");
		subject.offer("����");
		subject.offer("��ǻ��");
		subject.offer("����");
		System.out.println(subject);
		
		for(int i = 0; !subject.isEmpty(); i++) {
			System.out.println("���� �� ����: " + subject.poll());
			System.out.println((i+1) + "���� ���� �� �� ���� ����: " + subject);
		}		
	}
}
