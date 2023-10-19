package org.galapagos.service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;
import org.galapagos.domain.kakao.local.KakaoLocalResult;
import org.galapagos.domain.kakao.local.Local;
import org.galapagos.mapper.TravelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import retrofit2.Call;
import retrofit2.Response;

@Log4j
@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private TravelMapper mapper;
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<TravelVO> getList(Criteria cri, Principal principal) {
		List<TravelVO> list = mapper.getList(cri);
		if(principal != null) {
			List<Long> hearts = mapper.getHeartsList(principal.getName());
			for(TravelVO travel: list) {
				travel.setMyHeart(hearts.contains(travel.getNo()));
			}
		}
		
		return list;
	}
	
	public List<TravelVO> getRandom(int count) {
		return mapper.getRandom(count);
	}

	@Override
	public TravelVO get(Long no, Principal principal) { // 조회수 증가는 여기에서 처리
		TravelVO travel = mapper.read(no);
		if(principal != null) {
			List<Long> hearts = mapper.getHeartsList(principal.getName());
			travel.setMyHeart(hearts.contains(travel.getNo()));
		}		
		// 주변 검색 - 컨트롤러에 입력할 내용 없음. 서비스에서 끝나는 기능
		String query = "주변 볼거리" + travel.getTitle();
		KakaoSearchService service = KakaoSearchService.getService();
		Call<KakaoLocalResult> call = service.searchLocal(query,  10, 1);
		Response<KakaoLocalResult> res; // 동기식. 서버에 요청 전송
		
		try {
			res = call.execute();
			if (res.isSuccessful()) {
				KakaoLocalResult result = res.body(); // JSON을 BookResult로 역직렬화
				log.info("호출 성공 ===>" + res);
				travel.setLocals(result.getLocals());
			} else {
				log.info("호출 실패 ===>" + res);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return travel;
	}

	@Override
	public void register(TravelVO travel) {
		mapper.insert(travel);
		
		// 첨부파일 업로드도 추가하게 될 수 있음
	}

	@Override
	public boolean modify(TravelVO travel) {
		return mapper.update(travel) == 1;
	}

	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) == 1;
	}

}
