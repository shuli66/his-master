package com.his.beam;

/**
 * 科室类
 */
public class Department {
    //私有的整型表的主键
    private int id;
    //字符串类型，科室编码
    private String dept_code;
    //科室名称
    private String dept_name;
    //科室类型
    private String dept_type;
    //生效标记
    private int delmark;


    public Department() {
    }

    public Department(int id, String dept_code, String dept_name, String dept_type, int delmark) {
        this.id = id;
        this.dept_code = dept_code;
        this.dept_name = dept_name;
        this.dept_type = dept_type;
        this.delmark = delmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_type() {
        return dept_type;
    }

    public void setDept_type(String dept_type) {
        this.dept_type = dept_type;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }
}
