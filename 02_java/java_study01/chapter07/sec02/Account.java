package java_study01.chapter07.sec02;

public class Account {
	private String name;
	private String ssn;
	private int money;

	// 생성자 정의
	public Account() {
	} // 디폴트 생성자는 항상 정의하는 것이 관례

	public Account(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	public Account(String name, String ssn, int money) {
		this.name = name;
		this.ssn = ssn;
		this.money = money;
	}

	// 일반 메서드 정의
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getMoney() { // Getter
		return money;
	}

	public void setMoney(int money) { // Setter
		this.money = money;
	}

	public void deposit(int amount) {
		money += amount;
		System.out.printf("%s이 %d원을 입금하다.\n", name, amount);
	}

	public void withdraw(int amount) {
		if (amount > money) {
			System.out.printf("%d원 출금이 불가능합니다. 잔액이 부족합니다.\n", amount);
			return;
		}
		money -= amount;
		System.out.printf("%s이 %s에서 %d원을 출금하다.\n", name, ssn, amount);
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", accountName=" + ssn + ", balance=" + money + "]";
	} // toString은 제일 마지막에 정의하는 게 관례
}