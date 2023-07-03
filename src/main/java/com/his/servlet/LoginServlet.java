package com.his.servlet;

import com.his.beam.Employee;
import com.his.beam.dto.EmployeeDto;
import com.his.mapper.EmployeeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login_check")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");
        if (code != null && code.contains("?")) {
            code = code.substring(0, 1);
        }

        EmployeeMapper mapper = new EmployeeMapper();

        //code==1 登录
        //code==2 注册
        //code==3 查询所以医生信息


        if (code.equals("1")) {//登录
            // 获取用户名和密码
            String realname = request.getParameter("realname");
            String password = request.getParameter("password");
            // 进行登录验证
            EmployeeDto sessionEmployee = mapper.login(realname, password);

            PrintWriter out = response.getWriter();
            if (sessionEmployee.getId() > 0) {
                // 登录成功
                out.print("true");
                request.getSession().setAttribute("sessionEmployee", sessionEmployee);
            } else {
                // 登录失败
                out.print("false");
            }
        }

        if (code.equals("2")) {//注册
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
                employee.setDeptment_id(Integer.parseInt(deptmentId));
            }
            if (register_level_id != null && !register_level_id.isEmpty()) {
                employee.setRegist_level_id(Integer.parseInt(register_level_id));
            }
            if (scheduling_id != null && !scheduling_id.isEmpty()) {
                employee.setScheduling_id(Integer.parseInt(scheduling_id));
            }


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

        if (code.equals("3")) {//查询所有医生信息
            List<EmployeeDto> list = mapper.selectAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("userList.jsp").forward(request, response);


        }

        if (code.equals("4")) {//安全退出
            request.getSession().removeAttribute("sessionEmployee");
            response.sendRedirect("login.jsp");


        }

        if (code.equals("5")) {//删除医生信息
            String id = request.getParameter("id");
            try {
                if (EmployeeMapper.delUser(id)){
                    List<EmployeeDto> list = mapper.selectAll();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("userList.jsp").forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
