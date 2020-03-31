<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <link rel="stylesheet"
          href="bootstrap\css\style.css"/>
    <link rel="stylesheet" href="weui-master\dist\style\weui.css">
    <link rel="stylesheet" href="weui-master\dist\example\example.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/SuspendedBall.css">
    <link rel="stylesheet" href="IScroll/scrollbar.css">
    <link href="jquery-ui-1.10.4.custom/css/cupertino/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css"/>
    <link href="jquery-ui-1.10.4.custom/development-bundle/themes/smoothness/jquery.ui.core.css" rel="stylesheet"
          type="text/css"/>
    <link href="jquery-ui-1.10.4.custom/css/edit.jqueryui.theme.css" rel="stylesheet" type="text/css"/>

    <script src="bootstrap\js\jquery.min.js"></script>
    <script src="jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/realTimeAlarm.js" type="text/javascript"></script>
    <script src="IScroll/iscroll.js"></script>
    <script src="weui-master\dist\example\zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
    <script src="bootstrap/js/bootstrap-tab.js"></script>
    <script src="js/SuspendedBall.js"></script>
    <script src="js/PublicJs.js"></script>


    <title>实时告警</title>

    <style type="text/css">
        .weui-grid {
            padding: 20px 10px 10px 10px;
            width: 100%;
            border-bottom: 10px solid #dddddd;
        }

        .weui-grid__label {
            margin: 5px 0;
        }

        .span_left {
            display: inline;
            float: left;
        }

        .span_right {
            text-align: right;
            display: inline;
            float: right;
        }

        .Level {
            text-align: right;
            display: inline;
            float: right;
        }

        .section p {
            margin: 0;
        }

        .info {
            font-weight: bold;
            border-bottom: 1px solid #dddddd;
        }

        .modal-body {
            padding: 10px 20px;
        }

        .content {
            padding: 0 15px;
        }

        .btn {
            padding: 6px 8px;
        }

        .tab-pane {
            padding: 10px 20px;
        }

        .areaNameList {
            padding: 5px 0;
            cursor: pointer;
        }

        .condition1 {
            padding: 10px 0;
        }

        .condition2 {
            padding: 10px 0;
        }

        #content {
            height: 120px;
            overflow: auto;
        }

        #outer {
            display: block;
            white-space: nowrap;
            overflow-x: auto;
            overflow-y: hidden;
        }

        body {
            -webkit-user-select: none;
            -webkit-text-size-adjust: none;
            font-family: helvetica;
        }

        #header {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 45px;
            line-height: 45px;
            background-image: -webkit-gradient(linear, 0 0, 0 100%, color-stop(0, #858585), color-stop(0.05, #848484), color-stop(1, #838B83));
            background-image: -moz-linear-gradient(top, #858585, #848484 5%, #838B83);
            background-image: -o-linear-gradient(top, #858585, #848484 5%, #838B83);
            padding: 0;
            color: #eee;
            font-size: 20px;
            text-align: center;
            display: block;
            white-space: nowrap;
            overflow-x: auto;
            overflow-y: hidden;
            padding: 0px 20px;
        }

        #header a {
            color: #f3f3f3;
            text-decoration: none;
            font-weight: bold;
            text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.5);
        }

        #footer {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 48px;
            background-image: -webkit-gradient(linear, 0 0, 0 100%, color-stop(0, #999), color-stop(0.02, #666), color-stop(1, #222));
            background-image: -moz-linear-gradient(top, #999, #666 2%, #222);
            background-image: -o-linear-gradient(top, #999, #666 2%, #222);
            padding: 0;
            border-top: 1px solid #444;
        }

        #wrapper {
            position: absolute;
            z-index: 1;
            top: 45px;
            bottom: 48px;
            left: 0;
            width: 100%;
            background: #555;
            overflow: auto;
        }

        #scroller {
            position: relative;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            float: left;
            width: 100%;
            padding: 0;
        }

        #scroller li > a {
            display: block;
        }

        #pullDown, #pullUp {
            background: #fff;
            height: 51px;
            line-height: 40px;
            padding: 5px 10px;
            border-bottom: 1px solid #ccc;
            font-weight: bold;
            font-size: 14px;
            color: #888;
        }

        #pullDown .pullDownIcon, #pullUp .pullUpIcon {
            display: block;
            float: left;
            width: 40px;
            height: 40px;
            -webkit-background-size: 40px 80px;
            background-size: 40px 80px;
            -webkit-transition-property: -webkit-transform;
            -webkit-transition-duration: 250ms;
        }

        #pullDown .pullDownIcon {
            -webkit-transform: rotate(0deg) translateZ(0);
        }

        #pullUp .pullUpIcon {
            -webkit-transform: rotate(-180deg) translateZ(0);
        }

        #pullDown.flip .pullDownIcon {
            -webkit-transform: rotate(-180deg) translateZ(0);
        }

        #pullUp.flip .pullUpIcon {
            -webkit-transform: rotate(0deg) translateZ(0);
        }

        #pullDown.loading .pullDownIcon, #pullUp.loading .pullUpIcon {
            background-position: 0 100%;
            -webkit-transform: rotate(0deg) translateZ(0);
            -webkit-transition-duration: 0ms;

            -webkit-animation-name: loading;
            -webkit-animation-duration: 2s;
            -webkit-animation-iteration-count: infinite;
            -webkit-animation-timing-function: linear;
        }

        @-webkit-keyframes loading {
            from {
                -webkit-transform: rotate(0deg) translateZ(0);
            }
            to {
                -webkit-transform: rotate(360deg) translateZ(0);
            }
        }
    </style>
