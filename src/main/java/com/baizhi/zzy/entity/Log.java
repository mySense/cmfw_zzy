package com.baizhi.zzy.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
public class Log {
    private String id;
    private String name;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String doSomeThing;
    private String status;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDoSomeThing() {
        return doSomeThing;
    }

    public void setDoSomeThing(String doSomeThing) {
        this.doSomeThing = doSomeThing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Log() {
    }

    public Log(String id, String name, Date date, String doSomeThing, String status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.doSomeThing = doSomeThing;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", doSomeThing='" + doSomeThing + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
