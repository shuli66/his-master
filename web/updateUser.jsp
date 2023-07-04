<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改个人信息</title>
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
  <h2 class="text-center">修改医生信息</h2>

  <form class="form-horizontal" id="login" action="login_check" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="hidden" name="code" value="7">
    <div class="form-group">
      <label for="realname" class="col-sm-3 control-label">账号</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon" id="basic-addon1">
								<i class="glyphicon glyphicon-user"></i>
							</span>
          <input type="text" id="realname" class="in form-control" placeholder="请输入用户名" name="realname" value="${employee.realname}">
          <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
        </div>
      </div>
    </div>

    <div class="form-group">
      <label  class="col-sm-3 control-label">密码</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</span>
          <input id="password" type="text" class="in form-control" placeholder="请输入密码" name="password" value="${employee.password}">
          <span class="glyphicon form-control-feedback" style="padding-right: 62px;"
                aria-hidden="true"></span>
          <span class="input-group-addon" id="btn-eye">
								<i class="glyphicon glyphicon-eye-close"></i>
							</span>
        </div>
      </div>
    </div>

    <div class="form-group">
      <%--@declare id="code"--%>
      <label for="code" class="col-sm-3 control-label">科室</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon">
								<i class="	glyphicon glyphicon-book"></i>
							</span>
          <%--          <input id="code" type="text" class="in form-control" placeholder="请输入账户">--%>
          <span class="glyphicon form-control-feedback" aria-hidden="true"></span>

          <select  class="form-control" name="deptment_id" id="deptment_id">

            <c:forEach items="${deptList}" var="dept">
              <option value="${dept.id}" ${employee.deptment_id==dept.id?'selected':''}>${dept.dept_name}</option>
            </c:forEach>


          </select>

        </div>
      </div>
    </div>
    <div class="form-group">
      <%--@declare id="code"--%>
      <label for="code" class="col-sm-3 control-label">职称</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon">
								<i class="	glyphicon glyphicon-book"></i>
							</span>
          <%--          <input id="code" type="text" class="in form-control" placeholder="请输入账户">--%>
          <span class="glyphicon form-control-feedback" aria-hidden="true"></span>

          <select  class="form-control" name="regist_level_id" id="regist_level_id" >
            <option value="0">----请选择----</option>
            <option value="1" ${employee.regist_level_id==1?'selected':''}>专家号</option>
            <option value="2" ${employee.regist_level_id==2?'selected':''}>普通号</option>
            <option value="3" ${employee.regist_level_id==3?'selected':''}>主任医生号</option>
          </select>

        </div>
      </div>
    </div>
    <div class="form-group">
      <label  class="col-sm-3 control-label">排班</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon">
								<i class="	glyphicon glyphicon-folder-open"></i>
							</span>
          <select id="scheduling_id" class="form-control" name="scheduling_id" >
            <option value="0">----请选择----</option>
            <option value="1" ${employee.scheduling_id==1?'selected':''}>星期一三五上午</option>
            <option value="2" ${employee.scheduling_id==2?'selected':''}>星期一三五下午</option>
            <option value="3" ${employee.scheduling_id==3?'selected':''}>星期二四六上午</option>
            <option value="4" ${employee.scheduling_id==4?'selected':''}>星期二四六下午</option>
            <option value="5" ${employee.scheduling_id==5?'selected':''}>周六周日全天</option>
          </select>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="text-center col-sm-12">
        <button id="register_btn" type="submit" class="btn btn-primary">保存</button>

      </div>



    </div>
  </form>
</div>

</body>
</html>
