package com.baizhi.zzy.dao;

import com.baizhi.zzy.entity.Echarts;
import com.baizhi.zzy.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface UserDAO extends BasicDAO<User> {
        List<Echarts> queryCityNum();
        Integer queryUserNum(Integer num);
}
