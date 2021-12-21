package com.yys.szcp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 设备版本信息
 * @TableName machine_version
 */
@TableName(value ="machine_version")
public class MachineVersion implements Serializable {
    /**
     * 版本ID
     */
    @TableId(type = IdType.AUTO)
    private Integer versionId;

    /**
     * 设备ID
     */
    private String equipId;

    /**
     * 版本编号
     */
    private String versionNumber;

    /**
     * 下载地址
     */
    private String equipUrl;

    /**
     * 版本状态（0:历史版本，1:运行版本）
     */
    private Integer versionState;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 版本ID
     */
    public Integer getVersionId() {
        return versionId;
    }

    /**
     * 版本ID
     */
    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
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
     * 版本编号
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * 版本编号
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * 下载地址
     */
    public String getEquipUrl() {
        return equipUrl;
    }

    /**
     * 下载地址
     */
    public void setEquipUrl(String equipUrl) {
        this.equipUrl = equipUrl;
    }

    /**
     * 版本状态（0:历史版本，1:运行版本）
     */
    public Integer getVersionState() {
        return versionState;
    }

    /**
     * 版本状态（0:历史版本，1:运行版本）
     */
    public void setVersionState(Integer versionState) {
        this.versionState = versionState;
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