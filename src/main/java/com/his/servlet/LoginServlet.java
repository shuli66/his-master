package com.his.servlet;

import com.his.mapper.EmployeeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_check")
public class LoginServlet extends HttpServlet {

    private EmployeeMapper employeeMapper;

    @Override
    public void init() throws ServletException {
        employeeMapper = new EmployeeMapper();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名和密码
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");

        // 进行登录验证
        boolean loginSuccessful = employeeMapper.login(realname, password);

        if (loginSuccessful) {
            // 登录成功
            // 这里可以进行一些登录成功后的操作，如设置登录状态、重定向到其他页面等
            response.getWriter().write("true"); // 返回登录成功的标记
        } else {
            // 登录失败
            response.getWriter().write("false"); // 返回登录失败的标记
        }
    }
}
