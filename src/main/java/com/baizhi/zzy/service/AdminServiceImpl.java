package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.AdminDAO;
import com.baizhi.zzy.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Administrator on 2017/10/25.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    public void save(Admin admin) {
        admin.setId(UUID.randomUUID().toString().replace("-",""));
        adminDAO.save(admin);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryOne(String username) {
        return adminDAO.queryOne(username);
    }

    public void update(Admin admin) {
        adminDAO.update(admin);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryById(String id) {
        return adminDAO.queryById(id);
    }
}
