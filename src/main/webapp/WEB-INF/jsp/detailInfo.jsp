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
    <link rel="stylesheet" href="jquery.mloading-master/src/jquery.mloading.css">

    <script src="bootstrap\js\jquery.min.js"></script>
    <script src="js/detailInfo.js"></script>
    <script src="weui-master\dist\example\zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
    <script src="jquery.mloading-master/src/jquery.mloading.js"></script>
    <title>告警详细信息</title>

    <style>
        .column {
            width: 30%;
            display: table;
        }

        .column > p {
            display: table-cell;
            vertical-align: middle;
        }

        .value {
            width: 70%;
            display: table;
        }

        .value > p {
            display: table-cell;
            vertical-align: middle;
        }

        .icon-box {
            margin: 0 !important;
        }

        .page__hd {
            padding: 30px;
        }

        .result {
            text-align: center;
            color: #285e8e;
        }

        .info {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="page grid js_show">
    <div class="page icons js_show" style="margin: 10px;">
        <div class="page__bd page__bd_spacing" style="padding: 0;">
            <div class="icon-box" style="transform: translateX(50%);width: 210px">

                <i id="levelicon"></i>
                <div class="icon-box__ctn">
                    <h3 id="LevelInfo" class="icon-box__title"></h3>
                </div>
            </div>
        </div>
    </div>
    <div class="weui-grids">
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">告警编号</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="AlarmNo" class="weui-grid__label result">未知</p>
        </a>
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">FSU名称</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="FSUName" class="weui-grid__label result">未知</p>
        </a>
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">监控对象名称</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="SoName" class="weui-grid__label result">未知</p>
        </a>
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">监控点名称</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="SensorName" class="weui-grid__label result">未知</p>
        </a>
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">告警地区</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="AreaName" class="weui-grid__label result">未知</p>
        </a>
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">告警发生时间</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="AlarmTime" class="weui-grid__label result">未知</p>
        </a>
        <a href="javascript:;" class="weui-grid column">
            <p class="weui-grid__label info">描述</p>
        </a>
        <a href="javascript:;" class="weui-grid value">
            <p id="AlarmMsg" class="weui-grid__label result">未知</p>
        </a>
    </div>
</div>
</body>
</html>
