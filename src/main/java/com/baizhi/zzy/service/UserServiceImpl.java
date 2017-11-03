package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.UserDAO;
import com.baizhi.zzy.entity.Echarts;
import com.baizhi.zzy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service("/userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    public void save(User user) {
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setStatus("Y");
        user.setCreateTime(new Date());
        userDAO.save(user);
    }

    public void delete(String id) {
        userDAO.delete(id);
    }

    public void update(User user) {
        userDAO.update(user);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryAll() {
        return userDAO.queryAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow=(pageNow-1)*pageNum;
        return userDAO.queryByPage(pageNow,pageNum);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Echarts> queryCityNum() {
        return userDAO.queryCityNum();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer queryUserNum(Integer num) {
        return userDAO.queryUserNum(num);
    }
}
