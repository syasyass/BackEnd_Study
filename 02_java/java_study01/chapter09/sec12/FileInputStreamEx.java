package java_study01.chapter09.sec12;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("E:/Temp/test.txt")) {
			int data;
			while ((data = fis.read()) != -1) {// 1byte씩 읽고 콘솔에 출력
				System.out.write(data);
			}
			System.out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				System.out.println("파일닫기");
//				if (fis != null) {
//					fis.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
}