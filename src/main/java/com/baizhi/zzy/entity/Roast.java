package com.baizhi.zzy.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/25.
 */
public class Roast {
    private String id;
    private String alt;
    private String imgPath;
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Roast() {
    }

    public Roast(String id, String alt, String imgPath, String status, Date createTime) {
        this.id = id;
        this.alt = alt;
        this.imgPath = imgPath;
        this.status = status;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Roast{" +
                "id='" + id + '\'' +
                ", alt='" + alt + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
