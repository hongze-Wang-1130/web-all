package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName:SysScheduleController
 * Description:
 * 增加日程的请求 /schedule/add
 * 查询日程的请求 /schedule/find
 * 修改日程的请求 /schedule/update
 * 删除日程的请求 /schedule/remove
 * @Author Zack
 * @Create 2025/9/18 2:51
 * @Version 1.0
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseContoller {
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
}
