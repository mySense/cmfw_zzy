package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.RoastDAO;
import com.baizhi.zzy.entity.Roast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/25.
 */
@Service("roastService")
@Transactional
public class RoastServiceImpl implements RoastService {
    @Autowired
    private RoastDAO roastDAO;
    public void save(Roast roast) {
        roast.setId(UUID.randomUUID().toString().replace("-",""));
        roast.setCreateTime(new Date());
        roast.setStatus("Y");
        roastDAO.save(roast);
    }

    public void update(Roast roast) {
            roastDAO.update(roast);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Roast> queryAll() {
        return roastDAO.queryAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Roast> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow=(pageNow-1)*pageNum;
        return roastDAO.queryByPage(pageNow,pageNum);
    }
}
