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
    private Jedis jedis = new Jedis("192.168.92.128", 6379);


    @RequestMapping("/first_page")
    @ResponseBody
    public Map<String,Object> showAfter(String id,String type,String sub_type){
        Map<String, Object> map = cmfzService.showAfter(id, type, sub_type);
        return map;
    }
    @RequestMapping("/message")
    @ResponseBody
    public String message(String phone) throws ClientException {
        String code = VerifyCodeUtil.generateVerifyCode(4);
        String c = MessageCode.getCode(phone, code);
        jedis.set(phone,code);
        jedis.expire(phone,300);
        return c;
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(User user,String code){
        String s = jedis.get(user.getPhone());
        if(code.equals(s)){
            cmfzService.addUser(user);
            return "success";
        }else{
            return "fail";
        }
    }
}
