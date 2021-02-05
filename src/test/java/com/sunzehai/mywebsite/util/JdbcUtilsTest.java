package com.sunzehai.mywebsite.util;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

public class JdbcUtilsTest {
	
	@Test
	public void testGetConnection() throws Exception {
		try(Connection conn = JdbcUtils.getConnection()) {
			assertNotNull(conn);
			System.out.println(conn);
		}
	}
	
}
