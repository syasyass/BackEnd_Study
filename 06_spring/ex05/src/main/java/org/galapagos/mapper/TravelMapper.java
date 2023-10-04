package org.galapagos.mapper;

import java.util.List;

import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;

public interface TravelMapper {
	public int getTotalCount(Criteria cri);
	
	// 페이지 목록 추출
	public List<TravelVO> getList(Criteria cri);
	
	public List<TravelVO> getRandom(int count);
	
	public TravelVO read(Long bno); // PK 전달
	
	// insert 후에 pk를 추출
	public void insert(TravelVO travel);
	
	public int update(TravelVO travel);

	public int delete(Long no); // PK 전달

}
