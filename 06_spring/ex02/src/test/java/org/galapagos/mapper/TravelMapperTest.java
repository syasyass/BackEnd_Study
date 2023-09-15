package org.galapagos.mapper;

import static org.junit.Assert.fail;

import java.util.List;

import org.galapagos.config.RootConfig;
import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class TravelMapperTest {

	@Autowired
	private TravelMapper mapper;
	
//	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria();
		
		int total = mapper.getTotalCount(cri);
		log.info("total: " + total);
		
		cri.setType("RTD");
		cri.setKeyword("해수욕장");
		total = mapper.getTotalCount(cri);
		log.info("total: " + total);
		
	}

//	@Test
	public void testGetList() {
		Criteria cri = new Criteria();
		
		List<TravelVO> list = mapper.getList(cri);
		for(TravelVO travel : list) {
			log.info(travel);
		}
			
		//검색
		cri.setType("RTD");
		cri.setKeyword("해수욕장");
		list = mapper.getList(cri);
		for(TravelVO travel : list) {
			log.info(travel);
		}
	}

//	@Test
	public void testInsert() {
		TravelVO travel = new TravelVO();
		travel.setTitle("테스트 해수욕장");
		travel.setDescription("테스트로 만든 해수욕장");
		travel.setRegion("수도권");
		travel.setAddress("서울특별시 자치구 자치로 123");
		travel.setPhone("02-123-4567");
		
		mapper.insert(travel);
		
		log.info(travel);
	}

//	@Test
	public void testRead() {
		// 존재하는 게시물 번호로 테스트
		TravelVO travel = mapper.read(114L);
		log.info(travel);
	}

//	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(113L));
	}

//	@Test
	public void testUpdate() {
		TravelVO travel = new TravelVO();
		travel.setNo(114L);
		travel.setTitle("수정된 해수욕장");
		travel.setDescription("수정된 해수욕장 설명");
		travel.setAddress("수정된 자치구 자치로 123");
		travel.setPhone("111-222-3333");
		
		int count = mapper.update(travel);
		
		log.info("UPDATE COUNT: " + count);
	}

}
