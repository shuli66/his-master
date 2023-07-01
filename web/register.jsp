<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>注册</title>
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
  <h2 class="text-center">医疗管理系统</h2>
  <!--  ctrl + k 格式化代码 -->
  <form class="form-horizontal" id="login" action="login_check" method="post">
    <div class="form-group">
      <label for="realname" class="col-sm-3 control-label">账户</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon" id="basic-addon1">
								<i class="glyphicon glyphicon-user"></i>
							</span>
          <input type="text" id="realname" class="in form-control" placeholder="请输入用户名" name="realname">
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
          <input id="password" type="password" class="in form-control" placeholder="请输入密码" name="password">
          <span class="glyphicon form-control-feedback" style="padding-right: 62px;"
                aria-hidden="true"></span>
          <span class="input-group-addon" id="btn-eye">
								<i class="glyphicon glyphicon-eye-close"></i>
							</span>
        </div>
      </div>
    </div>
    <div class="form-group">
      <label for="password2" class="col-sm-3 control-label" >确认密码</label>
      <div class="col-sm-9">
        <div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</span>
          <input id="password2" type="password" class="in form-control" placeholder="请确认密码" name="password2">
          <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
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
                <option value="1">心血管内科</option>
                <option value="2">神经内科</option>
                <option value="3">普通内科</option>
                <option value="4">消化内科</option>
                <option value="5">呼吸内科</option>
                <option value="6">内分泌科</option>
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

          <select  class="form-control" name="register_level_id" id="register_level_id">
            <option value="1">专家号</option>
            <option value="2">普通号</option>
            <option value="3">主任医生号</option>
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
            <option value="1">星期一三五上午</option>
            <option value="2">星期一三五下午</option>
            <option value="3">星期二四六上午</option>
            <option value="4">星期二四六下午</option>
            <option value="5">周六周日全天</option>
          </select>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="text-center col-sm-12">
        <button id="register_btn" type="button" class="btn btn-primary">注册</button>

      </div>



    </div>
  </form>
</div>

 <script>
<%--  $(".in").blur(function() {--%>
<%--    var code = $(this).val().trim();--%>
<%--    if ($(this).attr("id") == "password2") {--%>
<%--      if (code != $("#password").val()) {--%>
<%--        alert("两次密码不一致");--%>
<%--        $(this).parent().addClass("has-error");--%>
<%--        $(this).parent().removeClass("has-success");--%>
<%--        $(this).next().addClass("glyphicon-remove");--%>
<%--        $(this).next().removeClass("glyphicon-ok");--%>
<%--        return false;--%>
<%--      }--%>
<%--    }--%>
<%--    if ("" == code) {--%>
<%--      $(this).parent().addClass("has-error");--%>
<%--      $(this).parent().removeClass("has-success");--%>
<%--      $(this).next().addClass("glyphicon-remove");--%>
<%--      $(this).next().removeClass("glyphicon-ok");--%>
<%--    } else {--%>
<%--      $(this).parent().addClass("has-success");--%>
<%--      $(this).parent().removeClass("has-error");--%>
<%--      $(this).next().removeClass("glyphicon-remove");--%>
<%--      $(this).next().addClass("glyphicon-ok");--%>
<%--    }--%>
<%--    $(this).val(code);--%>
<%--  });--%>

<%--  var a = false;--%>
<%--  $("#btn-eye").click(function() {--%>
<%--    if (a) {--%>
<%--      $(this).children().addClass("glyphicon-eye-close");--%>
<%--      $(this).children().removeClass("glyphicon-eye-open");--%>
<%--      $("#password").attr("type", "password");--%>
<%--      a = false;--%>
<%--    } else {--%>
<%--      $(this).children().addClass("glyphicon-eye-open");--%>
<%--      $(this).children().removeClass("glyphicon-eye-close");--%>
<%--      $("#password").attr("type", "text");--%>
<%--      a = true;--%>
<%--    }--%>
<%--  });--%>

  $("#register_btn").click(function() {
    var realname = $("#realname").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();
    var deptment_id = $("#deptment_id").val();
    var register_level_id = $("#register_level_id").val();
    var scheduling_id = $("#scheduling_id").val();

    $.post("login_check", {
      code:2,
      realname: realname,
      deptment_id: deptment_id,
      password: password,
      password2: password2,
      register_level_id:register_level_id,
      scheduling_id: scheduling_id

    }, function(data) {//服务器返回的数据
      if (data) {
        alert("注册成功");
        window.location.href = "login.jsp";
      } else {
        alert("注册失败");
      }
    });
  });

</script>

  </body>
</html>
