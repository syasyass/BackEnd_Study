package algorithm01.sec01;

import java.util.Scanner;

public class StringEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ÀÏ,¿ù,È­ ³¯¾¾¸¦ ¼ø¼­´ë·Î ÀÔ·ÂÇØº¸¼¼¿ä. --- ");
		String data = sc.next(); // Èå¸²,¸¼À½,Èå¸²,Èå¸²,¸¼À½,Èå¸²,Èå¸²,¸¼À½,Èå¸²
		String[] data2 = data.split(",");
		
		int count1 = 0, count2 = 0;
		for (int i = 0; i < data2.length; i++) {
			if(data2[i].equals("Èå¸²")) {
				count1++;
			}else {
				count2++;
			}
		}
		System.out.println("Èå¸²ÀÇ °³¼ö " + count1);
		System.out.println("¸¼À½ÀÇ °³¼ö " + count2);
	}
	
}
