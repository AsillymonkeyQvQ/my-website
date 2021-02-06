package com.sunzehai.mywebsite.dao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.util.JdbcUtils;

public class CommonDao {
	
	private static CommonDao instance;
	
	private Logger logger = LoggerFactory.getLogger(CommonDao.class);
	
	private Path sqlFilePath = Paths.get(ClassLoader.getSystemClassLoader().getResource("sql").getPath());
	
	private CommonDao() {
		
	}
	
	public static CommonDao instance() {
		if (instance == null) {
			instance = new CommonDao();
		}
		return instance;
	}
	
	public <T> List<T> getResultList(Class<T> clazz, SqlFileCons sqlFileCons, Object... args) {
		String sql = "";
		try {
			sql = Files.lines(sqlFilePath.resolve(sqlFileCons.name() + ".sql")).collect(Collectors.joining("\n"));
		} catch (IOException ex) {
			throw new RuntimeException("Cloud not load target sql file", ex);
		}
		
		logger.debug("\n-- {}\n{}\nbind => [{}]", sqlFileCons.name(), sql, Arrays.stream(args).map(arg -> arg.toString()).collect(Collectors.joining(", ")));
		
		return getResultList(clazz, sql, args);
	}
	
	private <T> List<T> getResultList(Class<T> clazz, String sql, Object... args) {
		List<T> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pstm.setObject(i + 1, args[i]);
			}
			
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				T entity = clazz.newInstance();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String name = rsmd.getColumnLabel(i + 1);
					Object value = rs.getObject(i + 1);
					
					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);
					field.set(entity, value);
				}
				result.add(entity);
			}
		} catch (Exception ex) {
			throw new RuntimeException("Exception on executing query");
		} finally {
			JdbcUtils.closeConnection(conn);
			JdbcUtils.closeStatement(pstm);
			JdbcUtils.closeResultSet(rs);
		}
		
		return result;
	}
	
	public Integer executeUpdate(String sql, Object... args) {
		Integer result = null;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = JdbcUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				pstm.setObject(i + 1, args[i]);
			}
			result = pstm.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException("Exception on executing update", ex);
		} finally {
			JdbcUtils.closeStatement(pstm);
			JdbcUtils.closeConnection(conn);
		}
		
		return result;
	}
	
}
