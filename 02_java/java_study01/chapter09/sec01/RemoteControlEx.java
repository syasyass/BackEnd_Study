package java_study01.chapter09.sec01;

public class RemoteControlEx {

	public static void main(String[] args) {
		RemoteControl rc = null; // 인터페이스 변수 선언
		rc = new Television();
		rc.turnOn();
		rc.turnOff();

		rc = new Audio();
		rc.turnOn();
		rc.turnOff();

		SmartTelevision st = new SmartTelevision();
		RemoteControl rc2 = st;
		rc2.turnOn();
		Searchable sc = st;
		sc.search("인터페이스");
	}
}