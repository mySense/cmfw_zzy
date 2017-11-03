package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Admin;
import com.baizhi.zzy.service.AdminService;
import com.baizhi.zzy.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/findOne")
    public String findOne(Admin admin,HttpSession session,String encode){
        Admin a= adminService.queryOne(admin.getUsername());
        String code = (String) session.getAttribute("code");
        System.out.println(admin.getUsername());
        if(code.equalsIgnoreCase(encode)){
            if(a==null){
                return "redirect:/back/page/login.jsp";
            }else if(a.getPassword().equals(admin.getPassword())){
                session.setAttribute("admin",a);
                return "redirect:/back/page/main.jsp";
            }else{
                return "redirect:/back/page/login.jsp";
            }
        }else{
            return "redirect:/back/page/login.jsp";
        }

    }
    @RequestMapping("/code")
    public void  getCode(HttpSession session,HttpServletResponse response) throws IOException {
        String code = VerifyCodeUtil.generateVerifyCode(4);
        System.out.println(code);
        session.setAttribute("code",code);
        BufferedImage image = VerifyCodeUtil.getImage(120, 30, code);
        ImageIO.write(image,"png",response.getOutputStream());
    }
    @RequestMapping("/save")
    public String save(Admin admin){
        adminService.save(admin);
        return "redirect:/back/page/login.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Admin admin){
        adminService.update(admin);
        return "修改成功";
    }

    @RequestMapping("/outLogin")
    public String outLogin(HttpSession session){
        session.setAttribute("admin",null);
        return "redirect:/back/page/login.jsp";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(Admin admin){
        adminService.update(admin);
        return "修改密码成功";
    }
    @RequestMapping("/findById")
    @ResponseBody
    public Admin findById(String id){
        Admin admin = adminService.queryById(id);
        return admin;
    }
}
