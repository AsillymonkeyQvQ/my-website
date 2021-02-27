package com.sunzehai.mywebsite.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	private static DataSource cpds;

	public static Connection getConnection() {
		if (cpds == null) {
			cpds = new ComboPooledDataSource("intergalactoApp");
		}

		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Unexpected exception on getting connection", e);
		}
		return conn;
	}
	
}
