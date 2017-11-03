package com.baizhi.zzy.entity;

/**
 * Created by Administrator on 2017/10/29.
 */
public class Guru {
    private String id;
    private String imgPath;
    private String name;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Guru() {
    }

    public Guru(String id, String imgPath, String name, String status) {
        this.id = id;
        this.imgPath = imgPath;
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

