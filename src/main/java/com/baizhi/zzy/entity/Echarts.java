package com.baizhi.zzy.entity;

/**
 * Created by Administrator on 2017/10/31.
 */
public class Echarts {
    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Echarts() {
    }

    public Echarts(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Echarts{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
