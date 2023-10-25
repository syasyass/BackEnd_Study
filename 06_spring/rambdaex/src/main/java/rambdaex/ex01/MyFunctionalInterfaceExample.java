package rambdaex.ex01;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi= () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> { System.out.println("method call2"); };
		fi.method();
		
		fi = () -> { System.out.println("method call3"); };
		fi.method();
		
		Runnable r = () -> System.out.println("method call4"); // Runnable은 자바에서 제공하는 비어있는 람다식. 쉽게 쓰면 됨.
		r.run();
	}

}
