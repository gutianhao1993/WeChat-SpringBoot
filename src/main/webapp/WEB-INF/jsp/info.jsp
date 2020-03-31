<%@ page import="java.util.List" %>
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
    <script src="js/info.js"></script>
    <script src="weui-master\dist\example\zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>

    <title>用户信息</title>

    <style type="text/css">
        #showIOSDialog {
            width: 80%;
            margin: 20px auto;
            background-color: #1AAD19;
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div class="page icons js_show">
    <div class="page__bd page__bd_spacing">
        <div class="icon-box">
            <i class="weui-icon-info weui-icon_msg"></i>
            <div class="icon-box__ctn">
                <h3 class="icon-box__title">用户登录信息</h3>
                <p class="icon-box__desc">您当前登录的账号为:&nbsp&nbsp${sessionScope.result}</p>
            </div>
        </div>
    </div>

    <a href="javascript:;" class="weui-btn weui-btn_default" id="showIOSDialog">退出登录</a>
</div>
<div id="dialogs">
    <div class="js_dialog" id="iosDialog" style="display: none;">
        <div class="weui-mask"></div>
        <div class="weui-dialog">
            <div class="weui-dialog__hd"><strong class="weui-dialog__title">退出登录</strong></div>
            <div class="weui-dialog__bd">是否确认将此微信号与登录账号解除绑定?</div>
            <div class="weui-dialog__ft">
                <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">取消</a>
                <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2flogin.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect"
                   class="weui-dialog__btn weui-dialog__btn_primary"
                   id="confirmUnbinding">确定</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>