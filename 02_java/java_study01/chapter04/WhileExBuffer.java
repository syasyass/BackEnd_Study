package java_study01.chapter04;

public class WhileExBuffer {

	public static void main(String[] args) throws Exception {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		while (run) {
			if (keyCode != 13 && keyCode != 10) {
				// 이 if 부분이 없으면, windows는 \n과 \r 때문에 블록 내 내용이 3번 반복됨. 맥이나 리눅스는 1번
				System.out.println("--------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("--------------------");
				System.out.print("선택: ");
			}

			keyCode = System.in.read();

			if (keyCode == 49) { // 1
				speed++;
				System.out.println("현재 속도= " + speed);
			} else if (keyCode == 50) { // 2
				speed--;
				System.out.println("현재 속도= " + speed);
			} else if (keyCode == 51) { // 3
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}

}
