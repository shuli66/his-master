package com.his.mapper;

import com.his.beam.Department;
import com.his.beam.dto.EmployeeDto;
import com.his.util.CRUDUtil;

import java.util.List;

public class DeptMapper {
    //查询所有科室信息，用于加载下拉框
    public List<Department> selectDeptAll(){
        String sql = "select * from department ";
        List<Department> list = (List<Department>) CRUDUtil.CRUD(sql, Department.class, null,false);
        return list;

    }
}
