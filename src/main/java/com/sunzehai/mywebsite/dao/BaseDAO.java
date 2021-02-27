package com.sunzehai.mywebsite.dao;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseDAO <T> {

    private Logger logger = LoggerFactory.getLogger(BaseDAO.class);

    private Class<T> clazz;

    private QueryRunner queryRunner = new QueryRunner();

    private Path sqlFilePath = Paths.get(this.getClass().getClassLoader().getResource("sql").getPath());

    public BaseDAO() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }

    public T getResult(Connection conn, SqlFileCons sqlFileCons, Object... params) {
        T result;

        String sql = getSql(sqlFileCons);
        ResultSetHandler<T> handler = new BeanHandler(clazz);

        try {
            result = queryRunner.query(conn, sql, handler, params);
        } catch (SQLException e) {
            throw new RuntimeException("Unexpected exception on querying.", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }

        return result;
    }

    public List<T> getResultList(Connection conn, SqlFileCons sqlFileCons, Object... params) {
        List<T> result;

        String sql = getSql(sqlFileCons);
        ResultSetHandler<List<T>> handler = new BeanListHandler(clazz);

        try {
            result = queryRunner.query(conn, sql, handler, params);
        } catch (SQLException e) {
            throw new RuntimeException("Unexpected exception on querying.", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }

        return result;
    }

    public <E> E getValue(Connection conn, SqlFileCons sqlFileCons, Object... params) {
        E result;

        String sql = getSql(sqlFileCons);
        ResultSetHandler<E> handler = new ScalarHandler();

        try {
            result = queryRunner.query(conn, sql, handler, params);
        } catch (SQLException e) {
            throw new RuntimeException("Unexpected exception on querying.", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }

        return result;
    }

    public int update(Connection conn, SqlFileCons sqlFileCons, Object... params) {
        int result;

        String sql = getSql(sqlFileCons);

        try {
            result = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException("Unexpected exception on updating.", e);
        }

        return result;
    }

    private String getSql(SqlFileCons sqlFileCons) {
        String result;

        Path path = sqlFilePath.resolve(String.format("%s.sql", sqlFileCons.name()));
        try {
            result = Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException("Unexpected exception on reading sql file", e);
        }

        return result;
    }

}
