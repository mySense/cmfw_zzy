package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.AlbumDAO;
import com.baizhi.zzy.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
     @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> queryAll() {
        return albumDAO.queryAll();
    }

    public void save(Album album) {
            album.setId(UUID.randomUUID().toString().replace("-",""));
            album.setStatus("Y");
            album.setCreateTime(new Date());
            albumDAO.save(album);
    }

    public void update(Album album) {
         albumDAO.update(album);

    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> queryByPage(Integer pageNow,Integer pageNum) {
         pageNow=(pageNow-1)*pageNum;
        System.out.println("this is pageNow"+pageNow);
        System.out.println("this is pageNum"+pageNum);
        return albumDAO.queryByPage(pageNow,pageNum);
    }
}
