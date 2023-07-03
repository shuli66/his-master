package com.his.mapper;

import com.his.beam.Employee;
import com.his.beam.dto.EmployeeDto;
import com.his.dao.BaseDao;
import com.his.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    public  EmployeeDto login(String realname, String password) {
        String sql = "SELECT e.id, e.realname, e.deptment_id, e.regist_level_id, e.scheduling_id, d.dept_name, r.regist_name, s.rule_name " +
                "FROM employee e " +
                "LEFT JOIN department d ON e.deptment_id = d.id " +
                "LEFT JOIN regist_level r ON e.regist_level_id = r.id " +
                "LEFT JOIN scheduling s ON e.scheduling_id = s.id " +
                "WHERE realname=? AND password=?";

        List<Object> list = new ArrayList<Object>();
            list.add(realname);
            list.add(password);
        EmployeeDto employee = (EmployeeDto) CRUDUtil.CRUD(sql, EmployeeDto.class, list,true);
        return employee; //

        }


    public static boolean registerEmployee(Employee employee) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean registrationSuccessful = false;

        try {
            conn = BaseDao.getConnection();
            String sql = "INSERT INTO employee(realname, password, deptment_id, regist_level_id, scheduling_id) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, employee.getRealname());
            pstmt.setString(2, employee.getPassword());
            pstmt.setInt(3, employee.getDeptment_id());
            pstmt.setInt(4, employee.getRegist_level_id());
            pstmt.setInt(5, employee.getScheduling_id());

            System.out.println("执行的SQL语句：" + pstmt);

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

    //查询所有医生信息
    public  List<EmployeeDto> selectAll() {
        String sql = "SELECT e.id, e.realname, e.deptment_id, e.regist_level_id, e.scheduling_id, d.dept_name, r.regist_name, s.rule_name\n" +
                " FROM employee e " +
                " LEFT JOIN department d ON e.deptment_id = d.id " +
                " LEFT JOIN regist_level r ON e.regist_level_id = r.id " +
                " LEFT JOIN scheduling s ON e.scheduling_id = s.id; ";
        List<EmployeeDto> list = (List<EmployeeDto>)CRUDUtil.CRUD(sql, EmployeeDto.class, null,true);
        return list;

    }


    public static boolean delUser(String id) throws SQLException {

        int num = 0;
        String sql = "DELETE FROM employee WHERE id= ?";

        BaseDao.getConnection();
        try {
            PreparedStatement pstmt = BaseDao.connection.prepareStatement(sql);
            pstmt.setObject(1, id);

            num = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果num大于0删除成功，num=0 删除失败
        return num>0;
    }


}
