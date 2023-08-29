package java_study01.chapter10.echo1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx {

	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1", 10000)) {
			InputStream in = socket.getInputStream(); // 수신(입력) 스트림
			OutputStream out = socket.getOutputStream(); // 전송(출력) 스트림

			String str = "Hello, Server";
			out.write(str.getBytes()); // 메시지 전송
			out.flush();

			byte arr[] = new byte[100]; // 수신 버퍼
			int size = in.read(arr); // 메시지 수신
			System.out.println("메시지 수신: ");
			System.out.println(new String(arr, 0, size));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
