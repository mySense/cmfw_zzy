package com.baizhi.zzy.controller;

import com.baizhi.zzy.entity.Log;
import com.baizhi.zzy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        List<Log> logs = logService.queryAll();
        int size = logs.size();
        List<Log> log = logService.queryByPage(page,rows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",size);
        map.put("rows",log);
        return map;
    }
}
