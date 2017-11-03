package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.MenuDAO;
import com.baizhi.zzy.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAll() {
        return menuDAO.queryAll();
    }
}
