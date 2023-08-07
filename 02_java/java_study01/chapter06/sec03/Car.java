package java_study01.chapter06.sec03;

public class Car {

	// public을 적어주지 않아도, 같은 패키지에서는 public처럼 사용 가능. 패키지가 달라지면 접근 불가
	public String color;

	public void run() {
		System.out.println("부릉부릉 달리다!!");
	}

	public void up() {
		System.out.println("비싼 휘발유를 먹으러!! 미친듯이 속도up!");
	}
}