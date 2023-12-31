<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>医生信息</title>
    <link href="html/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center;color: #00a2d4;font-weight: bold;">医生信息</h1>

<form action="login_check" class="form-inline"  style="width: 95%;margin: 30px auto">
    <input type="hidden" name="code" value="8">
    <div class="form-group">
        <input type="text" class="form-control"  name="realname" placeholder="请输入账号">
    </div>
    <button type="submit" class="btn btn-success">查询</button>
    <button type="button" class="btn btn-primary" onclick="javascript:location.href='addUser.jsp'">添加</button>
</form>

<table class="table" style="text-align: center">
    <tr style="color: #568c0a;font-weight: bold;">
        <td>序号</td>
        <td>账户</td>
        <td>科室</td>
        <td>职称</td>
        <td>排班</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${list}" var="user" varStatus="status">
        <tr>
<%--            <td>${user.id}</td>--%>
            <td>${status.index+1}</td>
            <td>${user.realname}</td>
            <td>${user.dept_name}</td>
            <td>${user.regist_name==null?"---":user.regist_name}</td>
            <td>${user.rule_name==null?"---":user.rule_name}</td>
            <td>
                <button class="btn btn-primary" onclick="updateUser(${user.id})">编辑</button>
                <button class="btn btn-danger" onclick="delUser(${user.id})" >删除</button>
            </td>
        </tr>
    </c:forEach>


</table>
<script>
    function delUser(id){
        if (confirm("确定删除？")){
            location.href = "login_check?code=5&id="+id;
        }
    }

    function updateUser(id) {
        location.href = "login_check?code=6&id="+id;
    }
</script>

</body>
</html>
