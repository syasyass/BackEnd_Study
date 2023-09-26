package algorithm01.sec01;

import java.util.Arrays;

public class StringEx01 {

	public static void main(String[] args) {
		String s = "���� ���α׷�������";
		String s2 = "��¥!!";
		
		System.out.println(s + s2);				// ��Ʈ�� ����
		System.out.println(s.concat(s2));		// ��Ʈ�� ����
		System.out.println(s.charAt(0));		// ���� 1���� ����
		System.out.println(s.startsWith("��"));		// Ư���� ���ڷ� �����ϴ��� Ȯ��
		System.out.println(s.endsWith("��"));		// Ư���� ���ڷ� �������� Ȯ��
		System.out.println(s.substring(3));		// ���ؽ�3 ���� ���ڵ� ��� ����
		System.out.println(s.substring(3, 8));		// �ε��� 3~7���� ����
		System.out.println(s.contains(s2));		// s�� s2�� ���ԵǾ� �ִ���?
		System.out.println(s.lastIndexOf("��"));		// s �� ������ ��ġ, �ڿ�������
		System.out.println(s.indexOf("��"));		// s �� ������ ��ġ, �տ�������
		System.out.println(s.toUpperCase());		// �빮�ڷ�
		System.out.println(s.toLowerCase());		// �ҹ��ڷ�
		System.out.println(s.length());		// ���ڼ�
		System.out.println(s.replace("��", "��"));		// ��ü
		
		String s3 = "������";
		String s4 = "��¥����";
		
		if(s3.equals(s4)) {
			System.out.println("�� ���ڿ��� �����մϴ�.");
		} else {
			System.out.println("�� ���ڿ��� �������� �ʽ��ϴ�.");
		}
		
		if(s3.length() > s4.length()) {
			System.out.println(s3 + "�� �� �� ���ڿ��Դϴ�.");
		} else {
			System.out.println(s4 + "�� �� �� ���ڿ��Դϴ�.");
		}
		
		
		String s7 = "2056521";
		if (s7.charAt(0) == '1') {
			System.out.println("����");
		} else {
			System.out.println("����");
		}
		
		String s5 = "���� ��¥ java programmer�� �Ǿ���";
		int num1 = s5.indexOf("j");
		int num2 = s5.lastIndexOf("r");
		String s6 = s5.substring(num1, num2+1);
		System.out.println(s6.toUpperCase());	
		
		
		String s8 = " [ 10, 20, 30, 40, 50]";
		s8 = s8.replace("[", "");
		s8 = s8.replace("]", "");
		System.out.println(s8);
		
		s8 = s8.trim();
		System.out.println(s8);
		
		String[] s88 = s8.split(", ");
		System.out.println(s88[0]);
		System.out.println(s88[1]);
		System.out.println(s88[2]);
		
		int sum = 0;
		
		for (String x : s88) {
			int x2 = Integer.parseInt(x);
			sum = sum + x2;
		}
		
		System.out.println(sum);
		System.out.println(s88.length);
		
		int[] newArray = new int[s88.length];
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = Integer.parseInt(s88[i]);
		}
		System.out.println(Arrays.toString(newArray));
	}

}
