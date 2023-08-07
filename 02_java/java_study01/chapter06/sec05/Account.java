package java_study01.chapter06.sec05;

public class Account {
	String name;
	String accountName;
	private int balance;

	public void deposit(int amount) {
		balance += amount;
		System.out.printf("%s이 %d원을 입금하다.\n", name, amount);
	}

	public void withdraw(int amount) {
		if (amount > balance) {
			System.out.printf("%d원 출금이 불가능합니다. 잔액이 부족합니다.\n", amount);
			return;
		}
		balance -= amount;
		System.out.printf("%s이 %s에서 %d원을 출금하다.\n", name, accountName, amount);
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountName=" + accountName + ", balance=" + balance + "]";
	}
}