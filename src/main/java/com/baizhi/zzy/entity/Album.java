package com.baizhi.zzy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Album {
    private String id;
    private String imgPath;
    private String name;
    //集数
    private Integer setCount;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Double score;
    private String author;
    //播音
    private String broadcast;
    //内容简介
    private String brief;
    private String status;
    private List<Chapter> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSetCount() {
        return setCount;
    }

    public void setSetCount(Integer setCount) {
        this.setCount = setCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album() {
    }



    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", name='" + name + '\'' +
                ", setCount=" + setCount +
                ", createTime=" + createTime +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", brief='" + brief + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
