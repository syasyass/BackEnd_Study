package java_study01.chapter09.sec12;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamEx {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;

		try (FileInputStream fis1 = new FileInputStream("E:/Temp/약학용어집 4_서영아 님.pdf");) { // 27kb
			start = System.currentTimeMillis();
			while (fis1.read() != -1) {
			}
			end = System.currentTimeMillis();
			System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileInputStream fis1 = new FileInputStream("E:/Temp/약학용어집 4_서영아 님.pdf");
				BufferedInputStream bis = new BufferedInputStream(fis1);) { // 27kb
			start = System.currentTimeMillis();
			while (bis.read() != -1) {
			}
			end = System.currentTimeMillis();
			System.out.println("사용하지 않았을 때: " + (end - start) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
