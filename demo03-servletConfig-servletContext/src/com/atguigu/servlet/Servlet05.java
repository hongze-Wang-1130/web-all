package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * ClassName:Servlet05
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/16 16:49
 * @Version 1.0
 */
@WebServlet("/servlet05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取键值对形式的参数
        //根据参数名单个的参数值
        String username = req.getParameter("username");
        System.out.println(username);
        String userPwd = req.getParameter("userPwd");
        System.out.println(userPwd);
        //根据参数名获取多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        //获取所有的参数名
        Enumeration<String> pnames = req.getParameterNames();
        while (pnames.hasMoreElements()) {
            String pname = pnames.nextElement();
            String[] values = req.getParameterValues(pname);
            if(values.length>1){
                System.out.println(pname + "=" + Arrays.toString(values));
            }else{
                System.out.println(pname + "=" + values[0]);
            }
        }

        //返回所有参数的map集合  key= 参数名  value = 参数值
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String pname = entry.getKey();
            String[] value = entry.getValue();
            if(value.length>1){
                System.out.println(pname + "=" + Arrays.toString(value));
            }else{
                System.out.println(pname + "=" + value[0]);
            }
        }


        /*
        * 以上API专门用于获取key=value形式的参数，无论这些参数是在URL后，还是在请求体中
        *
        * 获得请求体中的非键值对数据？       文件
        *
        * 获取一个从请求体中读取字符的字符输入流
        * BufferedReader reader = req.getReader();JSON串
        * 获得一个从请求体中读取二进制数据字节的输入流
        * ServletInputStream inputStream = req.getInputStream();
        * */

        System.out.println(req.getServletPath());


    }
}
