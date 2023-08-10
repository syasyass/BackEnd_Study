package java_study01.chapter09.sec02;

public class Account {
	private long balance;

	public Account() {
	}

	public long getBalance() {
		return balance;
	}

	public void deposit(int money) {
		balance += money;
	}

	public void withdraw(int money) throws BalanceInsufficientException {
		if (balance < money) {
			throw new BalanceInsufficientException("잔고부족: " + (money - balance) + "모자랑");
		}
		balance -= money;
	}

}
