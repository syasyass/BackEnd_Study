package java_study01.chapter08.sec01;

public class CellPhone { // extends object 가 생략되어 있음. 상속을 지정하지 않으면 Object가 부모. Java의 최상위 클래스.
	String model;
	String color;

	public CellPhone() {
	}

	public CellPhone(String model, String color) {
		super(); // 에러가 나지 않음. 부모가 존재한다는 뜻 --> extends object 가 생략되어 있음
		// super();를 생략하면 컴파일러가 자동 추가
		this.model = model;
		this.color = color;
	}

	void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	void bell() {
		System.out.println("벨이 울립니다.");
	}

	void sendVoice(String message) {
		System.out.println("자기: " + message);
	}

	void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}

	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}