package com.his.beam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

//连接数据库的工具 (尽量用单例模式)

public class BaseDao {
    private static final String USER = "sa";
    private static final String PWD = "123456";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=his";
    private static Statement stmt;
    private static Connection con;

    private static BaseDao utils = null;
    private static PreparedStatement pstmt; // 预编译语句对象

    private BaseDao() {

    }

    // 不是线程安全的 如果有并发访问实例化的时候会出现线程安全的问题，解决办法加同步锁synchronized
    public synchronized static BaseDao getDBUtil() {
        if (utils == null) {
            utils = new BaseDao();
            return utils;
        }
        return utils;
    }

    public static Connection getConn() {
        if (con == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(URL, USER, PWD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static Statement getStatement() {
        if (stmt == null) {
            try {
                if (con == null) {
                    con = getConn();
                }
                stmt = con.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stmt;
    }

    // 预编译语句对象
    public static PreparedStatement getPstmt(String sql) {
        if (pstmt == null) {
            try {
                pstmt = con.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pstmt;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,"sa", "123456");
    }
}
