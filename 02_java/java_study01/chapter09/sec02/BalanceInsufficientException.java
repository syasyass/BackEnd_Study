package java_study01.chapter09.sec02;

public class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException() {
	}

	public BalanceInsufficientException(String message) {
		super(message);
	}
}