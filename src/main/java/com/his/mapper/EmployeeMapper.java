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

import static com.his.dao.BaseDao.getConnection;

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
            conn = getConnection();
            String sql = "INSERT INTO employee(realname, password, deptment_id, regist_level_id, scheduling_id) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, employee.getRealname());
            pstmt.setString(2, employee.getPassword());
            pstmt.setInt(3, employee.getDeptment_id());
            pstmt.setInt(4, employee.getRegist_level_id());
            pstmt.setInt(5, employee.getScheduling_id());


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

//删除
    public static boolean delUser(String id) throws SQLException {

        int num = 0;
        String sql = "DELETE FROM employee WHERE id= ?";

        getConnection();
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
    public Employee updateSelectUser(String id){
        boolean bl = false;
        String sql = "select * from employee where id = ? ";
        List<Object>list = new ArrayList<>();
        list.add(id);
        Employee employee = (Employee) CRUDUtil.CRUD(sql, Employee.class, list,true);
        return employee;
    }

    public  boolean updateEmployee(Employee employee) {

        int num = 0;
        String sql = "update employee set realname=?,password=?,deptment_id=? ";
        if (employee.getRegist_level_id()>0){
            sql += ",regist_level_id=" + employee.getRegist_level_id();
        }
        if (employee.getScheduling_id()>0){
            sql += ",scheduling_id=" + employee.getScheduling_id();
        }
        sql +=" where id="+ employee.getId();
        try {
            BaseDao.getConnection();
            PreparedStatement pstmt = BaseDao.connection.prepareStatement(sql);

            pstmt.setObject(1, employee.getRealname());
            pstmt.setObject(2, employee.getPassword());
            pstmt.setObject(3, employee.getDeptment_id());
            num = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num>0;
    }

}
