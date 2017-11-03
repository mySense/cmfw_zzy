package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Article;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public interface ArticleService {
    @LogAnnotation(description = "插入文章")
    void save(Article article);
    @LogAnnotation(description = "修改文章")
    void update(Article article);
    List<Article> queryAll();
    List<Article> queryByPage(Integer pageNow,Integer pageNum);
    @LogAnnotation(description = "删除文章")
    void delete(String id);
}
