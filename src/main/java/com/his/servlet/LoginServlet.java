package com.his.servlet;

import com.his.beam.Department;
import com.his.beam.Employee;
import com.his.beam.dto.EmployeeDto;
import com.his.mapper.DeptMapper;
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
        request.setCharacterEncoding("UTF-8");
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String code = request.getParameter("code");
        if (code != null && code.contains("?")) {
            code = code.substring(0, 1);
        }

        EmployeeMapper mapper = new EmployeeMapper();

        //code==1 登录
        //code==2 注册
        //code==3 查询所以医生信息
        // 获取用户名和密码


        if (code.equals("1")) {//登录
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
            String register_level_id = request.getParameter("regist_level_id");
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

            //在register.jsp有js请选择科室的提示
            //在register.jsp有js密码不一致的提示
            //在register.jsp有js登录消息提示

            if (EmployeeMapper.registerEmployee(employee)) {
                request.getRequestDispatcher("login.jsp").forward(request, response); // 转发到登录页面
            } else {
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
        if(code.equals("6")){//修改之前的查询
            String id = request.getParameter("id");
            Employee employee = mapper.updateSelectUser(id);
            request.setAttribute("employee",employee);
            //实例化科室mapper
            DeptMapper deptMapper = new DeptMapper();
            //查询所有科室信息
            List<Department> deptList =deptMapper.selectDeptAll();
            //将科室信息存入请求
            request.setAttribute("deptList",deptList);
            request.getRequestDispatcher("updateUser.jsp").forward(request,response);

        }
        if(code.equals("7")){//修改操作
            //id
            String id =request.getParameter("id");
            String name = request.getParameter("realname");
            String pwd = request.getParameter("password");
            //科室
            String deptment_id = request.getParameter("deptment_id");
            //职称
            String regist_level_id = request.getParameter("regist_level_id");
            //排班
            String scheduling_id = request.getParameter("scheduling_id");
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(id));
            employee.setRealname(name);
            employee.setPassword(pwd);

            if (deptment_id != null && !deptment_id.isEmpty()) {
                employee.setDeptment_id(Integer.parseInt(deptment_id));
            }
            if (regist_level_id != null && !regist_level_id.isEmpty()) {
                employee.setRegist_level_id(Integer.parseInt(regist_level_id));
            }
            if (scheduling_id != null && !scheduling_id.isEmpty()) {
                employee.setScheduling_id(Integer.parseInt(scheduling_id));
            }
                if (mapper.updateEmployee(employee)){
                    List<EmployeeDto> list = mapper.selectAll();
                    request.setAttribute("list",list);
                    request.getRequestDispatcher("userList.jsp").forward(request,response);
                }else {
                    request.setAttribute("res","修改失败！请联系管理员！");
                    //返回到修改页面
                    request.getRequestDispatcher("updateUser.jsp").forward(request,response);
                }


        }
    }
}
