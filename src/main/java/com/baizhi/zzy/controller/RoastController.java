package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Roast;
import com.baizhi.zzy.service.RoastService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/roast")
public class RoastController {
    @Autowired
    private RoastService roastService;

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(String alt,MultipartFile photo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取据对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //获取文件名
        String filename = photo.getOriginalFilename();
        //获取文件后缀
        String extension = FilenameUtils.getExtension(filename);
        //获取新文件名
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHssmm").format(new Date())+
                "."+
                extension;
        //进行上传
        photo.transferTo(new File(realPath,newFileName));
        Roast roast = new Roast();
        roast.setImgPath(newFileName);
        roast.setAlt(alt);
        roastService.save(roast);
        return "上传成功";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Roast> roasts = roastService.queryAll();
        List<Roast> roast = roastService.queryByPage(page, rows);
        int size = roasts.size();
        map.put("total",size);
        map.put("rows",roast);
        return map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody  Roast roast){
        roastService.update(roast);
        System.out.println(roast);
        return "ok";
    }

}
