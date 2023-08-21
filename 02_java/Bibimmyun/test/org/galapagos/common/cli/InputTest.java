package org.galapagos.common.cli;

public class InputTest {

	public static void main(String[] args) {
		testInputInt();
	}

	public static void testInputInt() {
		int sel = Input.readInt("선택> ");
		System.out.println("선택번호: " + sel);

		sel = Input.readInt("선택> ");
		System.out.println("선택번호: " + sel);
	}

}
