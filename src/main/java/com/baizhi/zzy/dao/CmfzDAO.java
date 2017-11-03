package com.baizhi.zzy.dao;

import com.baizhi.zzy.entity.Album;
import com.baizhi.zzy.entity.Article;
import com.baizhi.zzy.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */
public interface CmfzDAO {
    List<Album> findAllAlbum();
    List<RoastDAO> findAllRoast();
    List<Article> findAllArticle();
    void addUser(User user);
}
