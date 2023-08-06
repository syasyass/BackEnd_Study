package java_study01.chapter04;

import javax.swing.JOptionPane;

public class PrintfEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data3 = JOptionPane.showInputDialog("현재까지의 누적 포인트: ");
		String data4 = JOptionPane.showInputDialog("추가 포인트: ");
		String point = "작은 값";

		int now = Integer.parseInt(data3);
		double add = Double.parseDouble(data4);

		double result = now + add;

		System.out.printf("최종 포인트는 %f ", result);
		System.out.printf("최종 포인트는 %.3f ", result);
		System.out.printf("%s의 값은 %.2f 입니다.", point, result);
	}

}
