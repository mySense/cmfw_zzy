package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Roast;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface RoastService {
    @LogAnnotation(description = "插入轮播图")
    void save(Roast roast);
    @LogAnnotation(description = "修改轮播图")
    void update(Roast roast);
    List<Roast> queryAll();
    List<Roast> queryByPage(Integer pageNow,Integer pageNum);
}
