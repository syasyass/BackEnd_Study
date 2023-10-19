package org.galapagos.service;

import org.galapagos.domain.kakao.book.BookResult;
import org.galapagos.domain.kakao.local.KakaoLocalResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface KakaoSearchService {
	String BASE_URL = "https://dapi.kakao.com/"; // 인터페이스의 변수 = 자동 상수. 반드시 /로 끝나야 함.
	
	@GET("v3/search/book") // 위 주소의 끝에 /가 붙었으므로 앞에 /를 안 붙임
	@Headers({"Authorization: KakaoAK 42daf8b22484971a5429c3be2b174498"}) // 배열. "",로 더 추가해서 넣을 수 있음.
	Call<BookResult> searchBook(@Query("query") String query, @Query("size") int size, @Query("page") int page);
	// 윗 줄이 API에 요청할 search GET url이 됨. > ?query=xxx&size=xx&page=xx 
	
	@GET("v2/local/search/keyword") // 위 주소의 끝에 /가 붙었으므로 앞에 /를 안 붙임
	@Headers({"Authorization: KakaoAK 42daf8b22484971a5429c3be2b174498"}) // 배열. "",로 더 추가해서 넣을 수 있음.
	Call<KakaoLocalResult> searchLocal(@Query("query") String query, @Query("size") int size, @Query("page") int page);
	// 윗 줄이 API에 요청할 search GET url이 됨. > ?query=xxx&size=xx&page=xx 
	
	public static KakaoSearchService getService() { //static이 붙어서 인터페이스여도 구현체임. 레트로핏에 만들어달라고 요청하는 내용.
		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(BASE_URL)
								.addConverterFactory(GsonConverterFactory.create())
								.build();
		
		return retrofit.create(KakaoSearchService.class);
	}
}
