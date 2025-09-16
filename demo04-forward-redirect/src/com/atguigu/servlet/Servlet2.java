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
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    /*
    * 1 重定向是通过HttpServletResponse对象实现的
    * 2 响应重定向是在服务端提示下的，客户端行为
    * 3 客户端地址栏是变化的
    * 4 客户端至少发送了两次请求 客户端产生了多次请求
    * 5 请求产生多次，后端就会有多个request对象 此时请求中的参数不能继续自动传递
    * 6 目标资源可以是视图资源
    * 7 目标资源不可以是WEB-INF下的资源
    * 8 目标资源可以是外部资源
    *
    *
    * 重点：同样能够实现页面跳转，优选使用响应重定向
    * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet2 got money:" + req.getParameter("money"));
        System.out.println("servlet2执行了");
    }
}
