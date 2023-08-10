package java_study01.chapter09.sec08;

public class BoxingMethodEx {

	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intValue = box1.get();

		Box<String> box2 = Util.boxing("홍길동");
		String strValue = box2.get();
	}

}
