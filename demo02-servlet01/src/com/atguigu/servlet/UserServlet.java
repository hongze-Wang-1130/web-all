package com.atguigu.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName:UserServlet
 * Description:
 * 1 创建javaWEB项目，同时将tomcat添加为当前项目的依赖
 * 2 重写service方法 service(HttpServletRequest req, HttpServletResponse resp)
 * 3 在service方法中，定义业务处理代码
 * 4 在web.xml中配置Servlet对于的请求映射路劲
 *
 * 1 servlet-api.jar 导入问题
 *      servlet-api 编码的时候需要，运行的时候，在服务器的环境中，由服务软件（tomcat）提供
 *      因此javaWeb项目中，在打包/构建的时候，是无需携带servlet-api的jar包的
 * 2 Content-Type响应头的问题
 *      MIME类型响应头  媒体类型，文件类型，响应的数据类型
 *      MIME类型用于告诉客户端响应的数据是什么类型的数据，客户端以此类型决定用什么方式解析响应体
 * @Author Zack
 * @Create 2025/9/14 15:41
 * @Version 1.0
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1从request对象中获取请求中的任何信息(username参数)
        String username = request.getParameter("username");//根据参数名获取参数值 无论参数是在url?后还是请求体中

        String info = "<h1>YES</h1>";

        //2处理业务的代码
        if("atguigu".equals(username)){
            info="<h1>NO</h1>";
        }

        //3将要响应的数据放入response
        //应该设置Content-Type响应头
//        response.setHeader("Content-Type","text/html");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();//该方法返回的是一个响应体中打印字符串的打印流
        writer.write(info);


    }
}
