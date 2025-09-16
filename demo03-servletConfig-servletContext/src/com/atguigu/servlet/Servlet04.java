package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName:Servlet04
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/16 16:16
 * @Version 1.0
 */
@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //行相关的  GET/POST    URL     http/1.1
        System.out.println(req.getMethod());//获取请求方式
        System.out.println(req.getScheme());//获取请求协议
        System.out.println(req.getProtocol());//获取请求协议及版本号
        System.out.println(req.getRequestURI());//获取请求的uri  项目内的资源路径
        System.out.println(req.getRequestURL());//获取请求的url  项目内资源的完整的路径
        /*
        * URi 统一资源标识符   interface URI{}             资源定位的要求和规范
        * URL 统一资源定位符   class URL implements URI{}  一个具体的资源路径
        * */
        System.out.println(req.getLocalPort());//本应用的端口号 8080
        System.out.println(req.getServerPort());//客户端发请求时使用的端口号
        System.out.println(req.getRemotePort());//客户端的端口号
        //头相关的  key:value   key:value ... ...
        //根据名字单独获取某个请求头
        String accept = req.getHeader("Accept");
        System.out.println("Accept:" + accept);

        //获取本次请求中所有的请求头的名字
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String hname = headerNames.nextElement();
            System.out.println(hname + ":" + req.getHeader(hname));
        }

        //获取请求参数



    }
}
