package com.yys.szcp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 产品信息表
 * @TableName machine_product
 */
@TableName(value ="machine_product")
public class MachineProduct implements Serializable {
    /**
     * 产品ID
     */
    @TableId
    private String productId;

    /**
     * 批次ID
     */
    private String goodsId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 扩展字段1
     */
    private String expent1;

    /**
     * 扩展字段2
     */
    private String expent2;

    /**
     * 扩展字段3
     */
    private String expent3;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 产品ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 批次ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 批次ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 扩展字段1
     */
    public String getExpent1() {
        return expent1;
    }

    /**
     * 扩展字段1
     */
    public void setExpent1(String expent1) {
        this.expent1 = expent1;
    }

    /**
     * 扩展字段2
     */
    public String getExpent2() {
        return expent2;
    }

    /**
     * 扩展字段2
     */
    public void setExpent2(String expent2) {
        this.expent2 = expent2;
    }

    /**
     * 扩展字段3
     */
    public String getExpent3() {
        return expent3;
    }

    /**
     * 扩展字段3
     */
    public void setExpent3(String expent3) {
        this.expent3 = expent3;
    }
}