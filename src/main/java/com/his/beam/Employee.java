package com.his.beam;

public class Employee {
    protected int id;
    protected String realname;
    private String password;
    private int deptment_id;
    private int regist_level_id;
    private int scheduling_id;
    private int delmark;

    // 省略构造方法、getter和setter方法
    public Employee() {
    }

    // 构造方法
    public Employee(int id, String realname, String password, int deptment_id, int regist_level_id, int scheduling_id, int delmark) {
        this.id = id;
        this.realname = realname;
        this.password = password;
        this.deptment_id = deptment_id;
        this.regist_level_id = regist_level_id;
        this.scheduling_id = scheduling_id;
        this.delmark = delmark;
    }

    // Getter和Setter方法


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeptment_id() {
        return deptment_id;
    }

    public void setDeptment_id(int deptment_id) {
        this.deptment_id = deptment_id;
    }

    public int getRegist_level_id() {
        return regist_level_id;
    }

    public void setRegist_level_id(int regist_level_id) {
        this.regist_level_id = regist_level_id;
    }

    public int getScheduling_id() {
        return scheduling_id;
    }

    public void setScheduling_id(int scheduling_id) {
        this.scheduling_id = scheduling_id;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", deptment_id=" + deptment_id +
                ", regist_level_id=" + regist_level_id +
                ", scheduling_id=" + scheduling_id +
                ", delmark=" + delmark +
                '}';
    }
}


