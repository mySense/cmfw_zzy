package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Menu;
import com.baizhi.zzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(){
        List<Menu> menus = menuService.queryAll();
        System.out.println("============"+menus);
        return menus;

    }
}
