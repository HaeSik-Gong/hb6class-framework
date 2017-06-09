package com.hb.day02.user.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuestUserDaoImpTest {

	private static GuestUserDaoImp dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String path = "/config-context.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		dao = (GuestUserDaoImp) ac.getBean("guestUserDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() throws SQLException {
		List<GuestUserVo> list = dao.selectAll();
		assertNotNull("list==null", list);
		assertSame(0, list.size());
	}

}
