package java_study01.chapter08.sec04;

public class SupersonicAirplaneEx {

	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();

		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();

		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();

		sa.land();
	}
}