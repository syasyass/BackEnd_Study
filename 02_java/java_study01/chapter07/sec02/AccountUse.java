package java_study01.chapter07.sec02;

public class AccountUse {

	public static void main(String[] args) {
		Account a1 = new Account("홍길동", "일반적금", 200000);
		System.out.println(a1);

		Account a2 = new Account("고길동", "일반예금", 10000);
		System.out.println(a2);

		// 통장 잔액을 알고 싶다.
		System.out.println(a2.getMoney());

		// 잔액 변경
		a2.setMoney(20000);
		System.out.println(a2.getMoney());

		// 만약 기본 생성자를 명시해 주지 않았다면 에러가 남. 다른 생성자가 존재하기 때문.
		Account a4 = new Account();
		System.out.println(a4);

	}

}
