package com.yys.szcp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户信息表
 * @TableName machine_customer
 */
public class MachineCustomer implements Serializable {
    /**
     * 客户ID
     */
    private String customerId;

    /**
     * 账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 客户类型
     */
    private String customerType;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 归属区域
     */
    private String customerSite;

    /**
     * 手机号
     */
    private Integer telPhone;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 客户ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 账号
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 客户类型
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * 客户类型
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * 客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户姓名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 归属区域
     */
    public String getCustomerSite() {
        return customerSite;
    }

    /**
     * 归属区域
     */
    public void setCustomerSite(String customerSite) {
        this.customerSite = customerSite;
    }

    /**
     * 手机号
     */
    public Integer getTelPhone() {
        return telPhone;
    }

    /**
     * 手机号
     */
    public void setTelPhone(Integer telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}