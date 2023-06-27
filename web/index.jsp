<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>HIS</title>
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  <style>
    body{
      background-image: url(images/bg.png);
      background-repeat: no-repeat;
    }
    .main-box{
      width: 400px; 
      background-color: rgba(255,255,255,0.7);
      border-radius: 5px;
      position: absolute;
      top:50%;
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
  <form class="form-horizontal" id="login" action="login_check">
    <div class="form-group">
      <label for="code" class="col-sm-2 control-label">账号</label>
      <div class="col-sm-10">
        <div class="input-group">
							<span class="input-group-addon" id="basic-addon1">
								<i class="glyphicon glyphicon-user"></i>
							</span>
          <input type="text" id="code" class="form-control" placeholder="请输入账号" name="username">
          <span id="icon" class="glyphicon form-control-feedback" aria-hidden="true"></span>
        </div>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">密码</label>
      <div class="col-sm-10">
        <div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</span>
          <input id="pwd" type="password" class="form-control" placeholder="请输入密码" name="password">
          <span id="icon2" class="glyphicon form-control-feedback" style="padding-right: 62px;" aria-hidden="true"></span>
          <span class="input-group-addon" id="btn-eye">
								<i class="glyphicon glyphicon-eye-close"></i>
							</span>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="text-center col-sm-12">
        <a href="register.html" id="register_btn" type="button" class="btn btn-primary">注册</a>
        <button id="login_btn" type="button" class="btn btn-success">登录</button>
      </div>
    </div>
  </form>
</div>
<script>
  $("#code").blur(function() {
    var code = $(this).val().trim();
    if ("" == code) {
      $(this).parent().addClass("has-error");
      $(this).parent().removeClass("has-success");
      $("#icon").addClass("glyphicon-remove");
      $("#icon").removeClass("glyphicon-ok");
    }else{
      $(this).parent().addClass("has-success");
      $(this).parent().removeClass("has-error");
      $("#icon").removeClass("glyphicon-remove");
      $("#icon").addClass("glyphicon-ok");
    }
    $(this).val(code);
  });
  $("#pwd").blur(function(){
    var pwd = $(this).val().trim();
    if ("" == pwd) {
      $(this).parent().addClass("has-error");
      $(this).parent().removeClass("has-success");
      $("#icon2").addClass("glyphicon-remove");
      $("#icon2").removeClass("glyphicon-ok");
    }else{
      $(this).parent().addClass("has-success");
      $(this).parent().removeClass("has-error");
      $("#icon2").removeClass("glyphicon-remove");
      $("#icon2").addClass("glyphicon-ok");
    }
    $(this).val(pwd);
  });
  var a = false;
  $("#btn-eye").click(function() {
    if (a) {
      $(this).children().addClass("glyphicon-eye-close");
      $(this).children().removeClass("glyphicon-eye-open");
      $("#pwd").attr("type", "password");
      a = false;
    } else {
      $(this).children().addClass("glyphicon-eye-open");
      $(this).children().removeClass("glyphicon-eye-close");
      $("#pwd").attr("type", "text");
      a = true;
    }
  });
  $("#login_btn").click(function () {
    var code = $("#code").val();
    var pwd = $("#pwd").val();
    if (code == "" || pwd == "") {
      return false;
    }
    $.post("login_check", {
      username: code,
      password: pwd
    }, function (data) {
      if (data === "true") { // 登录成功
        alert("登录成功");
        window.location.href = "zhenduan.html?id=" + data.id;
      } else { // 登录失败
        alert("登录失败");
      }
    });
  });

</script>
</body>
</html>
