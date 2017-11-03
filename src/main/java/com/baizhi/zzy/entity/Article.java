package com.baizhi.zzy.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/29.
 */
public class Article {
    private String id;
    private String name;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String href;
    private String ext;
    private String status;
    private String content;
    private String imgPath;
    private Guru guru=new Guru();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public Article() {
    }

    public Article(String id, String name, Date createTime, String href, String ext, String status, String content, String imgPath, Guru guru) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.href = href;
        this.ext = ext;
        this.status = status;
        this.content = content;
        this.imgPath = imgPath;
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", href='" + href + '\'' +
                ", ext='" + ext + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
