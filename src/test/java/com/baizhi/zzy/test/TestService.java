package com.baizhi.zzy.test;

import com.baizhi.zzy.entity.*;
import com.baizhi.zzy.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class TestService {
    public static void main(String[] args) {
        /*ApplicationContext context=new ClassPathXmlApplicationContext("com/baizhi/zzy/spring/spring.xml");
        UserService albumService = (UserService) context.getBean("userService");
        Integer a = albumService.queryUserNum(7);
        System.out.println(a);*/
        Jedis jedis = new Jedis("192.168.92.128", 6379);
        jedis.set("zzy","lpx");

    }
}
