package org.galapagos;

import java.io.IOException;
import java.util.Scanner;

import org.galapagos.domain.kakao.book.Book;
import org.galapagos.domain.kakao.book.BookResult;
import org.galapagos.service.KakaoSearchService;

import retrofit2.Call;
import retrofit2.Response;

public class BookSearchEx1 {

	public static void main(String[] args) {
		KakaoSearchService api = KakaoSearchService.getService();
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("검색어: ");
			String searchQuery = sc.next();
			
			Call<BookResult> call = api.searchBook(searchQuery, 50, 1); //요청을 할 수 있는 Call 객체 리턴
//			System.out.println(call.request()); // 요청 URL 확인
//			System.out.println(call.request().headers()); // 헤더 확인 - 인증 키
			
			Response<BookResult> res = call.execute(); // 동기식. 서버에 요청 전송
			if (res.isSuccessful()) {
				BookResult result = res.body(); // JSON을 BookResult로 역직렬화
				System.out.println(result.getMeta());
				for(Book book : result.getBooks()) {
					System.out.println(book.getTitle());
					System.out.println(book);
				}
			} else {
				System.out.println("호출 실패");
				System.out.println(res); // 실패 시 응답 객체 출력
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}