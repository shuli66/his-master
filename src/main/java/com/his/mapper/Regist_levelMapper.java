package com.his.mapper;

import com.his.beam.Employee;
import com.his.beam.dto.EmployeeDto;
import com.his.beam.dto.Regist_level;
import com.his.dao.BaseDao;
import com.his.util.CRUDUtil;
import com.sun.istack.internal.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Regist_levelMapper {
    //查询所有挂号信息
    public List<Regist_level> selectregist() {
        String sql = " select * from regist_level ";
        List<Regist_level> newlist = (List<Regist_level>) CRUDUtil.CRUD(sql, Regist_level.class, null, false, false);
        return newlist;
    }
    //删除
    public boolean delregist(String id) {
        //默认删除失败
        int num = 0;
        String sql = "delete from regist_level where id=?";
        //获取数据库连接

        try {
            BaseDao.getConnection();
            //获取sql语句操作对象
            PreparedStatement ps = BaseDao.connection.prepareStatement(sql);
            //给每个问号赋值，后面这个是对应的参数
            ps.setObject(1, id);
            //执行增删改操作
            num = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果num>0表示删除成功，否则就是删除失败
        return num > 0;
    }
    //编辑信息
    public Regist_level updateselectregist(String id) {
        //默认登录失败
        boolean bl = false;
        String sql = " select * from regist_level  WHERE id=? ";
        List<Object> newlist = new ArrayList<Object>();
        newlist.add(id);
        Regist_level regist = (Regist_level) CRUDUtil.CRUD(sql, Regist_level.class, newlist, false, false);
        return regist;
    }
    //修改
    public boolean updaeregist(Regist_level regist) {
        //默认注册失败
        int num = 0;
        String sql = "update regist_level set regist_code=?,regist_name=?,regist_fee=?,regist_quota=? where id=? ";
        //获取数据库连接

        try {
            BaseDao.getConnection();
            //获取sql语句操作对象
            PreparedStatement ps = BaseDao.connection.prepareStatement(sql);
            //给每个问号赋值，后面这个是对应的参数
            ps.setObject(1, regist.getRegist_code());
            ps.setObject(2, regist.getRegist_name());
            ps.setObject(3, regist.getRegist_fee());
            ps.setObject(4, regist.getRegist_quota());
            ps.setObject(5, regist.getId());
            //执行增删改操作
            num = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果num>0表示修改成功，否则就是修改失败
        return num > 0;
    }
    //条件模糊查询
    public List<Regist_level> likeregistName(String registname) {
        //默认登录失败
        boolean bl = false;
        String sql = " select * from regist_level where regist_name  like '%" + registname + "%'";
        List<Object> list = new ArrayList<Object>();
        list.add(registname);
        List<Regist_level> regist = (List<Regist_level>) CRUDUtil.CRUD(sql, Regist_level.class, null, true, true);
        return regist;
    }
    public boolean addRegist(@NotNull Regist_level regist) {
        int num = 0;
        String sql = " INSERT INTO regist_level (regist_code, regist_name, regist_fee, regist_quota, sequence_no) " +
                " SELECT ?, ?, ?, ?, (SELECT max(sequence_no) + 1 FROM regist_level) ";
        // 获取数据库连接


        try {
            BaseDao.getConnection();
            // 获取 SQL 语句操作对象
            PreparedStatement ps = BaseDao.connection.prepareStatement(sql);
            // 给每个问号赋值，后面这个是对应的参数
            ps.setObject(1, regist.getRegist_code());
            ps.setObject(2, regist.getRegist_name());
            ps.setObject(3, regist.getRegist_fee());
            ps.setObject(4, regist.getRegist_quota());

            // 执行插入操作
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 如果 num > 0 表示插入成功，否则表示插入失败
        return num > 0;
    }



}
