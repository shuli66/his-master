package com.his.util;

import com.his.dao.BaseDao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtil {
    public static Object CRUD(String sql, Class clazz, List<Object> list) {
        PreparedStatement ps = null;
        Object object = null;
        try {
            Connection connection = BaseDao.getDBUtil().getConn();  // 获取数据库连接
            ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (list != null) {
                for (int i = 1; i <= list.size(); i++) {
                    ps.setObject(i, list.get(i - 1));
                }
            }
            ResultSet rs = ps.executeQuery();
            object = getBean(rs, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Object getBean(ResultSet rs, Class clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        ResultSetMetaData metaData = rs.getMetaData();
        rs.last();
        int rows = rs.getRow();
        rs.beforeFirst();
        int columnCount = metaData.getColumnCount();
        if (rows > 1) {
            List<Object> list = new ArrayList<>();
            while (rs.next()) {
                Object object = clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getName().equalsIgnoreCase(columnName)) {
                            if (rs.getObject(columnName) != null) {
                                field.set(object, rs.getObject(columnName));
                            }
                        }
                    }
                }
                list.add(object);
            }
            return list;
        } else {
            Object object = clazz.newInstance();
            while (rs.next()) {
                for (int i = 1; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getName().equalsIgnoreCase(columnName)) {
                            if (rs.getObject(columnName) != null) {
                                field.set(object, rs.getObject(columnName));
                            }
                        }
                    }
                }
            }
            return object;
        }
    }
}
