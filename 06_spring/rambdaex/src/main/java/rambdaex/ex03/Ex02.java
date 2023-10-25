package rambdaex.ex03;

public class Ex02 {
	private String name="홍길동";
	
	public Runnable test() {
		final String lname="고길동"; // 람다의 지역변수는 어차피 final 처리가 되기 때문에 명시해 주는 것이 나음
		Runnable r;
		
		// Runnable의 익명구현객체에서 this 확인
		r = new Runnable() {
			private String name="박길동";
			@Override
			public void run() {
				System.out.println(this.name);
			}
		};
		r.run();
		System.out.println(this); // 람다식의 this 콜로 나오는 주소값에서 함수명 뒤 $1은 람다식을 의미: rambdaex.ex03.Ex02$1@53bd815b
//		lname = "이길동"; // 에러남
		
//		r = ()->System.out.println(this.name); // 람다식으로 부른 this는 람다식의 this가 아니라, 람다를 부른 쪽의 this가 됨
//		r.run();
//		
//		r = ()->System.out.println(name); // 위에서 this 생략 가능
//		r.run();
		
//		r = ()->System.out.println(this.name);
		r = ()->System.out.println(lname); //지역변수가 람다에서 쓰이면 이 지역변수는 final(상수)로 처리됨
//		lname = "이길동"; // 에러남. 상수 처리되었기 때문
		return r; // = return ()->System.out.println(this.name);
	}

	public static void main(String[] args) {
		Ex02 t = new Ex02();
		Runnable r = t.test();
		r.run();
	}

}
