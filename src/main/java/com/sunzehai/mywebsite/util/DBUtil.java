package com.sunzehai.mywebsite.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	private static DBUtil instance;
	
	private Properties properties;
	
	private DBUtil() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Load jdbc.properties file failed.");
		}
	}
	
	public static DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String driver = properties.getProperty("jdbc.driver");
		String url = properties.getProperty("jdbc.url");
		String user = properties.getProperty("jdbc.user");
		String password = properties.getProperty("jdbc.password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Get connection failed.", e);
		}
		
		return conn;
	}
	
}
