package java_study01.chapter09.sec12;

import java.io.File;
import java.io.FileWriter;

public class FileWriterEx {

	public static void main(String[] args) {
		File file = new File("E:/Temp/file.txt");

		try (FileWriter fw = new FileWriter(file, true)) {
			fw.write("FileWriter는 한글로 된 \r\n");
			fw.write("문자열을 바로 출력할 수 있다. \r\n");
			fw.flush();
			System.out.print("파일에 저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
