package org.galapagos.service;

import org.galapagos.domain.naver.LocalResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NaverLocalSearch {
	String BASE_URL = "https://openapi.naver.com/";
	
	@GET("v1/search/local") // 위 주소의 끝에 /가 붙었으므로 앞에 /를 안 붙임
	@Headers({"X-Naver-Client-Id: ZCbRFRRBRS4JOGrKdJC5",
			"X-Naver-Client-Secret: d3vhy4GsHx"}) // 배열. "",로 더 추가해서 넣을 수 있음.
	Call<LocalResult> searchLocal(@Query("query") String query, @Query("display") int display, @Query("start") int start);
	// 윗 줄이 API에 요청할 search GET url이 됨. > ?query=xxx&size=xx&page=xx 
	
	public static NaverLocalSearch getService() { //static이 붙어서 인터페이스여도 구현체임. 레트로핏에 만들어달라고 요청하는 내용.
		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(BASE_URL)
								.addConverterFactory(GsonConverterFactory.create())
								.build();
		
		return retrofit.create(NaverLocalSearch.class);
	}

}
