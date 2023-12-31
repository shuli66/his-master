
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .input-label {
            display: inline-block;
            width: 180px;
            white-space: nowrap;
        }

        .input-wrapper {
            display: inline-block;
            width: calc(100% - 180px);
        }

        body {
            background: url("images/bg.png");
            background-size: 100%;
        }
    </style>

<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>HIS医疗管理系统挂号页面</title>
    <meta name="keywords" >
    <meta name="description" >

    <link rel="shortcut icon" href="favicon.ico"> <link href="html/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="html/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="html/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="html/css/animate.min.css" rel="stylesheet">
    <link href="html/css/style.min.css?v=4.0.0" rel="stylesheet">
<%--    <base target="_blank">--%>
<%--    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>--%>

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">HIS</h1>
        </div>
        <h3>创建一个HIS医疗管理系统挂号职称</h3>
        <form class="m-t" role="form"  action="login_check" >
            <input type="hidden" name="code" value="12">
            <div class="form-group row">
                <label class="col-sm-4 col-form-label" style="white-space: nowrap;">请输入职称编码:</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <input type="text" class="form-control" name="regist_code">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-4 col-form-label" style="white-space: nowrap;">请输入职称名字:</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <input type="text" name="regist_name" class="form-control">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-4 col-form-label" style="white-space: nowrap;">请输入挂号费用:</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <input type="text" class="form-control" name="regist_fee">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-4 col-form-label" style="white-space: nowrap;">请输入挂号限额:</label>
                <div class="col-sm-8">
                    <div class="input-group">
                        <input type="text" class="form-control" name="regist_quota">
                    </div>
                </div>
            </div>
            <div class="form-group text-left">
                <div class="checkbox i-checks">
                    <label class="no-padding">
                        <input type="checkbox"><i></i> 我同意注册创建协议
                    </label>
                </div>
            </div>

            <input type="submit" class="btn btn-primary block full-width m-b" value="创建"><br/><br/>
            <span>
                ${res}
            </span>
        </form>
    </div>
</div>
<script src="html/js/jquery.min.js?v=2.1.4"></script>
<script src="html/js/bootstrap.min.js?v=3.3.5"></script>
<script src="html/js/plugins/iCheck/icheck.min.js"></script>
<%--<script>--%>
<%--    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});--%>
<%--</script>--%>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>