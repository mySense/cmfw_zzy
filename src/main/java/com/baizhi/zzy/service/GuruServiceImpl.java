package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.GuruDAO;
import com.baizhi.zzy.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/29.
 */
@Service("guruService")
@Transactional
public class GuruServiceImpl implements  GuruService {
    @Autowired
    private GuruDAO guruDAO;

    public void save(Guru guru) {
        guru.setId(UUID.randomUUID().toString().replace("-",""));
        guru.setStatus("Y");
        guruDAO.save(guru);
    }

    public void update(Guru guru) {
            guruDAO.update(guru);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> queryAll() {
        return guruDAO.queryAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> queryByPage(Integer pageNow,Integer pageNum) {
        pageNow=(pageNow-1)*pageNum;
        return guruDAO.queryByPage(pageNow,pageNum);
    }
}