</head>
<body>
<div id="header">全部地区
</div>
<div id="wrapper">
    <div id="scroller">
        <div id="pullDown">
            <span class="pullDownIcon"></span><span class="pullDownLabel">下拉刷新...</span>
        </div>
        <div class="page grid js_show">
            <div id="alarms" class="weui-grids">
            </div>
        </div>
        <div id="pullUp">
            <span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span>
        </div>
        <!-- 触发模态窗口的按钮 -->
        <button id="button1" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                style="position: absolute; top: 50%;transform: translateX(-50%)translateY(-50%);display: none;">
            点击选择
        </button>
    </div>
</div>
<div id="footer"></div>

<!-- 模态窗口 -->
<div class="modal fade modal-fullscreen" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="myModalLabel">查询条件</h4>
            </div>
            <div id="body" class="modal-body">
                <div class="input-group condition">
                    <span class="input-group-addon" style="background-color: #428bca;color: white;">机房名称:</span>
                    <input id="suName" type="text" class="form-control" placeholder="">
                </div>
                <div class="condition1">
                    <span>时间范围(单选):</span>
                    <br>
                    <button id="AllDay" type="button" class="btn btn-default">全部</button>
                    <button id="Today" type="button" class="btn btn-default">24小时</button>
                    <button id="ThreeDays" type="button" class="btn btn-default">近三天</button>
                    <button id="OneWeek" type="button" class="btn btn-default">近一周</button>
                    <button id="OneMonth" type="button" class="btn btn-default">近一月</button>
                </div>
                <div class="condition2">
                    <span>告警级别:</span>
                    <br>
                    <button type="button" class="btn btn-default">全部</button>
                    <button type="button" class="btn btn-default">一级</button>
                    <button type="button" class="btn btn-default">二级</button>
                    <button type="button" class="btn btn-default">三级</button>
                    <button type="button" class="btn btn-default">四级</button>
                </div>
                <section class="panel panel-primary">
                    <header class="panel-heading">地区选择</header>
                    <div id="TotalArea" style="font-size: 15px;">
                        <div class="content">
                            <div class="main-inner">
                                <div id="outer">
                                    <ul class="nav-tabs" id="tabs" role="tablist" id="contentTabs">
                                        <li class="homeNav active" id="tab_tab_area0"><a
                                                href="#area" id="area" role="tab" data-toggle="tab"
                                                class="homePage">请选择</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tab-content" id="content">
                                    <div class="tab-pane active" role="tabpanel" id="tab_area0">
                                        <ul id="areaNameList0"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="confirm">确定</button>
                <button type="button" class="btn btn-info" id="reset">重置</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
