package java_study01.chapter09.sec12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamEx {

	public static void main(String[] args) throws Exception {
		String originalFileName = "E:/Temp/house.jpg";
		String targetFileName = "E:/Temp/house_copy.jpg";

		try (FileInputStream fis = new FileInputStream(originalFileName);
				FileOutputStream fos = new FileOutputStream(targetFileName);) {

			int readByteNo;
			byte[] readBytes = new byte[100];
			while ((readByteNo = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteNo);
			}
			fos.flush();
			System.out.println("복사완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
