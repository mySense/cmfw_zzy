package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface LogService {
    void save(Log log);
    List<Log> queryAll();
    List<Log> queryByPage(Integer pageNow,Integer pageNum);
}
