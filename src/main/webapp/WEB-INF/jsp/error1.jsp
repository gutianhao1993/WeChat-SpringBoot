<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet"
          href="bootstrap\css\style.css"/>
    <link rel="stylesheet" href="weui-master\dist\style\weui.css">
    <link rel="stylesheet" href="weui-master\dist\example\example.css">

    <script src="bootstrap\js\jquery.min.js"></script>
    <script src="weui-master\dist\example\zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

    <title>用户登录</title>

</head>
<body>
<div class="page icons js_show">
    <div class="page__bd page__bd_spacing">
        <div class="icon-box">
            <i class="weui-icon-warn weui-icon_msg"></i>
            <div class="icon-box__ctn">
                <h3 class="icon-box__title">绑定失败!</h3>
                <p class="icon-box__desc">输入账号不存在或密码错误!</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>