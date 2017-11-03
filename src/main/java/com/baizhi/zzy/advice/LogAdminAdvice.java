package com.baizhi.zzy.advice;

import com.baizhi.zzy.entity.Admin;
import com.baizhi.zzy.entity.Log;
import com.baizhi.zzy.entity.User;
import com.baizhi.zzy.service.LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/30.
 */
@Component
public class LogAdminAdvice implements MethodInterceptor {
    @Autowired
    private LogService logService;
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object proceed = null;
        String name = invocation.getMethod().getName();
        Method method = invocation.getMethod();
        boolean annotationPresent = method.isAnnotationPresent(LogAnnotation.class);
        if(annotationPresent){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Admin admin = (Admin)request.getSession().getAttribute("admin");
            Log log = new Log();
            System.out.println("=="+log);
            log.setName(admin.getUsername());
            log.setDate(new Date());
            System.out.println("==========");
            LogAnnotation annotation = invocation.getMethod().getAnnotation(LogAnnotation.class);
            String description = annotation.description();
            log.setDoSomeThing(description);
            try {
                proceed = invocation.proceed();
                log.setStatus("成功");
            } catch (Exception e) {
                e.printStackTrace();
                log.setStatus("失败");
            }
            logService.save(log);
        }else {
            proceed=invocation.proceed();
        }
        return proceed;
    }
}
