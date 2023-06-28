package com.his.beam;

public class Employee {
    private int id;
    private String realname;
    private String password;
    private int departmentId;
    private int registLevelId;
    private int schedulingId;
    private boolean delmark;

    // 省略构造方法、getter和setter方法
    public Employee(){}
    // 构造方法
    public Employee(int id, String realname, String password, int departmentId, int registLevelId, int schedulingId, boolean delmark) {
        this.id = id;
        this.realname = realname;
        this.password = password;
        this.departmentId = departmentId;
        this.registLevelId = registLevelId;
        this.schedulingId = schedulingId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRegistLevelId() {
        return registLevelId;
    }

    public void setRegistLevelId(int registLevelId) {
        this.registLevelId = registLevelId;
    }

    public int getSchedulingId() {
        return schedulingId;
    }

    public void setSchedulingId(int schedulingId) {
        this.schedulingId = schedulingId;
    }

    public boolean isDelmark() {
        return delmark;
    }

    public void setDelmark(boolean delmark) {
        this.delmark = delmark;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", departmentId=" + departmentId +
                ", registLevelId=" + registLevelId +
                ", schedulingId=" + schedulingId +
                ", delmark=" + delmark +
                '}';
    }
}


