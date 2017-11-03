package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.CmfzDAO;
import com.baizhi.zzy.dao.RoastDAO;
import com.baizhi.zzy.entity.Album;
import com.baizhi.zzy.entity.Article;
import com.baizhi.zzy.entity.Body;
import com.baizhi.zzy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2017/11/2.
 */
@Service("cmfzService")
@Transactional
public class CmfzServiceImpl implements CmfzService {
    @Autowired
    private CmfzDAO cmfzDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String,Object> showAfter(String id,String type,String sub_type){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Body> list=new ArrayList<Body>();
        if(type.equals("all")){
            List<RoastDAO> roasts = cmfzDAO.findAllRoast();

            List<Album> albums = cmfzDAO.findAllAlbum();
            for (Album album : albums) {
                Body body = new Body(album.getImgPath(), album.getName(), album.getAuthor(), "0", album.getSetCount(), album.getCreateTime());
                list.add(body);
            }
            List<Article> articles = cmfzDAO.findAllArticle();
            for (Article article : articles) {
                Body b = new Body();
                b.setThumbnail(article.getImgPath());
                b.setAuthor(article.getGuru().getName());
                b.setTitle(article.getName());
                b.setCreateTime(article.getCreateTime());
                b.setType("1");
                b.setSetCount(null);
                list.add(b);
            }
            map.put("header",roasts);
            map.put("body",list);
        }else if(type.equals("wen")){
            List<Album> albums = cmfzDAO.findAllAlbum();
            for (Album album : albums) {
                Body body = new Body(album.getImgPath(), album.getName(), album.getAuthor(), "0", album.getSetCount(), album.getCreateTime());
                list.add(body);
            }
            map.put("body",list);

        }else if(type.equals("si")){
            List<Article> articles = cmfzDAO.findAllArticle();
            for (Article article : articles) {
                Body body = new Body(article.getImgPath(), article.getName(), article.getGuru().getName(), "1", 1, article.getCreateTime());
                list.add(body);
            }
            map.put("body",list);
        }

        return map;
    }


    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString().replace("-",""));
        cmfzDAO.addUser(user);
    }
}
