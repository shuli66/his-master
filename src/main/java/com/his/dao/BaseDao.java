package com.his.dao;

import java.sql.*;

public class BaseDao {
    private static final String USER = "root";
    private static final String PWD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/his?useSSL=false&serverTimezone=UTC";
    protected static Connection connection;
    private static Connection con;

    private static BaseDao utils = null;

    private BaseDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized static BaseDao getDBUtil() {
        if (utils == null) {
            utils = new BaseDao();
        }
        return utils;
    }

    public synchronized Connection getConn() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(URL, USER, PWD);
        }
        return con;
    }

    public Statement getStatement() throws SQLException {
        Connection conn = getConn();
        return conn.createStatement();
    }

    public PreparedStatement getPstmt(String sql) throws SQLException {
        Connection conn = getConn();
        return conn.prepareStatement(sql);
    }

    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
