package com.his.beam.dto;

import com.his.beam.Employee;

public class EmployeeDto extends Employee {
    private int id;
    private String realname;
    //科室
    private String dept_name;
    //挂号级别名称
    private String regist_name;
    //排班信息
    private String rule_name;

    public EmployeeDto() {
        // 无参构造函数的实现
    }


    public EmployeeDto(String dept_name, String regist_name, String rule_name) {
        this.dept_name = dept_name;
        this.regist_name = regist_name;
        this.rule_name = rule_name;
    }

    public EmployeeDto(int id, String realname, String password, int deptment_id, int regist_level_id, int scheduling_id, int delmark, String dept_name, String regist_name, String rule_name) {
        super(id, realname, password, deptment_id, regist_level_id, scheduling_id, delmark);
        this.dept_name = dept_name;
        this.regist_name = regist_name;
        this.rule_name = rule_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getRegist_name() {
        return regist_name;
    }

    public void setRegist_name(String regist_name) {
        this.regist_name = regist_name;
    }

    public String getRule_name() {
        return rule_name;
    }

    public void setRule_name(String rule_name) {
        this.rule_name = rule_name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getRealname() {
        return realname;
    }

    @Override
    public void setRealname(String realname) {
        this.realname = realname;
    }
}
