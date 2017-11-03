package com.baizhi.zzy.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public class User {
    private String id;
    private String name;
    private String fname;
    private String phone;
    private String password;
    private String sex;
    //所在地
    private String location;
    private String city;
    private String province;
    private String photo;
    //个人签名
    private String description;
    private String status;
    private Date createTime;
    private Guru guru;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public User() {
    }

    public User(String id, String name, String fname, String phone, String password, String sex, String location, String city, String province, String photo, String description, String status, Date createTime, Guru guru) {
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
        this.location = location;
        this.city = city;
        this.province = province;
        this.photo = photo;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
