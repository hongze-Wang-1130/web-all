package com.atguigu.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:Servlet1
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/16 23:14
 * @Version 1.0
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户请求
        System.out.println("servlet1 执行了");

        System.out.println("servlet got money:" + req.getParameter("money"));

        //响应重定向     设置响应状态码302      同时设置Location响应头
//        resp.sendRedirect("servlet2");
//        resp.sendRedirect("a.html");
//        resp.sendRedirect("WEB-INF/b.html");
        resp.sendRedirect("http://www.apple.com");

    }

}
