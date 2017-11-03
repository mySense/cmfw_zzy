package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface AlbumService {
    List<Album> queryAll();
    @LogAnnotation(description = "插入专辑")
    void save(Album album);
    @LogAnnotation(description = "修改专辑")
    void update(Album album);
    List<Album> queryByPage(Integer pageNow,Integer pageNum);
}
