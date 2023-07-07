package com.his.servlet;

import com.his.beam.Department;
import com.his.beam.Employee;
import com.his.beam.dto.EmployeeDto;
import com.his.beam.dto.Regist_level;
import com.his.mapper.DeptMapper;
import com.his.mapper.EmployeeMapper;
import com.his.mapper.Regist_levelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
        String realname = request.getParameter("realname");
        String password = request.getParameter("password");

        if (code.equals("1")) {//登录

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
            String regist_level_id = request.getParameter("regist_level_id");
            String scheduling_id = request.getParameter("scheduling_id");


            Employee employee = new Employee();
            employee.setRealname(name);
            employee.setPassword(pwd);

            if (deptmentId != null && !deptmentId.isEmpty()) {
                employee.setDeptment_id(Integer.parseInt(deptmentId));
            }
            if (regist_level_id != null && !regist_level_id.isEmpty()) {
                employee.setRegist_level_id(Integer.parseInt(regist_level_id));
            }
            if (scheduling_id != null && !scheduling_id.isEmpty()) {
                employee.setScheduling_id(Integer.parseInt(scheduling_id));
            }

            if (mapper.isUserName(name)){
                response.getWriter().write("failure"); // 返回注册失败的标识数据
                return;
            }

            //在register.jsp有js请选择科室的提示
            //在register.jsp有js密码不一致的提示
            //在register.jsp有js登录消息提示

            if (EmployeeMapper.registerEmployee(employee)) {
                String ref = request.getParameter("ref");
                if ("1".equals(ref)){
                    List<EmployeeDto> list = mapper.selectAll();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("userList.jsp").forward(request, response);
                    return;
                }
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

        if(code.equals("8")){//条件查询
            List<EmployeeDto> list = mapper.likeUserName(realname);
            request.setAttribute("list", list);
            request.getRequestDispatcher("userList.jsp").forward(request, response);
        }



        
        //职称管理




        Regist_levelMapper newmapper = new Regist_levelMapper();
        if ("9".equals(code)) { // 查询操作

            String registName = request.getParameter("registName");
            List<Regist_level> newlist;
            if (registName != null && !registName.isEmpty()) {
                newlist = newmapper.likeregistName(registName);
            } else {
                newlist = newmapper.selectregist();
            }
            request.setAttribute("newlist", newlist);
            request.getRequestDispatcher("registlevel.jsp").forward(request, response);
        } else if ("10".equals(code)) { // 删除操作
            String id = request.getParameter("id");
            if (newmapper.delregist(id)) {
                List<Regist_level> newlist = newmapper.selectregist();
                request.setAttribute("newlist", newlist);
                request.getRequestDispatcher("registlevel.jsp").forward(request, response);
            }
        } else if ("11".equals(code)) { // 修改前的查询
            String id = request.getParameter("id");
            Regist_level regist = newmapper.updateselectregist(id);
            request.setAttribute("regist", regist);
            request.getRequestDispatcher("updateregist.jsp").forward(request, response);
        } else if ("12".equals(code)) { // 修改或添加操作
            String id = request.getParameter("id");
            String regist_code = request.getParameter("regist_code");
            String regist_name = request.getParameter("regist_name");
            String regist_fee = request.getParameter("regist_fee");
            String regist_quota = request.getParameter("regist_quota");

            Regist_level regist = new Regist_level();
            if (id != null && !id.isEmpty()) {
                regist.setId(Integer.parseInt(id));
            }
            regist.setRegist_code(regist_code);
            regist.setRegist_name(regist_name);

            BigDecimal feeBigDecimal;
            if (regist_fee != null && !regist_fee.isEmpty()) {
                feeBigDecimal = new BigDecimal(regist_fee);
            } else {
                feeBigDecimal = BigDecimal.ZERO; // 设置默认值为0
            }
            float fee = feeBigDecimal.floatValue();
            regist.setRegist_fee(fee);

            if (regist_quota != null && !regist_quota.isEmpty()) {
                regist.setRegist_quota(Integer.parseInt(regist_quota));
            }

            boolean isSuccess;
            if (id == null || id.isEmpty()) {
                // 添加操作
                isSuccess = newmapper.addRegist(regist);
            } else {
                // 修改操作
                isSuccess = newmapper.updaeregist(regist);
            }

            if (isSuccess) {
                List<Regist_level> newlist = newmapper.selectregist();
                request.setAttribute("newlist", newlist);
                request.getRequestDispatcher("registlevel.jsp").forward(request, response);
            } else {
                request.setAttribute("res", "操作失败，请联系管理员！");
                request.getRequestDispatcher("updateregist.jsp").forward(request,response);
            }
        }



    }
}
