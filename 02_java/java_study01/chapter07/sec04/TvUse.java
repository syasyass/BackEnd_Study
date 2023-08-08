package java_study01.chapter07.sec04;

public class TvUse {

	public static void main(String[] args) {
		System.out.println(Tv.count);
		System.out.println(Tv.info);

		Tv myTv = new Tv(7, 9, true);
		Tv yourTv = new Tv(9, 12, true);

		System.out.println(myTv);
		System.out.println(yourTv);

		Tv[] tvArr = new Tv[100];
		for (int i = 0; i < 100; i++) {
			Tv tv = new Tv(1, 1, true); // 지역변수. 없어진다.
			tvArr[i] = tv;
			// tvArr[i] = new Tv(1,1,true);
		}

		System.out.println(myTv.getChannel());
		System.out.println(yourTv.getChannel());
		System.out.println(tvArr[0]);

		System.out.println(Tv.count); // 권장. 클래스의 참조로 접근.
		System.out.println(myTv.count); // 비권장. 인스턴스 참조는 별로 좋은 접근이 아님
		System.out.println("myTv의 serial number: " + myTv.getSerial());
	}

}
