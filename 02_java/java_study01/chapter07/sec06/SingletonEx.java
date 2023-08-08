package java_study01.chapter07.sec06;

public class SingletonEx {

	public static void main(String[] args) {

//		Singleton obj1 = new Singleton();
//		Singleton obj2 = new Singleton();

		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();

		if (obj1 == obj2) {
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}

		obj1.open();
		obj2.read();
		obj1.close();
	}
}