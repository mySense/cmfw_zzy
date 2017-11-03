package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.LogDAO;
import com.baizhi.zzy.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;

    public void save(Log log) {
        log.setId(UUID.randomUUID().toString().replace("-",""));
        logDAO.save(log);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Log> queryAll() {
        return logDAO.queryAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Log> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow=(pageNow-1)*pageNum;
        return logDAO.queryByPage(pageNow,pageNum);
    }
}
