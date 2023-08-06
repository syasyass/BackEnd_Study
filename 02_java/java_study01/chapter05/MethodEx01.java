package java_study01.chapter05;

public class MethodEx01 {

	public static void main(String[] args) {
		printCharacter('*', 30);
		System.out.println("Hello, Java");
		printCharacter('-', 30);

		for (int i = 1; i <= 5; i++) {
			printCharacter('*', i);
		}

		for (int i = 6; i >= 1; i--) {
			printCharacter('*', i);
		}
	}

	static void printCharacter(char ch, int num) {
		for (int cnt = 0; cnt < num; cnt++)
			System.out.print(ch);
		System.out.println();
	}

}