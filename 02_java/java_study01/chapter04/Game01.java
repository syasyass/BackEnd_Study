package java_study01.chapter04;

import java.util.Random;
import java.util.Scanner;

//가위 0, 바위 1, 보 2 게임
public class Game01 {

	public static void main(String[] args) {
		final int SCISSORS = 0;
		final int ROCK = 1;
		final int PAPER = 2; // 코드의 가독성을 올린다.

		int draw = 0, meWin = 0, comWin = 0;

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		while (true) {
			int computer = r.nextInt(3); // 3은 미포함
			System.out.println("0:가위, 1:바위, 2:보, -1:종료 >> ");
			int me = sc.nextInt();

			if (-2 < me && me < 3) {
				if (me == -1) {
					System.out.println("가위, 바위, 보 게임 종료.");
					System.out.println("---------------------");
					System.out.printf("나의 이긴 횟수: %d회\n", meWin);
					System.out.printf("컴의 이긴 횟수: %d회\n", comWin);
					System.out.printf("비긴 횟수: %d회\n", draw);
					int sum = meWin + comWin + draw;
					double result = (double) meWin / sum * 100;
					System.out.println("나의 승률: " + (int) result + "%");
					break;
				}

				System.out.printf("컴퓨터 : %d, 나 : %d\n", computer, me);

				if (computer == me) {
					draw++;
					System.out.println("비겼습니다.");
				} else if ((computer == SCISSORS && me == ROCK) || (computer == ROCK && me == PAPER)
						|| (computer == PAPER && me == SCISSORS)) {
					meWin++;
					System.out.println("내가 이겼습니다.");
				} else {
					comWin++;
					System.out.println("내가 졌습니다.");
				}
			} else {
				System.out.println("범위 내로 입력하세요.");
			}
		}

	}
}