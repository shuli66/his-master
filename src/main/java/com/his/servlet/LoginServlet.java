package com.his.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_check")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 进行登录验证
        boolean loginSuccessful = validateLogin(username, password);

        if (loginSuccessful) {
            // 登录成功
            // 这里可以进行一些登录成功后的操作，如设置登录状态、重定向到其他页面等
            response.getWriter().write("true"); // 返回登录成功的标记
        } else {
            // 登录失败
            response.getWriter().write("false"); // 返回登录失败的标记
        }
    }

    private boolean validateLogin(String username, String password) {
        // 假设有一个预定义的用户名和密码用于验证
        String validUsername = "admin";
        String validPassword = "123";

        // 在这里进行实际的登录验证
        // 可以连接数据库，检查用户名和密码是否匹配
        // 返回true表示验证通过，返回false表示验证失败
        // 这里只是一个示例，实际情况需要根据具体需求进行编写
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
