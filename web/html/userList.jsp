<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>医生信息</title>
</head>
<body>
<h1>医生信息</h1>

<table>
    <tr>
        <td>序号</td>
        <td>账户</td>
        <td>科室</td>
        <td>职称</td>
        <td>排班</td>
    </tr>

    <%
        String[] list = {"医生","原神","蜂蜜","锦辉","ajks"};
        request.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s}</td>
            <td>个人人防</td>
            <td>二凤飞飞</td>
            <td>让他突然</td>
            <td>天天同仁</td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
