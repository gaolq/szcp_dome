package com.yys.szcp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备信息
 * @TableName machine_equipment
 */
public class MachineEquipment implements Serializable {
    /**
     * 设备编号
     */
    @ApiModelProperty(value = "设备编号",required = true,hidden = true)
    private String equipId;

    /**
     * Mac地址
     */
    @ApiModelProperty(value = "Mac地址",required = true)
    private String macAddress;

    /**
     * 设备状态（0:关闭，1:运行）
     */
    @ApiModelProperty(value = "设备状态（0:关闭，1:运行）",required = true)
    private Integer equipStatus;

    /**
     * 关机时间
     */
    @ApiModelProperty(value = "关机时间（0点～0点）",required = true)
    private Integer offTime;

    /**
     * 开机时间
     */
    @ApiModelProperty(value = "开机时间（0点～0点）",required = true)
    private Integer onTime;

    /**
     * 广告音量
     */
    @ApiModelProperty(value = "广告音量（0～100）",required = true)
    private Integer volumeSize;

    /**
     * 设备亮度
     */
    @ApiModelProperty(value = "设备亮度（0～100）",required = true)
    private Integer brightLimit;

    /**
     * 温度限制
     */
    @ApiModelProperty(value = "温度限制（0～100）",required = true)
    private Integer temperatureLimit;

    /**
     * 绑定客户ID
     */
    @ApiModelProperty(value = "绑定客户ID",required = true)
    private String customerId;

    /**
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型（0：代理商，1:直营产品）",required = true)
    private Integer equipType;

    /**
     * 激活时间
     */
    @ApiModelProperty(value = "激活时间",required = false,hidden = true)
    private Date activeTime;

    /**
     * 绑定时间
     */
    @ApiModelProperty(value = "绑定时间",required = false,hidden = true)
    private Date bindTime;

    private static final long serialVersionUID = 1L;

    /**
     * 设备编号
     */
    public String getEquipId() {
        return equipId;
    }

    /**
     * 设备编号
     */
    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    /**
     * Mac地址
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Mac地址
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * 设备状态（0:关闭，1:运行）
     */
    public Integer getEquipStatus() {
        return equipStatus;
    }

    /**
     * 设备状态（0:关闭，1:运行）
     */
    public void setEquipStatus(Integer equipStatus) {
        this.equipStatus = equipStatus;
    }

    /**
     * 关机时间
     */
    public Integer getOffTime() {
        return offTime;
    }

    /**
     * 关机时间
     */
    public void setOffTime(Integer offTime) {
        this.offTime = offTime;
    }

    /**
     * 开机时间
     */
    public Integer getOnTime() {
        return onTime;
    }

    /**
     * 开机时间
     */
    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    /**
     * 广告音量
     */
    public Integer getVolumeSize() {
        return volumeSize;
    }

    /**
     * 广告音量
     */
    public void setVolumeSize(Integer volumeSize) {
        this.volumeSize = volumeSize;
    }

    /**
     * 设备亮度
     */
    public Integer getBrightLimit() {
        return brightLimit;
    }

    /**
     * 设备亮度
     */
    public void setBrightLimit(Integer brightLimit) {
        this.brightLimit = brightLimit;
    }

    /**
     * 温度限制
     */
    public Integer getTemperatureLimit() {
        return temperatureLimit;
    }

    /**
     * 温度限制
     */
    public void setTemperatureLimit(Integer temperatureLimit) {
        this.temperatureLimit = temperatureLimit;
    }

    /**
     * 绑定客户ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 绑定客户ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 设备类型
     */
    public Integer getEquipType() {
        return equipType;
    }

    /**
     * 设备类型
     */
    public void setEquipType(Integer equipType) {
        this.equipType = equipType;
    }

    /**
     * 激活时间
     */
    public Date getActiveTime() {
        return activeTime;
    }

    /**
     * 激活时间
     */
    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    /**
     * 绑定时间
     */
    public Date getBindTime() {
        return bindTime;
    }

    /**
     * 绑定时间
     */
    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }
}