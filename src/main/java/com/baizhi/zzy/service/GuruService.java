package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Guru;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface GuruService {
    @LogAnnotation(description = "插入上师")
    void save(Guru guru);
    @LogAnnotation(description = "修改上师")
    void update(Guru guru);
    List<Guru> queryAll();
    List<Guru> queryByPage(Integer pageNow,Integer pageNum);
}
