package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Album;
import com.baizhi.zzy.entity.Chapter;
import com.baizhi.zzy.service.AlbumService;
import com.baizhi.zzy.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/27.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile photo, Album album, HttpServletRequest request) throws IOException {
        //获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;
        photo.transferTo(new File(realPath,newFileName));
        album.setImgPath(newFileName);
        List<Album> albums = albumService.queryAll();
        album.setSetCount(albums.size());
        albumService.save(album);
        return "上传专辑成功";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Album album){
        albumService.update(album);
        System.out.println(album);
        return "ok";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Album> albums = albumService.queryAll();
        int size = albums.size();
        List<Album> album = albumService.queryByPage(page, rows);
        map.put("total",size);
        map.put("rows",album);
        return map;
    }
    @RequestMapping("/find")
    @ResponseBody
    public List<Album> find(){
        List<Album> albums = albumService.queryAll();
        System.out.println(albums);
        return albums;
    }
}
