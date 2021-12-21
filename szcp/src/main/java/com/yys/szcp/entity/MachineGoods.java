package com.yys.szcp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 货物批次信息
 * @TableName machine_goods
 */
public class MachineGoods implements Serializable {
    /**
     * 存货批次ID
     */
    private String goodsId;

    /**
     * 设备ID
     */
    private String equipId;

    /**
     * 设备区域
     */
    private String equipUnit;

    /**
     * 格子数量
     */
    private Integer squareSize;

    /**
     * 格子位置
     */
    private Integer squarePosition;

    /**
     * 加货时间
     */
    private Date createTime;

    /**
     * 批次描述
     */
    private String goodsDesc;

    private static final long serialVersionUID = 1L;

    /**
     * 存货批次ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 存货批次ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 设备ID
     */
    public String getEquipId() {
        return equipId;
    }

    /**
     * 设备ID
     */
    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    /**
     * 设备区域
     */
    public String getEquipUnit() {
        return equipUnit;
    }

    /**
     * 设备区域
     */
    public void setEquipUnit(String equipUnit) {
        this.equipUnit = equipUnit;
    }

    /**
     * 格子数量
     */
    public Integer getSquareSize() {
        return squareSize;
    }

    /**
     * 格子数量
     */
    public void setSquareSize(Integer squareSize) {
        this.squareSize = squareSize;
    }

    /**
     * 格子位置
     */
    public Integer getSquarePosition() {
        return squarePosition;
    }

    /**
     * 格子位置
     */
    public void setSquarePosition(Integer squarePosition) {
        this.squarePosition = squarePosition;
    }

    /**
     * 加货时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 加货时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 批次描述
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * 批次描述
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}