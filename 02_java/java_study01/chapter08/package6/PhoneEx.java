package java_study01.chapter08.package6;

public class PhoneEx {

	public static void main(String[] args) {
		// Phone phone = new Phone(); (X)

		SmartPhone smartPhone = new SmartPhone("홍길동");

		smartPhone.turnOn(); // Phone의 메소드
		smartPhone.internetSearch();
		smartPhone.turnOff(); // Phone의 메소드

		Phone phone = new SmartPhone("홍길동");

		phone.turnOn();
		((SmartPhone) phone).internetSearch();
		phone.turnOff();
	}
}