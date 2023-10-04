package org.galapagos.service;

import java.util.List;

import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;
import org.galapagos.mapper.TravelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

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
	public List<TravelVO> getList(Criteria cri) {
		return mapper.getList(cri);
	}
	
	public List<TravelVO> getRandom(int count) {
		return mapper.getRandom(count);
	}

	@Override
	public TravelVO get(Long no) { // 조회수 증가는 여기에서 처리
		return mapper.read(no);
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
