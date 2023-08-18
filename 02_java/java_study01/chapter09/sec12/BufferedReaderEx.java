package java_study01.chapter09.sec12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderEx {

	public static void main(String[] args) {
		try (InputStream is = System.in;
				Reader reader = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(reader);) {
			System.out.print("입력: ");
			String lineString = br.readLine();

			System.out.println("출력: " + lineString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
