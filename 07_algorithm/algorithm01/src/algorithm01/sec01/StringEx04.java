package algorithm01.sec01;

import java.util.Arrays;
import java.util.List;

public class StringEx04 {
	public static void main(String[] args) {
		String all = "  011-123-4567 ";
		
		//1.���� ��� ����
		all = all.trim();
		
		
		
		//2.String[]���� �ٲٱ�
		String[] all2 = all.split("-");
		System.out.println(all2[0]);
		
		//3.ù ��° ���ڿ��� ���� ��Ż��?
		if(all2[0] == "011") {
			System.out.println("��Ż�� SK");
		} else if(all2[0] == "019") {
			System.out.println("��Ż�� LG");
		} else {
			System.out.println("��Ż�� APPLE");
		}

		//4.�� ��° ���ڿ� ���̿� ���� �ֽ�/�õ��� ���δ�?
		if(all2[1].length() <= 4) {
			System.out.println("�ֽ���");
		} else {
			System.out.println("�õ���");
		}
		
		//5.��ü ��ȭ��ȣ�� ���̰� 10���� �̻��̸� ��ȿ�� ��ȣ, �ƴϸ� ��ȿ���� ���� ��ȣ
		if(all2[0].length() + all2[1].length() + all2[2].length() <= 10) {
			System.out.println("��ȿ�� ��ȣ�Դϴ�.");
		} else {
			System.out.println("��ȿ���� ���� ��ȣ�Դϴ�.");
		}
	}
}
