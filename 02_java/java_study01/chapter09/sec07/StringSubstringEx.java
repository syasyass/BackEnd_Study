package java_study01.chapter09.sec07;

public class StringSubstringEx {

	public static void main(String[] args) {
		String ssn = "880815-1234567 ";

		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);

		String secondNum = ssn.substring(7);
		System.out.println(secondNum);

		// 파일의 확장명을 추출하세요.
		String fileName = "Hello.World.mp3";

		int ix = fileName.lastIndexOf(".");
		if (ix != -1) {
			String thirdNum = fileName.substring(ix + 1);
			System.out.println(thirdNum);

			// 확장명을 제외한 파일명만 추출하세요.
			String baseName = fileName.substring(0, ix);
			System.out.println(baseName);
		}
	}
}