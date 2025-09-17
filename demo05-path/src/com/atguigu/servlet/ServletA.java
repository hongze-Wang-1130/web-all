package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/17 17:50
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA");

        //重定向到ServletB
        /*
        * 1 相对路径写法
        *   和前端的相对路线规则一致
        *
        * 2 绝对路径写法
        *
        * */
//        resp.sendRedirect(req.getServletContext().getContextPath()+ "/servletB");

        /*请求转发到ServletB*/
        /*
        * 1 相对路径写法  一致
        *   http://localhost:8080/demo05/servletA
        * http://localhost:8080/demo05/servletB
        *
        *2 绝对路径
        *   请求转发的绝对路径是不需要添加项目上下文的
        *   请求转发的/代表的路径是 http://localhost:8080/demo05
        * */
        req.getRequestDispatcher("/servletB").forward(req,resp);
    }
}
