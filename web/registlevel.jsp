<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>医院职称信息</title>
    <link href="html/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
</head>
<body>
<h1 align="center">职称信息</h1>
<form action="login_check" class="form-inline" style="width: 95%;margin: 30px auto;">
    <input type="hidden" name="code" value="9">
    <div class="form-group">
        <input type="text" class="form-control" name="registName" placeholder="请输入职称名字">
    </div>
    <button type="submit" class="btn btn-success">查询</button>
    <button type="button" onclick="javascript:location.href='addregist.jsp'" class="btn btn-primary">添加职称</button>
</form>
<table style="width: 95%;margin: -20px auto;text-align: center" class="table">
    <tr>
        <td>序号</td>
        <td>职称编码</td>
        <td>职称名字</td>
        <td>挂号费用</td>
        <td>挂号限额</td>
        <td>显示顺序号</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${newlist}" var="regist" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
<%--            <td>${regist.id}</td>--%>
            <td>${regist.regist_code}</td>
            <td>${regist.regist_name}</td>
            <td>${regist.regist_fee}</td>
            <td>${regist.regist_quota}</td>
            <td>${regist.sequence_no}</td>
            <td>
                <button class="btn btn-primary" onclick="updateRegist(${regist.id})">编辑</button>
                <button class="btn btn-danger" onclick="delRegist(${regist.id})">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function delRegist(id){
        if (confirm("确定删除吗？")){
            location.href = "login_check?code=10&id=" + id;
        }
    }
    function updateRegist(id){
        location.href = "login_check?code=11&id=" + id;
    }
</script>
</body>
</html>
