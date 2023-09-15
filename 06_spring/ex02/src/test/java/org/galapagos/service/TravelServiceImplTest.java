package org.galapagos.service;

import static org.junit.Assert.*;

import org.galapagos.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class TravelServiceImplTest {

	@Autowired
	private TravelService service;
	
//	@Test
	public void testGetTotal() {
		fail("Not yet implemented");
	}

//	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

//	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

//	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

//	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

//	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

}
