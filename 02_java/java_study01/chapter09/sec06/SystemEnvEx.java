package java_study01.chapter09.sec06;

public class SystemEnvEx {

	public static void main(String[] args) {
		String javaHome = System.getenv("JAVA HOME");
		System.out.println("[ JAVA_HOME ] " + javaHome);
	}
}