package java_study01.chapter08.sec03;

public class Computer extends Calculator {

	@Override // annotation. 아래 선언에서 실수로 오타를 내거나 하면 에러로 체크해달라는 뜻.
	double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Computer......" + super.toString(); // 부모의 것을 불러온 것
	}
}