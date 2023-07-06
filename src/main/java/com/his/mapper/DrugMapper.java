package com.his.mapper;

import com.his.dao.BaseDao;
import com.his.dao.DrugInfo;
import com.his.util.CRUDUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.his.dao.BaseDao.getConnection;

public class DrugMapper {
    //药品清单
    public List <DrugInfo>  selectDrug(){
        String sql = "SELECT * FROM drug_info";
        List<DrugInfo> list = (List<DrugInfo>) CRUDUtil.CRUD(sql, DrugInfo.class, null,false,false);
        return list;
    }
    //删除药品信息操作
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

    public DrugInfo updateSelectDrug(String id) {
        DrugInfo drugInfo = null;
        String sql = "SELECT * FROM drug_info WHERE id = ?";

        try {
            getConnection();
            PreparedStatement pstmt = BaseDao.connection.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                drugInfo = new DrugInfo();
                drugInfo.setId(rs.getInt("id"));
                drugInfo.setDrug_code(rs.getString("drug_code"));
                drugInfo.setDrug_name(rs.getString("drug_name"));
                drugInfo.setDrug_format(rs.getString("drug_format"));
                drugInfo.setDrug_unit(rs.getString("drug_unit"));
                drugInfo.setManufacturer(rs.getString("manufacturer"));
                drugInfo.setDrug_dosage(rs.getString("drug_dosage"));
                drugInfo.setDrug_type(rs.getString("drug_type"));

                drugInfo.setMnemonic_code(rs.getString("mnemonic_code"));
                drugInfo.setDrug_price(rs.getBigDecimal("drug_price"));

                java.sql.Date sqlDate = rs.getDate("creation_date");
                java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                drugInfo.setCreation_date(utilDate);

            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugInfo;
    }

    public boolean updateDrug(DrugInfo drugInfo) {
        String sql = "UPDATE drug_info SET drug_code = ?, drug_name = ?, drug_format = ?, drug_unit = ?, manufacturer = ?, drug_dosage = ?, drug_type = ?, drug_price = ?, mnemonic_code = ?, creation_date = ? WHERE id = ?";

        try {
            getConnection();
            PreparedStatement pstmt = BaseDao.connection.prepareStatement(sql);
            pstmt.setString(1, drugInfo.getDrug_code());
            pstmt.setString(2, drugInfo.getDrug_name());
            pstmt.setString(3, drugInfo.getDrug_format());
            pstmt.setString(4, drugInfo.getDrug_unit());
            pstmt.setString(5, drugInfo.getManufacturer());
            pstmt.setString(6, drugInfo.getDrug_dosage());
            pstmt.setString(7, drugInfo.getDrug_type());
            pstmt.setBigDecimal(8, drugInfo.getDrug_price());
            pstmt.setString(9, drugInfo.getMnemonic_code());
            pstmt.setDate(10, new java.sql.Date(drugInfo.getCreation_date().getTime()));
            // Skip id parameter
            pstmt.setInt(11, drugInfo.getId());

            int num = pstmt.executeUpdate();

            pstmt.close();

            return num > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    //模糊查询
    public List<DrugInfo> likeDrugName(String drug_name) {
        String sql = "SELECT * FROM drug_info WHERE drug_name LIKE '%"+ drug_name+"%'";
        List<Object> list = new ArrayList<Object>();
        List<DrugInfo> drugInfoList = (List<DrugInfo>) CRUDUtil.CRUD(sql, DrugInfo.class, list, false, true);
        return drugInfoList;
    }


    //添加药品
    public static boolean registerDrug(DrugInfo drugInfo) {
        String sql = "INSERT INTO drug_info (drug_code, drug_name, drug_format, drug_unit, manufacturer, drug_dosage, drug_type, drug_price, mnemonic_code, creation_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            getConnection();
            PreparedStatement pstmt = BaseDao.connection.prepareStatement(sql);
            pstmt.setString(1, drugInfo.getDrug_code());
            pstmt.setString(2, drugInfo.getDrug_name());
            pstmt.setString(3, drugInfo.getDrug_format());
            pstmt.setString(4, drugInfo.getDrug_unit());
            pstmt.setString(5, drugInfo.getManufacturer());
            pstmt.setString(6, drugInfo.getDrug_dosage());
            pstmt.setString(7, drugInfo.getDrug_type());
            pstmt.setBigDecimal(8, drugInfo.getDrug_price());
            pstmt.setString(9, drugInfo.getMnemonic_code());
            pstmt.setDate(10, new java.sql.Date(drugInfo.getCreation_date().getTime()));

            int num = pstmt.executeUpdate();
            return num > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




}
