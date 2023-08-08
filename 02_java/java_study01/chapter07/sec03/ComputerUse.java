package java_study01.chapter07.sec03;

public class ComputerUse {

	public static void main(String[] args) {
		Computer com1 = new Computer(200, "삼성", 27);
		Computer com2 = new Computer(300, "LG", 32);

		System.out.println(com1);
		System.out.println(com2);

		Computer com3 = new Computer();
		com3.setPrice(10000);
		com3.setMaker("Samsung");
		com3.setMonitor(25);

		System.out.println(com3);
	}
}