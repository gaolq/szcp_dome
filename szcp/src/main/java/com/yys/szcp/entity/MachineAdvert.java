package com.yys.szcp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告信息表
 * @TableName machine_advert
 */
@TableName(value ="machine_advert")
public class MachineAdvert implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private String advertId;

    /**
     * 广告下载URL
     */
    private String loadUrl;

    /**
     * 开始播放时间
     */
    private Date startTime;

    /**
     * 结束播放时间
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private String createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public String getAdvertId() {
        return advertId;
    }

    /**
     * 主键ID
     */
    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    /**
     * 广告下载URL
     */
    public String getLoadUrl() {
        return loadUrl;
    }

    /**
     * 广告下载URL
     */
    public void setLoadUrl(String loadUrl) {
        this.loadUrl = loadUrl;
    }

    /**
     * 开始播放时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始播放时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束播放时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束播放时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}