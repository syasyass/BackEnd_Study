package java_study01.chapter08.sec01;

public class DmbCellPhone extends CellPhone {
	int channel;

//	public DmbCellPhone(String model, String color, int channel) {
//		// super(); // 자동 추가 --> 부모의 기본 생성자 호출
////		this.model = model; // 상속 속성
////		this.color = color; // 상속 속성
//		super(model, color);
//		this.channel = channel; // 추가 속성
//	}

	public DmbCellPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	}

	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신을 시작합니다.");
	}

	void changechannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + "번으로 바꿉니다.");
	}

	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}