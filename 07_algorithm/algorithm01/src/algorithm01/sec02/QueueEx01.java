package algorithm01.sec02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx01 {

	public static void main(String[] args) {
		Queue milk = new LinkedList();
		
		milk.offer("������ ����");
		milk.offer("������ ����");
		milk.offer("������ ����");
		System.out.println(milk);
		System.out.println(milk.poll());
		
		milk.offer("���� ����");
		System.out.println(milk.peek());	//���� �������� �� �� �鿩�� ���� ���
		System.out.println(milk);
	}
}
