package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.ArticleDAO;
import com.baizhi.zzy.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/29.
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;


    public void save(Article article) {
        article.setId(UUID.randomUUID().toString().replace("-",""));
        article.setCreateTime(new Date());
        article.setStatus("Y");
        articleDAO.save(article);
    }

    public void update(Article article) {
        articleDAO.update(article);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> queryAll() {
        return articleDAO.queryAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Article> queryByPage(Integer pageNow, Integer pageNum) {
        pageNow=(pageNow-1)*pageNum;
        return articleDAO.queryByPage(pageNow,pageNum);
    }

    public void delete(String id) {
            articleDAO.delete(id);
    }
}
