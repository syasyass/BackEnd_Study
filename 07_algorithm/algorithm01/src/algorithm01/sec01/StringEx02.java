package algorithm01.sec01;

import java.util.Scanner;

public class StringEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��,��,ȭ ������ ������� �Է��غ�����. --- ");
		String data = sc.next(); // �帲,����,�帲,�帲,����,�帲,�帲,����,�帲
		String[] data2 = data.split(",");
		
		int count1 = 0, count2 = 0;
		for (int i = 0; i < data2.length; i++) {
			if(data2[i].equals("�帲")) {
				count1++;
			}else {
				count2++;
			}
		}
		System.out.println("�帲�� ���� " + count1);
		System.out.println("������ ���� " + count2);
	}
	
}
