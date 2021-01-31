package com.sunzehai.mywebsite.util;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

public class DBUtilTest {

	@Test
	public void testGetConnection() throws Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		
		assertNotNull(conn);
		
		System.out.println(conn.getMetaData().getDatabaseProductName());
		
		conn.close();
	}

}
