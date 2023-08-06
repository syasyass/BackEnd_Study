package java_study01.chapter03;

import javax.swing.JOptionPane;

public class StringCompare2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "root";
		String pw = "pass";

		String inputId = JOptionPane.showInputDialog("아이디 입력");
		String inputPw = JOptionPane.showInputDialog("패스워드 입력");

		if (id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println("로그인 OK");
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}
}
