package java_study01.chapter09.sec07;

import java.util.Scanner;

public class StringFileNameEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("파일명 입력>> ");
		String fileName = scanner.nextLine();
		String test = fileName.toLowerCase();

		if (test.endsWith(".mp3")) {
			System.out.println("mp3 파일입니다.");
		} else {
			System.out.println("mp3 파일이 아닙니다.");
		}
		scanner.close();
	}
}