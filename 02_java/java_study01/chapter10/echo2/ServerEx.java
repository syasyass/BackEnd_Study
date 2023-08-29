package java_study01.chapter10.echo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
		Socket socket = null;
		// 서버 소켓 생성
		try (ServerSocket serverSocket = new ServerSocket(10000)) {
			System.out.println("서버 기동됨");
			System.out.println("클라이언트 접속 대기 중");
			socket = serverSocket.accept(); // 접속대기
			System.out.println("클라이언트 접속 성공");

			// 수신용 Reader 만들기
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 전송용 Writer 만들기
			PrintWriter w = new PrintWriter(socket.getOutputStream());

			// 메시지 수신
			String line = r.readLine();
			System.out.println("서버 수신 메시지: " + line);
			System.out.println("통신 종료");

			// 메시지 전송
			w.println(line);
			w.flush();
			System.out.println("메시지 전송: " + w);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
