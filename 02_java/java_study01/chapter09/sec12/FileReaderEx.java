package java_study01.chapter09.sec12;

import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("E:/Temp/test.txt")) {
			int readCharNo;
			char[] cbuf = new char[100];
			while ((readCharNo = fr.read(cbuf)) != -1) {
				System.out.print(cbuf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
