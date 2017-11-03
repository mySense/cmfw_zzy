package com.baizhi.zzy.service;


import com.baizhi.zzy.entity.User;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */
public interface CmfzService {
    Map<String,Object> showAfter(String id,String type,String sub_type);
    void addUser(User user);
}
