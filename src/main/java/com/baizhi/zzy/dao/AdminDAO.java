package com.baizhi.zzy.dao;

import com.baizhi.zzy.entity.Admin;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface AdminDAO extends BasicDAO<Admin> {
    Admin queryOne(String username);
}
