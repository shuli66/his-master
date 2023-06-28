package com.his.mapper;

import com.his.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {
    public static boolean login(String realname, String password) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginSuccessful =false;

        try {
            BaseDao baseDao = BaseDao.getDBUtil();
            conn = baseDao.getConn();
            String sql = "SELECT * FROM employee WHERE realname=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, realname);
            pstmt.setString(2, password);
            System.out.println("执行的SQL语句：" + pstmt.toString());

            rs = pstmt.executeQuery();

            loginSuccessful = rs.next(); // 如果查询到结果则设置登录成功标记为true，否则为false
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return loginSuccessful; // 返回登录结果
    }
}
