package com.baizhi.zzy.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface BasicDAO<T> {
    void save(T t);
    void update(T t);
    void delete(String id);
    List<T> queryAll();
    T queryById(String id);
    List<T> queryByPage(@Param("pageNow") Integer pageNow,@Param("pageNum") Integer pageNum);
}
