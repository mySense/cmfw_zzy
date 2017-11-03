package com.baizhi.zzy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Body {
    private String thumbnail;
    private String title;
    private String author;
    private String type;
    private Integer setCount;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Body() {
    }

    public Body(String thumbnail, String title, String author, String type, Integer setCount, Date createTime) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.author = author;
        this.type = type;
        this.setCount = setCount;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Body{" +
                "thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", setCount=" + setCount +
                ", createTime=" + createTime +
                '}';
    }
}
