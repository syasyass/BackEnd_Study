package java_study01.chapter06.sec02;

public class MyRoom {

	public static void main(String[] args) {
		Tv t1 = new Tv();
		t1.ch = 3;
		t1.vol = 10;
		t1.onOff = true;
		System.out.println(t1);

		Tv t2 = new Tv();
		t2.ch = 5;
		t2.vol = 8;
		t2.onOff = false;
		System.out.println(t2);

		t1.changeCh(7);
		t2.upVol();
		t2.turnOn();
		t2.upVol();
	}

}
