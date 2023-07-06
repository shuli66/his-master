package com.his.beam.dto;

import java.math.BigDecimal;

public class Regist_level {
    //私有的整型表的主键
    private  int id;
    //职称编码
    private String regist_code;
    //职称名字
    private String regist_name;
    //挂号费用
    private BigDecimal regist_fee;
    //挂号限额
    private int regist_quota;
    //挂号顺序
    private int sequence_no;


    public Regist_level() {
    }

    public Regist_level(int id, String regist_code, String regist_name, Float regist_fee, int regist_quota, int sequence_no) {
        this.id = id;
        this.regist_code = regist_code;
        this.regist_name = regist_name;
        this.regist_fee = BigDecimal.valueOf(regist_fee);
        this.regist_quota = regist_quota;
        this.sequence_no = sequence_no;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return regist_code
     */
    public String getRegist_code() {
        return regist_code;
    }

    /**
     * 设置
     * @param regist_code
     */
    public void setRegist_code(String regist_code) {
        this.regist_code = regist_code;
    }

    /**
     * 获取
     * @return regist_name
     */
    public String getRegist_name() {
        return regist_name;
    }

    /**
     * 设置
     * @param regist_name
     */
    public void setRegist_name(String regist_name) {
        this.regist_name = regist_name;
    }

    /**
     * 获取
     * @return regist_fee
     */
    public BigDecimal getRegist_fee() {
        return regist_fee;
    }

    /**
     * 设置
     * @param regist_fee
     */
    public void setRegist_fee(Float regist_fee) {
        this.regist_fee = BigDecimal.valueOf(regist_fee);
    }

    /**
     * 获取
     * @return regist_quota
     */
    public int getRegist_quota() {
        return regist_quota;
    }

    /**
     * 设置
     * @param regist_quota
     */
    public void setRegist_quota(int regist_quota) {
        this.regist_quota = regist_quota;
    }

    /**
     * 获取
     * @return sequence_no
     */
    public int getSequence_no() {
        return sequence_no;
    }

    /**
     * 设置
     * @param sequence_no
     */
    public void setSequence_no(int sequence_no) {
        this.sequence_no = sequence_no;
    }

    public String toString() {
        return "regist_level{id = " + id + ", regist_code = " + regist_code + ", regist_name = " + regist_name + ", regist_fee = " + regist_fee + ", regist_quota = " + regist_quota + ", sequence_no = " + sequence_no + "}";
    }
}
