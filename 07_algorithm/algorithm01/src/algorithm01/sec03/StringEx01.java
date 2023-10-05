package algorithm01.sec03;

import java.util.Scanner;

public class StringEx01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] total = in.next().toUpperCase().toCharArray();
		for(int i = 0; i < total.length; i++)
		System.out.println(total[i]);
		
		char find = in.next().toUpperCase().charAt(0);
		int count = 0;
		for(char c : total) {
			if(find == c) {
				count++;
			}
		}
		System.out.println(count);
		in.close();
	}

}
