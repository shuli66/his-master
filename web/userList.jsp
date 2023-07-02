<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>医生信息</title>
    <link href="html/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center;color: #00a2d4;font-weight: bold;">医生信息</h1>

<table class="table" style="text-align: center">
    <tr style="color: #568c0a;font-weight: bold;">
        <td>序号</td>
        <td>账户</td>
        <td>科室</td>
        <td>职称</td>
        <td>排班</td>
    </tr>

    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.realname}</td>
            <td>${user.dept_name}</td>
            <td>${user.regist_name}</td>
            <td>${user.rule_name}</td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
