package com.atguigu.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletLifeCycle
 * Description:
 * 1 实例化                    构造器                 第一次请求/服务启动
 * 2 初始化                    init                   构造完毕
 * 3 接收请求，处理请求  服务    service                每次请求
 * 4 销毁                      destory                关闭服务
 *
 * Servlet在Tomcat中是单例的
 * Servlet的成员变量在多个线程栈之中是共享的
 * 不建议在service方法中修改成员变量 在并发请求时，会引发线程安全问题
 * default-servlet用于加载静态资源的servlet，默认随服务启动，默认启动序号为1
 *
 * servlet继承结构
 * 1 顶级的Servlet接口
 * public interface Servlet {
 *      //初始化方法，构造完毕后，由tomcat自动调用完成初始化功能的方法
 *     void init(ServletConfig var1) throws ServletException;
 *      //获得servletConfig对象的方法
 *     ServletConfig getServletConfig();
 *      //接收用户请求，向用户响应的信息的方法
 *     void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *      //返回servlet字符串描述信息的方法
 *     String getServletInfo();
 *      //servlet在回收前，由tomcat调用的销毁方法，用于资源的释放工作
 *     void destroy();
 * }
 *
 * 2 抽象的类 GenericServlet 侧重除了service方法以外的其它方法的基础处理
 * public abstract class GenericServlet implements Servlet{
 *     private transient ServletConfig config;
 *
 *     public void destroy() {
 *          //将抽象方法，重写为普通方法
 *          //平庸实现
 *     }
 *
 *      //tomcat在调用init方法时，会读取配置信息进入一个ServletConfig对象并将该对象传入init方法
 *     public void init(ServletConfig config) throws ServletException {
 *          //将config对象存储为当前的属性
 *         this.config = config;
 *         //调用了重载的无参init
 *         this.init();
 *     }
 *      //重载的初始化方法，我们要重写初始化方法时要对应的方法
 *     public void init() throws ServletException {
 *     }
 *     // 返回servletconfig的方法
 *     public ServletConfig getServletConfig() {
 *         return this.config;
 *     }
 *     //再次抽象声明service方法
 *     public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 * }
 *
 *3 HttpServlet抽象类 侧重service方法的处理
 * public abstract class HttpServlet extends GenericServlet{
 *      //参数的父转子
 *     public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
 *          //参数的父转子
 *          HttpServletRequest request = (HttpServletRequest)req;
 *          HttpServletResponse response = (HttpServletResponse)res;
 *          //调用重载的service
 *          this.service(request, response);
 *     }
 *
 *     protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *         String method = req.getMethod();
 *         long lastModified;
 *         if (method.equals("GET")) {
 *             lastModified = this.getLastModified(req);
 *             if (lastModified == -1L) {
 *                 this.doGet(req, resp);
 *             } else {
 *                 long ifModifiedSince;
 *                 try {
 *                     ifModifiedSince = req.getDateHeader("If-Modified-Since");
 *                 } catch (IllegalArgumentException var9) {
 *                     ifModifiedSince = -1L;
 *                 }
 *
 *                 if (ifModifiedSince < lastModified / 1000L * 1000L) {
 *                     this.maybeSetLastModified(resp, lastModified);
 *                     this.doGet(req, resp);
 *                 } else {
 *                     resp.setStatus(304);
 *                 }
 *             }
 *         } else if (method.equals("HEAD")) {
 *             lastModified = this.getLastModified(req);
 *             this.maybeSetLastModified(resp, lastModified);
 *             this.doHead(req, resp);
 *         } else if (method.equals("POST")) {
 *             this.doPost(req, resp);
 *         } else if (method.equals("PUT")) {
 *             this.doPut(req, resp);
 *         } else if (method.equals("DELETE")) {
 *             this.doDelete(req, resp);
 *         } else if (method.equals("OPTIONS")) {
 *             this.doOptions(req, resp);
 *         } else if (method.equals("TRACE")) {
 *             this.doTrace(req, resp);
 *         } else {
 *             String errMsg = lStrings.getString("http.method_not_implemented");
 *             Object[] errArgs = new Object[]{method};
 *             errMsg = MessageFormat.format(errMsg, errArgs);
 *             resp.sendError(501, errMsg);
 *         }
 *     }
 *     4自定义Servlet
 *     class Servlet1 extends HttpServlet{
 *         protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 *             //接收用户请求信息
 *
 *             //做出响应
 *         }
 *     }
 * }
 *
 *      1 部分程序员推荐在servlet中重写do***方法处理请求 理由是service方法中可能做了一些处理，如果我们直接重写service的话，父类中service方法处理的功能则失效了
 *      2 目前直接重写service也没有什么问题
 *      3 后续使用了springMVC框架后，我们则无需继承HTTPServlet，处理请求的方法也无需是do****  或 service
 *      4 如果doGet和 doPost方法中，我们定义的代码都一样，可以让一个方法直接调用另一个方法
 *      掌握的技能
 *          继承httpservlet后，要么重写service方法 要么从写doGet/doPost
 *
 * @Author Zack
 * @Create 2025/9/15 17:57
 * @Version 1.0
 */
@WebServlet(value = "/servletLifeCycle",loadOnStartup = 6)
public class ServletLifeCycle extends HttpServlet {

    public ServletLifeCycle(){
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("服务");
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求处理的方法");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
