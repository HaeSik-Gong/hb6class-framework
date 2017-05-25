package com.hb.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleDAOTest {

	static Logger logger = Logger.getLogger(SampleDAOTest.class);
	static SampleDAO dao;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		dao = new SampleDAO(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		dao.back();
	}

	@Before
	public void setUp() throws Exception {
		dao = new SampleDAO(false);
	}

	@After
	public void tearDown() throws Exception {
		dao.back();
	}

	@Test
	public void testSampleDAO() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull(new SampleDAO());
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		List<Map<String, Object>> list = dao.selectAll();
		
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		Assert.assertSame(3, list.size());
		
		for(Map<String, Object> map : list) {
			logger.debug(map.get("sabun"));
		}
	}
	
	@Test
	public void testSelectOne() throws ClassNotFoundException, SQLException {
		int sabun = 1111;
		Map<String, Object> map = dao.selectOne(sabun);
		
		Assert.assertNotNull(map);
		Assert.assertEquals(sabun, map.get("sabun"));
		Assert.assertEquals("user01", map.get("name"));
		Assert.assertEquals(1000, map.get("pay"));
		
	}

	@Test
	public void testInsertOne() throws ClassNotFoundException, SQLException {
		int sabun=4444, pay=4444;
		String name = "user04";
		
		int result = dao.insertOne(sabun, name, pay);
		Assert.assertSame(1, result);
		
	}
	
}
