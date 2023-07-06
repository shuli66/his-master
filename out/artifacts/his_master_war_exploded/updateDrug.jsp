<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改药品信息</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        body {
            background-image: url(images/bg.png);
            background-repeat: no-repeat;
        }

        .main-box {
            width: 400px;
            background-color: rgba(255, 255, 255, 0.7);
            border-radius: 5px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px 30px;
        }
    </style>
</head>
<body>


<div class="main-box">
    <h2 class="text-center">修改药品信息</h2>

    <form class="form-horizontal" id="updateDrugForm" action="drug_check" method="post">
        <input type="hidden" name="id" value="${drugInfo.id}">
        <input type="hidden" name="code" value="4">
        <div class="form-group">
            <label for="drug_code" class="col-sm-3 control-label">药品编码</label>
            <div class="col-sm-9">
                <input type="text" id="drug_code" class="form-control"  name="drug_code" value="${drugInfo.drug_code}">
            </div>
        </div>

        <div class="form-group">
            <label for="drug_name" class="col-sm-3 control-label">药品名称</label>
            <div class="col-sm-9">
                <input type="text" id="drug_name" class="form-control"  name="drug_name" value="${drugInfo.drug_name}">
            </div>
        </div>

        <div class="form-group">
            <label for="drug_format" class="col-sm-3 control-label">药品规格</label>
            <div class="col-sm-9">
                <input type="text" id="drug_format" class="form-control" name="drug_format" value="${drugInfo.drug_format}">
            </div>
        </div>

        <!-- 其他表单字段省略 -->
        <div class="form-group">
            <label for="drug_unit" class="col-sm-3 control-label">药品单位</label>
            <div class="col-sm-9">
                <input type="text" id="drug_unit" class="form-control"  name="drug_unit" value="${drugInfo.drug_unit}">
            </div>
        </div>

        <div class="form-group">
            <label for="manufacturer" class="col-sm-3 control-label">生产厂家</label>
            <div class="col-sm-9">
                <input type="text" id="manufacturer" class="form-control"  name="manufacturer" value="${drugInfo.manufacturer}">
            </div>
        </div>

        <div class="form-group">
            <label for="drug_dosage" class="col-sm-3 control-label">药品剂型</label>
            <div class="col-sm-9">
                <input type="text" id="drug_dosage" class="form-control" name="drug_dosage" value="${drugInfo.drug_dosage}">
            </div>
        </div>

        <div class="form-group">
            <label for="drug_type" class="col-sm-3 control-label">药品类型</label>
            <div class="col-sm-9">
                <input type="text" id="drug_type" class="form-control"  name="drug_type" value="${drugInfo.drug_type}">
            </div>
        </div>

        <div class="form-group">
            <label for="drug_price" class="col-sm-3 control-label">药品价格</label>
            <div class="col-sm-9">
                <input type="text" id="drug_price" class="form-control"  name="drug_price" value="${drugInfo.drug_price}">
            </div>
        </div>

        <div class="form-group">
            <label for="mnemonic_code" class="col-sm-3 control-label">助记码</label>
            <div class="col-sm-9">
                <input type="text" id="mnemonic_code" class="form-control"  name="mnemonic_code" value="${drugInfo.mnemonic_code}">
            </div>
        </div>

<%--        <div class="form-group">--%>
<%--            <label for="creation_date" class="col-sm-3 control-label">创建日期</label>--%>
<%--            <div class="col-sm-9">--%>
<%--                <input type="text" id="creation_date" class="form-control"  name="creation_date" value="${drugInfo.creation_date}">--%>
<%--            </div>--%>
<%--        </div>--%>


        <div class="form-group">
            <div class="text-center col-sm-12">
                <button id="updateDrugBtn" type="submit" class="btn btn-primary">保存</button>
            </div>
            <div class="text-center col-sm-12">
                <button onclick="goBack()" type="button" class="btn btn-primary">返回</button>
            </div>
        </div>
    </form>
</div>

</body>

<script>
    function goBack() {
        history.back();
    }
</script>

</html>
