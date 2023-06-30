package com.his.servlet;

import com.his.beam.Employee;
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
        String code = request.getParameter("code");
        if (code.equals("0")){//登录
            // 获取用户名和密码
            String realname = request.getParameter("realname");
            String password = request.getParameter("password");
            // 进行登录验证
            boolean loginSuccessful = EmployeeMapper.login(realname, password);

            PrintWriter out = response.getWriter();
            if (loginSuccessful) {
                // 登录成功
                out.print("true");
            } else {
                // 登录失败
                out.print("false");
            }
        }

        if(code.equals("1")){//注册
            String name = request.getParameter("realname");

            String pwd = request.getParameter("password");
            String pwd2 = request.getParameter("password2");
            String deptmentId = request.getParameter("deptment_id");
//        if ("0".equals(deptmentId)){
//            request.setAttribute("res","请选择科室！");
//            request.getRequestDispatcher("register.jsp").forward(request,response);
//            return;
//        }

            String register_level_id = request.getParameter("register_level_id");
            String scheduling_id = request.getParameter("scheduling_id");

            Employee employee = new Employee();

            employee.setRealname(name);
            employee.setPassword(pwd);


            if (deptmentId != null && !deptmentId.isEmpty()) {
                employee.setDepartmentId(Integer.parseInt(deptmentId));
            }
            if (register_level_id != null && !register_level_id.isEmpty()) {
                employee.setRegistLevelId(Integer.parseInt(register_level_id));
            }
            if (scheduling_id != null && !scheduling_id.isEmpty()) {
                employee.setSchedulingId(Integer.parseInt(scheduling_id));
            }

//            employee.setDepartmentId(Integer.parseInt(deptmentId));
//            employee.setRegistLevelId(Integer.parseInt(register_level_id));
//            employee.setSchedulingId(Integer.parseInt(scheduling_id));





            boolean registrationSuccessful = false;

            if (pwd.equals(pwd2)) {
                // 密码一致，执行注册逻辑
                registrationSuccessful = EmployeeMapper.registerEmployee(employee);
                System.out.println(employee);
            } else {
                // 密码不一致，注册失败
                registrationSuccessful = false;
            }

            if (registrationSuccessful) {
                request.setAttribute("message", "注册成功"); // 设置成功消息
                request.getRequestDispatcher("login.jsp").forward(request, response); // 转发到登录页面
            } else {
                request.setAttribute("error", "注册失败"); // 设置失败消息
                request.getRequestDispatcher("register.jsp").forward(request, response); // 转发回注册页面
            }
        }




    }
}
