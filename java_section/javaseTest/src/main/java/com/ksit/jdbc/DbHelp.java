package com.ksit.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库协助类
 * 使用第三方组件 dbUtils
 */
public class DbHelp {

    private static Properties properties = new Properties();

    private static QueryRunner queryRunner = new QueryRunner();

    private static String driverClassName = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        /*读取配置文件*/
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(resourceAsStream);
            driverClassName = properties.getProperty("driverClassName");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection returnConnection() {
        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void commonUpdate(String sql, Object... objects) {
        try {
            queryRunner.update(returnConnection(), sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> T commonQuery(String sql, ResultSetHandler<T> resultSetHandler, Object... objects) {
        T t = null;
        try {
            t = queryRunner.query(returnConnection(), sql, resultSetHandler, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

}
