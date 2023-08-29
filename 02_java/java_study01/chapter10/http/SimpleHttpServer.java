package java_study01.chapter10.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {

	public static void main(String[] args) {
		// 서버 소켓 생성
		try (ServerSocket serverSocket = new ServerSocket(9090)) {
			System.out.println("서버 기동됨");
			System.out.println("클라이언트 접속 대기 중");

			while (true) { // 여러 접속 처리
				Socket socket = serverSocket.accept(); // 접속대기
				System.out.println("클라이언트 접속 성공");

				BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// 1. 요청 라인
				String line = r.readLine();
				System.out.println(line);
				String[] url = line.split(" ");
				System.out.println("요청한 파일: " + url[1]);

				// 2. 요청 헤더(key:value)
				while (true) {
					line = r.readLine();
					if (line.equals("")) { // 헤더의 끝
						break;
					}
					System.out.println(line);
				}

				// 3. BODY - GET 요청일때는 없음

				// 응답을 내보냄.
				PrintWriter w = new PrintWriter(socket.getOutputStream());

				// 1. 응답 라인
				w.println("HTTP/1.1 200 OK");

				// 2. 헤더
				w.println("Content-type: text/html");
				w.println(); // 헤더의 끝

				// 3. body 부분
				w.println("<html>");
				w.println("<body><h1>HELLO</h></body>");
				w.println("</html>");
				w.flush();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
