package com.his.servlet;

import com.his.mapper.EmployeeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login_check")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名和密码
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");

        // 进行登录验证
        boolean loginSuccessful = EmployeeMapper.login(realname, password);

        response.setContentType("text/html; charset=UTF-8"); // 设置响应类型为HTML文档

        PrintWriter out = response.getWriter();
        if (loginSuccessful) {
            // 登录成功
            out.print("true");
        } else {
            // 登录失败
            out.print("false");
        }
    }
}
