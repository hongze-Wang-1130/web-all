package com.atguigu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName:Servlet06
 * Description:
 *
 * @Author Zack
 * @Create 2025/9/16 17:42
 * @Version 1.0
 */
@WebServlet("/servlet06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置相应行的API HTTP/1.1  200/404/500...  状态描述文字
        resp.setStatus(200);
        String info = "<h1>hello</h1>";
        //设置响应头相关的API
//        resp.setHeader("aaa","valuea");
//        resp.setHeader("Content-type","text/html");
        resp.setContentType("text/html");
        resp.setContentLength(info.getBytes().length);

        //设置响应体内容的API
        //获得一个向响应体中输出文本字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write(info);

        //获得一个向响应体中输入二进制信息的字节输出流
//        ServletOutputStream outputStream = resp.getOutputStream();

    }
}
