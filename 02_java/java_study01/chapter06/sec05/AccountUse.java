package java_study01.chapter06.sec05;

public class AccountUse {

	public static void main(String[] args) {
		Account dad = new Account();
		dad.name = "홍길동";
		dad.accountName = "튼튼적금";
//		dad.balance = 1000;
		System.out.println(dad);

		dad.deposit(1000);
		dad.deposit(2000);
		dad.deposit(10000);

		dad.withdraw(3000);
		dad.withdraw(2000);

		System.out.println(dad);

		dad.withdraw(20000);
		System.out.println(dad);
	}
}