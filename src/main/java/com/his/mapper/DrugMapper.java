package com.his.mapper;

import com.his.dao.DrugInfo;
import com.his.util.CRUDUtil;

import java.util.List;

public class DrugMapper {
    public List <DrugInfo>  selectDrug(){
        String sql = "SELECT * FROM drug_info";
        List<DrugInfo> list = (List<DrugInfo>) CRUDUtil.CRUD(sql, DrugInfo.class, null,false);
        return list;
    }
}
