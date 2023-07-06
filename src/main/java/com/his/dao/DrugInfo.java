package com.his.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrugInfo {
    // 主键，自增长类型
    private int id;

    // 药品编码
    private String drug_code;

    // 药品名称
    private String drug_name;

    // 药品规格
    private String drug_format;

    // 包装单位
    private String drug_unit;

    // 生产厂家
    private String manufacturer;

    // 药剂类型
    private String drug_dosage;

    // 药品类型
    private String drug_type;

    // 药品单价
    private BigDecimal drug_price;

    // 拼音助记码
    private String mnemonic_code;

    // 创建时间
    private Date creation_date;


    public DrugInfo() {
    }

    public DrugInfo(int id, String drug_code, String drug_name, String drug_format, String drug_unit, String manufacturer, String drug_dosage, String drug_type, BigDecimal drug_price, String mnemonic_code, Date creation_date) {
        this.id = id;
        this.drug_code = drug_code;
        this.drug_name = drug_name;
        this.drug_format = drug_format;
        this.drug_unit = drug_unit;
        this.manufacturer = manufacturer;
        this.drug_dosage = drug_dosage;
        this.drug_type = drug_type;
        this.drug_price = drug_price;
        this.mnemonic_code = mnemonic_code;
        this.creation_date = creation_date;
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
     * @return drug_code
     */
    public String getDrug_code() {
        return drug_code;
    }

    /**
     * 设置
     * @param drug_code
     */
    public void setDrug_code(String drug_code) {
        this.drug_code = drug_code;
    }

    /**
     * 获取
     * @return drug_name
     */
    public String getDrug_name() {
        return drug_name;
    }

    /**
     * 设置
     * @param drug_name
     */
    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    /**
     * 获取
     * @return drug_format
     */
    public String getDrug_format() {
        return drug_format;
    }

    /**
     * 设置
     * @param drug_format
     */
    public void setDrug_format(String drug_format) {
        this.drug_format = drug_format;
    }

    /**
     * 获取
     * @return drug_unit
     */
    public String getDrug_unit() {
        return drug_unit;
    }

    /**
     * 设置
     * @param drug_unit
     */
    public void setDrug_unit(String drug_unit) {
        this.drug_unit = drug_unit;
    }

    /**
     * 获取
     * @return manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 设置
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * 获取
     * @return drug_dosage
     */
    public String getDrug_dosage() {
        return drug_dosage;
    }

    /**
     * 设置
     * @param drug_dosage
     */
    public void setDrug_dosage(String drug_dosage) {
        this.drug_dosage = drug_dosage;
    }

    /**
     * 获取
     * @return drug_type
     */
    public String getDrug_type() {
        return drug_type;
    }

    /**
     * 设置
     * @param drug_type
     */
    public void setDrug_type(String drug_type) {
        this.drug_type = drug_type;
    }

    /**
     * 获取
     * @return drug_price
     */
    public BigDecimal getDrug_price() {
        return drug_price;
    }

    /**
     * 设置
     * @param drug_price
     */
    public void setDrug_price(BigDecimal drug_price) {
        this.drug_price = drug_price;
    }

    /**
     * 获取
     * @return mnemonic_code
     */
    public String getMnemonic_code() {
        return mnemonic_code;
    }

    /**
     * 设置
     * @param mnemonic_code
     */
    public void setMnemonic_code(String mnemonic_code) {
        this.mnemonic_code = mnemonic_code;
    }

    /**
     * 获取
     * @return creation_date
     */
    public Date getCreation_date() {
        return creation_date;
    }

    /**
     * 设置
     * @param creation_date
     */
    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String toString() {
        return "DrugInfo{id = " + id + ", drug_code = " + drug_code + ", drug_name = " + drug_name + ", drug_format = " + drug_format + ", drug_unit = " + drug_unit + ", manufacturer = " + manufacturer + ", drug_dosage = " + drug_dosage + ", drug_type = " + drug_type + ", drug_price = " + drug_price + ", mnemonic_code = " + mnemonic_code + ", creation_date = " + creation_date + "}";
    }

}