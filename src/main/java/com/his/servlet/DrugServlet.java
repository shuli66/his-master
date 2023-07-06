package com.his.servlet;

import com.his.dao.DrugInfo;
import com.his.mapper.DrugMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
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

        if (code.equals("1")) {//查询所有药品信息
            List<DrugInfo> list = mapper.selectDrug();
            request.setAttribute("list", list);
            request.getRequestDispatcher("drugList.jsp").forward(request, response);
        }
        if (code.equals("2")) {//删除药品信息
            String id = request.getParameter("id");
            try {
                if (DrugMapper.delDrug(id)) {
                    List<DrugInfo> list = mapper.selectDrug();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("drugList.jsp").forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        //修改之前查询
        if (code.equals("3")) { // 修改之前的查询
            String id = request.getParameter("id");
            DrugInfo drugInfo = mapper.updateSelectDrug(id);
            request.setAttribute("drugInfo", drugInfo);
            // 其他逻辑处理...
            request.getRequestDispatcher("updateDrug.jsp").forward(request, response);
        }
        if (code.equals("4")) { // 修改药品
            String id = request.getParameter("id");
            // 获取表单参数
            String drugCode = request.getParameter("drug_code");
            String drugName = request.getParameter("drug_name");
            String drugFormat = request.getParameter("drug_format");
            String drugUnit = request.getParameter("drug_unit");
            String manufacturer = request.getParameter("manufacturer");
            String drugDosage = request.getParameter("drug_dosage");
            String drugType = request.getParameter("drug_type");
            String drugPrice = request.getParameter("drug_price");
            String mnemonicCode = request.getParameter("mnemonic_code");

            DrugInfo drugInfo = new DrugInfo();
            drugInfo.setId(Integer.parseInt(id));
            drugInfo.setDrug_code(drugCode);
            drugInfo.setDrug_name(drugName);
            drugInfo.setDrug_format(drugFormat);
            drugInfo.setDrug_unit(drugUnit);
            drugInfo.setManufacturer(manufacturer);
            drugInfo.setDrug_dosage(drugDosage);
            drugInfo.setDrug_type(drugType);
            drugInfo.setMnemonic_code(mnemonicCode);
            drugInfo.setDrug_price(new BigDecimal(drugPrice));

            // 设置创建时间为当前时间
            drugInfo.setCreation_date(new Date());

            // 调用updateDrug方法进行更新操作
            if (mapper.updateDrug(drugInfo)) {
                // 更新成功的逻辑处理...
                List<DrugInfo> list = mapper.selectDrug();
                request.setAttribute("list", list);
                request.getRequestDispatcher("drugList.jsp").forward(request, response);
            } else {
                // 更新失败的逻辑处理...
                request.getRequestDispatcher("updateDrug.jsp").forward(request, response);
            }
        }




        if(code.equals("5")){//条件查询
            String drug_name = request.getParameter("drug_name");
            List<DrugInfo> list = mapper.likeDrugName(drug_name);
            request.setAttribute("list", list);
            request.getRequestDispatcher("drugList.jsp").forward(request, response);
        }




        if (code.equals("6")) {//添加药品
            String drugCode = request.getParameter("drug_code");
            String drugName = request.getParameter("drug_name");
            String drugFormat = request.getParameter("drug_format");
            String drugUnit = request.getParameter("drug_unit");
            String manufacturer = request.getParameter("manufacturer");
            String drugDosage = request.getParameter("drug_dosage");
            String drugType = request.getParameter("drug_type");
            String drugPrice = request.getParameter("drug_price");
            String mnemonicCode = request.getParameter("mnemonic_code");

            DrugInfo drugInfo = new DrugInfo();
            drugInfo.setDrug_code(drugCode);
            drugInfo.setDrug_name(drugName);
            drugInfo.setDrug_format(drugFormat);
            drugInfo.setDrug_unit(drugUnit);
            drugInfo.setManufacturer(manufacturer);
            drugInfo.setDrug_dosage(drugDosage);
            drugInfo.setDrug_type(drugType);
            drugInfo.setMnemonic_code(mnemonicCode);

            BigDecimal price = new BigDecimal(drugPrice);
            drugInfo.setDrug_price(price);

            // 获取当前日期
            Date currentDate = new Date();

            // 创建 java.sql.Date 对象
            java.sql.Date creationDate = new java.sql.Date(currentDate.getTime());

            drugInfo.setCreation_date(creationDate);

            if (mapper.isDrugName(drugName)){
                response.getWriter().write("failure"); // 返回注册失败的标识数据
                return;
            }

            if (DrugMapper.registerDrug(drugInfo)) {
                List<DrugInfo> list = mapper.selectDrug();
                request.setAttribute("list", list);
                request.getRequestDispatcher("drugList.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("updateDrug.jsp").forward(request, response); // 转发回注册页面
            }
        }

    }
}