package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName:BaseContoller
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/18 3:21
 * @Version 1.0
 */

public class BaseContoller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断此次请求是增？删？改？查？
        String requestURI = req.getRequestURI();//schedule/add
        String[] split = requestURI.split("/");
        String methodName = split[split.length-1];
        //使用 反射 通过方法名获取下面的方法
        Class aClass = this.getClass();
        //获取方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //暴力 破解的访问修饰符的限制
            declaredMethod.setAccessible(true);

            //执行方法
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
