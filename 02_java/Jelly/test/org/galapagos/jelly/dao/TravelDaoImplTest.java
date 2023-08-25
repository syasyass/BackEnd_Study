package org.galapagos.jelly.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.galapagos.jelly.vo.Region;
import org.galapagos.jelly.vo.TravelVO;
import org.junit.jupiter.api.Test;

class TravelDaoImplTest {
	TravelDao dao = TravelDaoImpl.getInstance();

	@Test
	void testGetInstance() {
		TravelDao dao2 = TravelDaoImpl.getInstance();
		assertSame(dao, dao2);
	}

	@Test
	void testGetTotalCount() {
		int totalCount = dao.getTotalCount();

		assertTrue(totalCount == 112);
	}

	@Test
	void testGetPage() {
		List<TravelVO> list = dao.getPage(11, 20);
		assertTrue(list.size() == 10);

		list = dao.getPage(111, 120);
		assertTrue(list.size() == 2);
		assertEquals(2, list.size());
	}

	@Test
	void testGetRegions() {
		List<Region> list = dao.getRegions();
		assertEquals(6, list.size());
	}

	@Test
	void testGetSpots() {
		List<TravelVO> list = dao.getSpots("수도권");
		assertEquals(13, list.size());
	}

	@Test
	void testSearch() {
		List<TravelVO> list = dao.search("%해수욕장%");
		assertEquals(8, list.size());
	}

	@Test
	void testFindById() {
		TravelVO travel = dao.findById(10);
		assertNotNull(travel);

		travel = dao.findById(210);
		assertNull(travel);
	}

}
