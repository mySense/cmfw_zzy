package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Article;
import com.baizhi.zzy.entity.Guru;
import com.baizhi.zzy.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile photo,String guruid,String contentE,Article article, HttpServletRequest request) throws IOException {

        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
        photo.transferTo(new File(realPath,newFileName));
        article.setImgPath(newFileName);
        Guru guru = new Guru();
        guru.setId(guruid);
        article.setGuru(guru);
        article.setContent(contentE);
        articleService.save(article);
        return "上传成功";
    }
    //上传文章内容的图片
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,Object> uploadimg(MultipartFile articleimg, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String filename = articleimg.getOriginalFilename();
        String extension = FilenameUtils.getExtension(filename);
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
        articleimg.transferTo(new File(realPath,newFileName));
        //设置响应类型
        response.setHeader("Content-Type","image/jped");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("error",0);
        map.put("url","/cmfz_zzy/upload/"+newFileName);
        return map;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id){
        articleService.delete(id);
        return "删除成功";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(Article article){
        System.out.println(article);
        articleService.update(article);
        return "修改成功";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> fingAll(Integer page, Integer rows){
        List<Article> articles = articleService.queryAll();
        int size = articles.size();
        List<Article> article = articleService.queryByPage(page, rows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",size);
        map.put("rows",article);
    return map;
    }
}
