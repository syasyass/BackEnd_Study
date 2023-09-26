package algorithm01.sec01;

import java.util.Arrays;
import java.util.List;

public class StringEx03 {

	public static void main(String[] args) {
		String all = "����, ����, ����, ��ǻ��";
		//1.String[]���� �ٲٱ�
		String[] all2 = all.split(",");
		System.out.println(all2[1]);
		
		//2.���� ��� ���� �� �ٽ� �迭�� �ֱ�
		for(int i = 0; i < all2.length; i++) {
			if(all2[i].contains(" ")) {
				all2[i] = all2[i].trim();
			}
		}
		System.out.println(all2[1]);
		
		//3.�������?
		System.out.println("�����: " + all2.length);
		
		//4.��ǻ���� ��ġ��?
		for(int i = 0; i < all2.length; i++) {
			if(all2[i].equals("��ǻ��")) {
				System.out.println(i);
			}
		}
		
		//5.������� 3���� �̸��� �������?
		int count = 0;
		for(int i = 0; i < all2.length; i++) {
			if(all2[i].length() < 3) {
				count++;
			}
		}
		System.out.println(count);

		List<String> list = Arrays.asList(all2);
		System.out.println(list.indexOf("��ǻ��"));
	}

}
