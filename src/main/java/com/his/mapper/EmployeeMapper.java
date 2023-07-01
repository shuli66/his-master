package com.his.mapper;

import com.his.beam.Employee;
import com.his.dao.BaseDao;
import com.his.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public  Employee login(String realname, String password) {

        String sql = "SELECT * FROM employee WHERE realname=? AND password=?";
            List<Object> list = new ArrayList<Object>();
            list.add(realname);
            list.add(password);
        Employee employee = (Employee) CRUDUtil.CRUD(sql, Employee.class, list);
        return employee; // 返回注册结果

        }


    public static boolean registerEmployee(Employee employee) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean registrationSuccessful = false;

        try {
            BaseDao baseDao = BaseDao.getDBUtil();
            conn = baseDao.getConn();
            String sql = "INSERT INTO employee(realname, password, deptment_id, regist_level_id, scheduling_id) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, employee.getRealname());
            pstmt.setString(2, employee.getPassword());
            pstmt.setInt(3, employee.getDepartmentId());
            pstmt.setInt(4, employee.getRegistLevelId());
            pstmt.setInt(5, employee.getSchedulingId());

            System.out.println("执行的SQL语句：" + pstmt.toString());

            int rowsAffected = pstmt.executeUpdate();

            registrationSuccessful = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库资源
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

        return registrationSuccessful; // 返回注册结果
    }
}
