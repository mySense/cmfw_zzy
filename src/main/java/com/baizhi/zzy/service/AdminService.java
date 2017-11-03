package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Admin;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface AdminService {
    void save(Admin admin);
    Admin queryOne(String username);
    void update(Admin admin);
    Admin queryById(String id);
}
