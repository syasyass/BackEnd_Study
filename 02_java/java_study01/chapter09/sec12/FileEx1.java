package java_study01.chapter09.sec12;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

//파일 확장자가 .txt인지 여부 판정
class TextFileFilter implements FilenameFilter {
	@Override
	public boolean accept(File dir, String name) {
		System.out.println("필터링: " + name);
		return name.toLowerCase().endsWith(".txt");
	}
}

public class FileEx1 {

	public static void main(String[] args) throws Exception {
		File dir = new File("E:/Temp/Dir");
		File file1 = new File("E:/Temp/FILE1.txt");
		File file2 = new File("E:/Temp/File2.txt");
		File file3 = new File(new URI("file:///E:/Temp/File3.txt"));

		// File 객체의 toString() 내용도 확인 --> 지정한 path 문자열 리턴
		if (dir.exists() == false) {
			System.out.println(dir + " 존재하지 않음");
			dir.mkdirs();
		}
		if (file1.exists() == false) {
			System.out.println(file1 + " 존재하지 않음");
			file1.createNewFile();
		}
		if (file2.exists() == false) {
			System.out.println(file2 + " 존재하지 않음");
			file2.createNewFile();
		}
		if (file3.exists() == false) {
			System.out.println(file3 + " 존재하지 않음");
			file3.createNewFile();
		}

		File temp = new File("E:/Temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		File[] contents = temp.listFiles(new TextFileFilter());
		System.out.println("날짜 		시간	형태	    크기		이름");
		System.out.println("-----------------------------------------");

		for (File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
			System.out.println();
		}

	}

}
