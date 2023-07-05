package com.his.servlet;

import com.his.beam.dto.EmployeeDto;
import com.his.dao.DrugInfo;
import com.his.mapper.DrugMapper;
import com.his.mapper.EmployeeMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/drug_check")
public class DrugServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String code = request.getParameter("code");
        if (code != null && code.contains("?")) {
            code = code.substring(0, 1);
        }

        DrugMapper mapper = new DrugMapper();

        if (code.equals("1")) {//查询所有医生信息
            List<DrugInfo> list = mapper.selectDrug();
            request.setAttribute("list", list);
            request.getRequestDispatcher("drug.jsp").forward(request, response);
        }
        if (code.equals("2")) {//删除医生信息
            String id = request.getParameter("id");
            try {
                if (DrugMapper.delDrug(id)){
                    List<DrugInfo> list = mapper.selectDrug();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("drug.jsp").forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }



    }
}
