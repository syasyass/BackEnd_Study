package java_study01.chapter10.echo4;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
		// 서버 소켓 생성
		try (ServerSocket serverSocket = new ServerSocket(10000)) {
			System.out.println("서버 기동됨");
			System.out.println("클라이언트 접속 대기 중");

			while (true) { // 여러 접속 처리
				Socket socket = serverSocket.accept(); // 접속대기
				System.out.println("클라이언트 접속 성공");

				// 실제 통신은 스레드로 위임
				Thread t = new WorkThread(socket);
				t.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
