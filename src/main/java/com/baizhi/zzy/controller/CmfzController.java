package com.baizhi.zzy.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baizhi.zzy.dao.RoastDAO;
import com.baizhi.zzy.entity.User;
import com.baizhi.zzy.service.CmfzService;
import com.baizhi.zzy.util.MessageCode;
import com.baizhi.zzy.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */
@Controller
@RequestMapping("/cmfz")
public class CmfzController {
    @Autowired
    private CmfzService cmfzService;


    @RequestMapping("/first_page")
    @ResponseBody
    public Map<String,Object> showAfter(String id,String type,String sub_type){
        Map<String, Object> map = cmfzService.showAfter(id, type, sub_type);
        return map;
    }
    @RequestMapping("/message")
    @ResponseBody
    public void message(String phone) throws Exception {
        cmfzService.sendMessage(phone);
    }
    @RequestMapping("/save")
    @ResponseBody
    public Map<String,String> save(String phone,String code){
        Map<String, String> map = cmfzService.equalMessage(phone, code);
        return map;
    }
}
