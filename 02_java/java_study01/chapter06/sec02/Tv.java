package java_study01.chapter06.sec02;

public class Tv {

	public int ch; // 0으로 초기화
	public int vol;
	public boolean onOff; // false 초기화

	public void changeCh(int num) {
		int change = num; // 지역변수, local 변수
		System.out.println(ch + "에서 " + change + "번호로 바꾸다.");
		ch = num;
	}

	public void upVol() {
		if (onOff == true) {
			System.out.println(vol + "볼륨을 키워서 동영상을 보다.");
		} else {
			System.out.println("Tv가 꺼져 있다.");
		}
	}

	public void turnOn() {
		onOff = true;
		System.out.println("Tv를 켰다.");
	}

	public void turnOff() {
		onOff = false;
		System.out.println("Tv를 껐다.");
	}

}