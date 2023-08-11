package org.galapagos.mcmorning.exception;

public class UserIdCountOverException extends Exception {
	public UserIdCountOverException() {
		super("사용자 ID 입력횟수 초과");
	}
}