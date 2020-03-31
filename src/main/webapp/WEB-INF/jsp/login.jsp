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
          href="css/login.css"/>
    <link rel="stylesheet"
          href="bootstrap\css\style.css"/>
    <link rel="stylesheet" href="weui-master\dist\style\weui.css">
    <link rel="stylesheet" href="weui-master\dist\example\example.css">

    <script src="bootstrap\js\jquery.min.js"></script>
    <script src="js/login.js"></script>
    <script src="weui-master\dist\example\zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

    <title>用户登录</title>

    <style type="text/css">

        body {
            background-size: 100%;
        }
    </style>

    <script type="text/javascript">
        function submit() {
            document.fileForm.submit();
        }
    </script>
</head>
<body ontouchstart style="background-color: #eee;">
<div class="jumbotron" style="text-align: center">
    <div class="container" style="margin-top: 10%;height: 100px;display: inline-block;">
        <img src="image\logo_new.png" style="margin-bottom: 15px;">
        <div class="title">
            <h3 class="glow tlt" style="height:34px;font-size: 25.0714px;"><span style="visibility: hidden;">
                <span class="word1" style="display: inline-block; transform: translate3d(0px, 0px, 0px);">
                    <span class="char1" style="display: inline-block; visibility: visible;">亚</span>
                    <span class="char2" style="display: inline-block; visibility: visible;">奥</span>
                    <span class="char3" style="display: inline-block; visibility: visible;">微</span>
                    <span class="char4" style="display: inline-block; visibility: visible;">动</span>
                    <span class="char5" style="display: inline-block; visibility: visible;">环</span>
                    <li class="current">亚奥微动环</li>
                    </ul>
                </span>
            </span>
            </h3>
        </div>
    </div>

    <form action="bind.do" class="bs-example bs-example-form" role="form"
          method="post" name="fileForm">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell weui-cell_vcode" style="height: 40px;">
                <div class="weui-cell__hd">
                    <label class="weui-label">用户名:</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="请输入账号" name="name">
                </div>
            </div>
            <div class="weui-cell weui-cell_vcode" style="height: 40px;">
                <div class="weui-cell__hd">
                    <label class="weui-label">密码:</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="password" placeholder="请输入密码" name="password">
                </div>
            </div>
        </div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:" id="showTooltips" onclick="submit()">登录</a>
        </div>
    </form>
    <div class="page__bd page__bd_spacing">
        <div class="weui-footer">
            <p class="weui-footer__text">Copyright © 2018 江苏亚奥科技股份有限公司. <br/>All Rights Reserved</p>
        </div>
    </div>
</div>
</body>
</html>