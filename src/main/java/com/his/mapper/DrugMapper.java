package com.his.mapper;

import com.his.beam.dto.EmployeeDto;
import com.his.dao.BaseDao;
import com.his.dao.DrugInfo;
import com.his.util.CRUDUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.his.dao.BaseDao.getConnection;

public class DrugMapper {
    public List <DrugInfo>  selectDrug(){
        String sql = "SELECT * FROM drug_info";
        List<DrugInfo> list = (List<DrugInfo>) CRUDUtil.CRUD(sql, DrugInfo.class, null,false,false);
        return list;
    }
    public static boolean delDrug(String id) throws SQLException {

        int num = 0;
        String sql = "DELETE FROM drug_info WHERE id= ?";

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



}
