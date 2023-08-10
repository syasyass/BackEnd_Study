package java_study01.chapter08.package4;

public class Car {

//	Tire frontLeftTire = new Tire("앞왼쪽", 6);
//	Tire frontRightTire = new Tire("앞오른쪽", 2);
//	Tire backLeftTire = new Tire("뒤왼쪽", 3);
//	Tire backRightTire = new Tire("뒤오른쪽", 4);

	Tire[] tires = { new Tire("앞왼쪽", 6), new Tire("앞오른쪽", 2), new Tire("뒤왼쪽", 3), new Tire("뒤오른쪽", 4), };

	int run() { // 다형성. 운영 형태는 1가지인데 실제 호출되는 tire는 서로 다름
		System.out.println("[자동차가 달립니다.]");
		for (int i = 0; i < tires.length; i++) {
			if (tires[i].roll() == false) {
				stop();
				return (i + 1);
			}
		}
		return 0; // 에러 코드(문제 없다는 뜻)
	}

	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}

//	int run() {
//		System.out.println("[자동차가 달립니다.]");
//		if (frontLeftTire.roll() == false) {
//			stop();
//			return 1; // 에러 코드
//		}
//		;
//		if (frontRightTire.roll() == false) {
//			stop();
//			return 2; // 에러 코드
//		}
//		;
//		if (backLeftTire.roll() == false) {
//			stop();
//			return 3; // 에러 코드
//		}
//		;
//		if (backRightTire.roll() == false) {
//			stop();
//			return 4; // 에러 코드
//		}
//		;
//		return 0; // 에러 코드(문제 없다는 뜻)
//	}
}
