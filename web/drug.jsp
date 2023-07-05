<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>药品信息</title>
    <link href="html/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<style>


</style>
</head>
<body>
<h1 style="text-align: center;color: #00a2d4;font-weight: bold;">药品信息</h1>
    <table class="table" id="drug-table" style="text-align: center">
        <tr style="color: #568c0a;font-weight: bold;">
            <td>序号</td>
            <td>药品编码</td>
            <td>药品名称</td>
            <td>药品规格</td>
            <td>包装单位</td>
            <td>生产厂家</td>
            <td>药剂类型</td>
            <td>药品类型</td>
            <td>药品单价</td>
            <td>拼音助记码</td>
            <td>创建时间</td>
            <td>&nbsp;&nbsp;操作</td>
        </tr>

        <c:forEach items="${list}" var="drug">
            <tr>


                <td>${drug.id}</td>
                <td>${drug.drug_code}</td>
                <td>${drug.drug_name}</td>
                <td>${drug.drug_format}</td>
                <td>${drug.drug_unit}</td>
                <td>${drug.manufacturer==""?"---------------":drug.manufacturer}</td>
                <td>${drug.drug_dosage}</td>
                <td>${drug.drug_type}</td>
                <td>${drug.drug_price}</td>
                <td>${drug.mnemonic_code}</td>
                <td>${drug.creation_date}</td>
                <td><button class="btn btn-primary" onclick="">编辑</button></td>
                <td><button class="btn btn-danger" onclick="delDrug(${drug.id})">删除</button></td>

            </tr>
        </c:forEach>
    </table>

</body>
<script>
    function delDrug(id){
        if (confirm("确定删除？")){
            location.href = "drug_check?code=2&id="+id;
        }
    }

</script>
</html>
