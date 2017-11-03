package com.baizhi.zzy.service;

import com.baizhi.zzy.entity.Echarts;
import com.baizhi.zzy.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface UserService {
    void save(User user);
    void delete(String id);
    void update(User user);
    List<User> queryAll();
    List<User> queryByPage(Integer pageNow,Integer pageNum);
    List<Echarts> queryCityNum();
    Integer queryUserNum(Integer num);
}
