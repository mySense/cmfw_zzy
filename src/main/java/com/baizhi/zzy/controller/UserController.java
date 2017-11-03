package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Echarts;
import com.baizhi.zzy.entity.User;
import com.baizhi.zzy.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/save")
    @ResponseBody
    public String save(MultipartFile img,User user,HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        String newFileName= UUID.randomUUID().toString().replace("-","")+
                new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"."+extension;
        img.transferTo(new File(realPath,newFileName));

        user.setPhoto(newFileName);
        System.out.println(user);
        userService.save(user);
        return "添加成功";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        userService.update(user);
        return "修改成功";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        List<User> users = userService.queryAll();
        int size = users.size();
        List<User> user = userService.queryByPage(page, rows);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",size);
        map.put("rows",user);
        return map;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id){
        userService.delete(id);
        return "删除成功";
    }
    @RequestMapping("/findCityNum")
    @ResponseBody
    public List<Echarts> findCityNum(){
        List<Echarts> echarts = userService.queryCityNum();
        return echarts;
    }
    @RequestMapping("/findUserNum")
    @ResponseBody
    public List<Integer> findUserNum(){
        Integer one = userService.queryUserNum(7);
        Integer two = userService.queryUserNum(14);
        Integer three = userService.queryUserNum(21);
        List<Integer> list = new ArrayList<Integer>();
            list.add(one);
        list.add(two);
        list.add(three);
        return list;
    }

}
