package org.galapagos;

import java.io.IOException;
import java.util.Scanner;

import org.galapagos.domain.kakao.local.KakaoLocalResult;
import org.galapagos.domain.kakao.local.Local;
import org.galapagos.service.KakaoSearchService;

import retrofit2.Call;
import retrofit2.Response;

public class KakaoLocalSearchEx1 {

	public static void main(String[] args) {
		KakaoSearchService api = KakaoSearchService.getService();
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("검색어: ");
			String searchQuery = sc.next();
			
			Call<KakaoLocalResult> call = api.searchLocal(searchQuery, 10, 1);
			
			Response<KakaoLocalResult> res = call.execute(); // 동기식. 서버에 요청 전송
			if (res.isSuccessful()) {
				KakaoLocalResult result = res.body(); // JSON을 BookResult로 역직렬화
				System.out.println(result.getMeta());
				for(Local local : result.getLocals()) {
//					System.out.println(local.getAddressName());
					System.out.println(local);
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