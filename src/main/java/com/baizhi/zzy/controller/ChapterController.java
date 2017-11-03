package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Album;
import com.baizhi.zzy.entity.Chapter;
import com.baizhi.zzy.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/27.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(String albumid,MultipartFile singer,String name, HttpServletRequest request) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String extension = FilenameUtils.getExtension(singer.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+
                "."+extension;
        File dest = new File(realPath, newFileName);
        singer.transferTo(dest);

        System.out.println("1");
        //创建一个章节对象
        Chapter chapter = new Chapter();
        //给章节对象赋值name
        chapter.setName(name);
        //给章节对象赋值路径
        chapter.setDownload(newFileName);
        //获取章节大小
        double size =singer.getSize();
        //创建一个专辑对象
        Album album = new Album();
        //给专辑对象赋值id
        album.setId(albumid);
        //给章节对象赋值大小
        chapter.setSize(size);
        chapter.setStatus("播放");

        /*Clip clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream(dest);
        clip.open(ais);
        String duration = clip.getMicrosecondLength() / 1000000D + " s";
        System.out.println(duration);*/

        chapter.setDuration("999s");
        chapter.setAlbum(album);
        chapterService.save(chapter);
        return "上传成功";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Chapter chapter){
        chapterService.update(chapter);
        return "ok";
    }
    @RequestMapping("/download")
    @ResponseBody
    public void downLoad(String name,HttpServletRequest request,HttpServletResponse response) throws IOException {

        //读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        FileInputStream fis= new FileInputStream(new File(realPath,name));
        response.setHeader("Content-Disposition","attachment;filename="+name);
        response.setContentType("audio/mpeg");
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(fis,os);
        IOUtils.closeQuietly(fis);

    }
}
