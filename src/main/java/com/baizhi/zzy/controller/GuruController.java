package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Guru;
import com.baizhi.zzy.service.GuruService;
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
 * Created by Administrator on 2017/10/29.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile photo,String name, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"."+extension;

        //上传文件
        photo.transferTo(new File(realPath,newFileName));

        Guru guru = new Guru();
        guru.setImgPath(newFileName);
        guru.setName(name);
        guruService.save(guru);

        return "上传成功";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Guru> gurus = guruService.queryAll();
        int size = gurus.size();
        System.out.println(gurus);
        List<Guru> guru = guruService.queryByPage(page,rows);
        System.out.println(guru);
        map.put("total",size);
        map.put("rows",guru);
        System.out.println(map);
        return map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(Guru guru){
        guruService.update(guru);
        return "修改成功";
    }
    @RequestMapping("/findGuru")
    @ResponseBody
    public List<Guru> findGuru(){
        List<Guru> gurus = guruService.queryAll();
        return gurus;
    }
}
