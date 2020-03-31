var pageCurrent = 1;
var pageSize = 6;
document.addEventListener('DOMContentLoaded', loaded, false);

$(function () {
    //切换标签页激活状态
    $('#area').click(function () {
        $('#content div').removeClass('active');
        $('#tab_area0').addClass('active');
    });

    //模态框确认绑定点击事件
    $('#confirm').click(function () {
        $('#alarms a').remove();
        pageCurrent = 1;
        var append = getRealTimeAlarm(pageCurrent);
        if (append != null && append != '') {
            $('#alarms').append(append);
            setLevel(pageSize);
            setDscLength();
            myScroll.refresh();
        } else {
            var curWwwPath = window.document.location.href;
            var pathName = window.document.location.pathname;
            var pos = curWwwPath.indexOf(pathName);
            var localhostPaht = curWwwPath.substring(0, pos);
            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 2);
            window.location.href = localhostPaht + projectName + 'noResult.do';
        }
    });

    //模态框重置绑定点击事件
    $('#reset').click(function () {
        $('#suName').val('');
        $('#body button').attr('class', 'btn btn-default');
        $('#tabs>li:first').nextAll().remove();
        $('#area')[0].innerText = '请选择';
        $('#content>div:first').nextAll().remove();
        $('#tab_area0').addClass('active');
    });

    getLocations();
    autoComplete();

    //查询按钮绑定事件
    $('.condition1 button').on('click', function () {
        $('.condition1 button').attr('class', 'btn btn-default');
        $(this).removeClass('btn-default');
        $(this).addClass('btn-primary');
    });

    $('.condition2 button').on('click', function () {
        $('.condition2 button').attr('class', 'btn btn-default');
        $(this).removeClass('btn-default');
        $(this).addClass('btn-primary');
    });

    //悬浮球
    SuspendedBall.Add();
    SuspendedBall.BoxHtml('');
    SuspendedBall.Move(UpFun);

    //首次加载页面 查询所有
    var append = getRealTimeAlarm(pageCurrent);
    if (append != null && append != '') {
        $('#alarms').append(append);
        setLevel(pageSize);
        setDscLength();
    }
});

//查询获取告警
function getRealTimeAlarm(pageCurrent) {
    var append = '';
    var imgs = document.getElementById('tabs').getElementsByTagName('a');
    var areaName = imgs[imgs.length - 1].innerText;
    var areaID = '';
    if (areaName != '请选择') {
        areaID = imgs[imgs.length - 1].dataset.area;
    } else if (imgs.length >= 2) {
        areaID = imgs[imgs.length - 2].dataset.area;
    }
    //拼接各级地区
    var areaNames = '';
    $.each(imgs, function (i, obj) {
        if (imgs[i].innerText != '请选择' && imgs[i].innerText != '系统') {
            areaNames += imgs[i].innerText;
            areaNames += ' ';
        }
    });
    areaNames = areaNames.substring(areaNames.length - 1) == ' ' ? areaNames.substring(0, areaNames.length - 1) : areaNames;
    if (areaNames.trim() == '') {
        areaNames = '全部区域';
    }
    $('#header').html(areaNames);
    var suName = document.getElementById('suName').value;

    var time = '';
    var timeButton = '';

    if ($('.condition1 .btn-primary').length != 0) {
        var timeButton = $('.condition1 .btn-primary')[0].innerText;
    }

    if (timeButton == '24小时') {
        var date = new Date();
        var month = date.getMonth() + 1;
        if (month <= 9) {
            month = "0" + month;
        }
        var day = date.getDate();
        if (day <= 9) {
            day = "0" + day;
        }
        var year = date.getFullYear();
        var hour = date.getHours();
        if (hour <= 9) {
            hour = "0" + hour;
        }
        var minute = date.getMinutes();
        if (minute <= 9) {
            minute = "0" + minute;
        }
        var second = date.getSeconds();
        if (second <= 9) {
            second = "0" + second;
        }

        var last = day - 1;
        if (last <= 9) {
            last = "0" + last;
        }
        time = year + "-" + month + "-" + last + " " + hour + ":" + minute + ":" + second;
    } else if (timeButton == '近三天') {
        var date = new Date();
        var month = date.getMonth() + 1;
        if (month <= 9) {
            month = "0" + month;
        }
        var day = date.getDate();
        if (day <= 9) {
            day = "0" + day;
        }
        var year = date.getFullYear();
        var hour = date.getHours();
        if (hour <= 9) {
            hour = "0" + hour;
        }
        var minute = date.getMinutes();
        if (minute <= 9) {
            minute = "0" + minute;
        }
        var second = date.getSeconds();
        if (second <= 9) {
            second = "0" + second;
        }

        var last = day - 3;
        if (last <= 9) {
            last = "0" + last;
        }
        time = year + "-" + month + "-" + last + " " + hour + ":" + minute + ":" + second;
    } else if (timeButton == '近一周') {
        var date = new Date();
        var lastweek = new Date(date.getTime() - 7 * 24 * 60 * 60 * 1000);

        var year = lastweek.getFullYear();
        var month = lastweek.getMonth() + 1;
        var day = lastweek.getDate();

        if (month <= 9) {
            month = "0" + month;
        }
        if (day <= 9) {
            day = "0" + day;
        }

        var hour = lastweek.getHours();
        var minute = lastweek.getMinutes();
        var second = lastweek.getSeconds();

        if (hour <= 9) {
            hour = "0" + hour;
        }

        if (minute <= 9) {
            minute = "0" + minute;
        }

        if (second <= 9) {
            second = "0" + second;
        }

        time = year + '-' + month + "-" + day + ' ' + hour + ":" + minute + ":" + second;
    } else if (timeButton == '近一月') {
        var date = new Date();
        var lastmonth = new Date(date.getTime() - 30 * 24 * 60 * 60 * 1000);

        var year = lastmonth.getFullYear();
        var month = lastmonth.getMonth() + 1;
        var day = lastmonth.getDate();

        if (month <= 9) {
            month = "0" + month;
        }
        if (day <= 9) {
            day = "0" + day;
        }

        var hour = lastmonth.getHours();
        var minute = lastmonth.getMinutes();
        var second = lastmonth.getSeconds();

        if (hour <= 9) {
            hour = "0" + hour;
        }
        if (minute <= 9) {
            minute = "0" + minute;
        }

        if (second <= 9) {
            second = "0" + second;
        }

        time = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }

    var alarmLevel = '';
    var levelButton = '';
    if ($('.condition2 .btn-primary').length != 0) {
        levelButton = $('.condition2 .btn-primary')[0].innerText;
    }
    if (levelButton == '一级') {
        alarmLevel = 1;
    } else if (levelButton == '二级') {
        alarmLevel = 2;
    } else if (levelButton == '三级') {
        alarmLevel = 3;
    } else if (levelButton == '四级') {
        alarmLevel = 4;
    }

    var url = 'getRealTimeAlarm.do';
    var params = {
        areaName: suName,
        areaID: areaID,
        startTime: time,
        alarmLevel: alarmLevel,
        pageCurrent: pageCurrent,
        pageSize: pageSize
    };
    $.ajax({
        async: false,
        type: 'post',
        data: params,
        url: url,
        dataType: 'json',
        success: function (data) {
            var result = data.list;
            for (var i in result) {
                append += '<a href="detailInfo.do?AlarmID=' + data.alarmID[i] + '&flag=1" class="weui-grid">' +
                    '<div><div class="weui-grid__label info">' + '<span class="span_left">' + result[i].soName +
                    '</span><span class="Level" data-level=' + result[i].alarmLevel +
                    '></span>' + '</div><div class="weui-grid__label"><span class="span_left dsc" ' +
                    'style="transform: translateY(50%);">' + result[i].dsc + '</span><div class="span_right"><div>'
                    + result[i].areaName + '</div><div>' + result[i].startTime + '</div></div></div></div></a>'
            }
        }
    });

    $('#myModal').modal('hide');
    return append;
}

//告警等级绑定事件
function setLevel(pageSize) {
    var Levels = document.getElementsByClassName('Level');
    var level;
    var Level;
    for (var i = Levels.length > pageSize ? Levels.length - pageSize : 0; i < Levels.length; i++) {
        level = Levels[i].dataset.level;
        if (level == 1) {
            Level = '一级';
            Levels[i].style.color = 'red';
        }
        if (level == 2) {
            Level = '二级';
            Levels[i].style.color = 'orange';
        }
        if (level == 3) {
            Level = '三级';
            Levels[i].style.color = 'blue';
        }
        if (level == 4) {
            Level = '四级';
            Levels[i].style.color = 'green';
        }
        Levels[i].innerText = Level;
    }
}

//防止告警描述文字过长,改变样式
function setDscLength() {
    var dscs = document.getElementsByClassName('dsc');
    $.each(dscs, function (i, obj) {
        if (dscs[i].clientWidth > 180) {
            dscs[i].style.transform = '';
            dscs[i].setAttribute('style', 'max-width:180px');
        }
    })
}

//模态框文本框自动补全
function autoComplete() {
    var url = 'getSuNames.do';
    $.ajax({
        async: false,
        url: url,
        dataType: 'json',
        type: 'post',
        timeout: 20000,
        success: function (data) {
            $("#suName").autocomplete({
                source: data.data,
                select: function (event, ui) {

                }
            });
            document.getElementById('ui-id-1').style.zIndex = '99999';
        }
    });
}

//悬浮球点击事件 显示模态框
function UpFun() {
    $('#button1').click();
}

//模态框地区选择
function getLocations() {
    $.ajax({
        async: true,
        url: 'getLocations.do',
        dataType: 'json',
        type: 'post',
        timeout: 20000,
        success: function (data) {
            var result = data.data;
            for (var i in result) {
                if (result[i].parentID == 0) {
                    $('#areaNameList0').append('<li class="areaNameList" id="' + result[i].areaID + '" onclick="setClick(this)">' + result[i].areaName + '</li>');
                }
            }
        }
    });
};

//点击选项列表时的点击事件
function setClick(obj) {
    var areaID = obj.id;
    var areaName = obj.innerHTML;
    var titleID = parseInt(obj.parentNode.id.replace('areaNameList', ''));
    var param = {
        "areaID": areaID
    };
    var url = 'getSubLocations.do';
    $.post(url, param, function (data) {
        var result = data.data;
        //若点击的区域还有子级区域,则生成下级选项卡
        if (result != null) {

            addTabs({
                id: 'area' + (titleID + 1),
                icon: '',
                title: '请选择',
                close: false,
                content: '<ul id="areaNameList' + (titleID + 1) + '"></ul>'
            });

            //若下级选项卡中的列表选项数为0则添加查询结果为选项
            var li_count = document.getElementById('areaNameList' + (titleID + 1)).childNodes.length;
            if (li_count == 0) {
                for (var i in result) {
                    $('#areaNameList' + (titleID + 1)).append('<li id="' + result[i].areaID + '" onclick="setClick(this)" class="areaNameList">' + result[i].areaName + '</li>');
                }
            }
            //点击选项,刷新下级列表
            else {
                $('#areaNameList' + (titleID + 1)).html('');
                for (var i in result) {
                    $('#areaNameList' + (titleID + 1)).append('<li id="' + result[i].areaID + '" onclick="setClick(this)" class="areaNameList">' + result[i].areaName + '</li>');
                }
                $('#tab_tab_area' + (titleID + 1))[0].childNodes[0].innerText = '请选择';
                var titles = $('#tabs li');
                $.each(titles, function (i, obj) {
                    var j = titles[i].id.replace('tab_tab_area', '');
                    if (j > titleID + 1) {
                        $('#tab_tab_area' + j).remove();
                        $('#tab_area' + j).remove();
                    }
                });
            }
        }
        //若点击的区域不存在子级区域
        else {
            var titles = $('#tabs li');
            $.each(titles, function (i, obj) {
                var j = titles[i].id.replace('tab_tab_area', '');
                if (j > titleID) {
                    $('#tab_tab_area' + j).remove();
                    $('#tab_area' + j).remove();
                }
            });
        }
        //tab标签名绑定
        $('#tab_tab_area' + titleID.toString())[0].childNodes[0].innerText = areaName;

        //tab标签绑定点击的areaName对应的areaID
        $('#tab_tab_area' + titleID.toString())[0].childNodes[0].setAttribute('data-area', areaID);

        //点击ul中的li,自动移动滚动条
        var ul_width = $('#outer ul')[0].clientWidth;
        var lis = $('#outer li');
        var li_width = 0;

        $.each(lis, function (i, obj) {
            li_width += lis[i].clientWidth;
        });

        if (ul_width < li_width) {
            $('#outer').scrollLeft($('#outer')[0].scrollWidth);
        }
    });

}


//IScroll插件
var myScroll, pullDownEl, pullDownOffset, pullUpEl, pullUpOffset = 0;

/**
 * 下拉刷新
 * myScroll.refresh();数据加载完成后，调用界面更新方法
 */
function pullDownAction() {
    setTimeout(function () {
        $('#alarms a').remove();
        pageCurrent = 1;
        var append = getRealTimeAlarm(pageCurrent);
        if (append != null && append != '') {
            $('#alarms').append(append);
            setLevel(pageSize);
            setDscLength();
            // 数据加载完成后，调用界面更新方法
            myScroll.refresh();
        } else {
            document.getElementById('pullDown').querySelector('.pullUpLabel').innerHTML = '无数据,刷新页面超时...';
        }
    }, 1000);
}

/**
 * 滚动翻页
 * myScroll.refresh();// 数据加载完成后，调用界面更新方法
 */
function pullUpAction() {
    setTimeout(function () {
        pageCurrent++;
        var append = getRealTimeAlarm(pageCurrent);
        if (append != null && append != '') {
            $('#alarms').append(append);
            setLevel(pageSize);
            setDscLength();
            // 数据加载完成后，调用界面更新方法
            myScroll.refresh();
        } else {
            document.getElementById('pullUp').querySelector('.pullUpLabel').innerHTML = '无更多数据...';
        }
    }, 1000);
}

/**
 * 初始化iScroll控件
 */
function loaded() {
    pullDownEl = document.getElementById('pullDown');
    pullDownOffset = pullDownEl.offsetHeight;
    pullUpEl = document.getElementById('pullUp');
    pullUpOffset = pullUpEl.offsetHeight;

    myScroll = new iScroll('wrapper', {
        scrollbarClass: 'myScrollbar', /* 重要样式 */
        useTransition: true,
        topOffset: pullDownOffset,
        onRefresh: function () {
            if (pullDownEl.className.match('loading')) {
                pullDownEl.className = '';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
            } else if (pullUpEl.className.match('loading')) {
                pullUpEl.className = '';
                pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
            }
        },
        onScrollMove: function () {
            if (this.y > 10 && !pullDownEl.className.match('flip')) {
                pullDownEl.className = 'flip';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '松手开始更新...';
                this.minScrollY = 0;
            } else if (this.y < 10 && pullDownEl.className.match('flip')) {
                pullDownEl.className = '';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '下拉刷新...';
                this.minScrollY = -pullDownOffset;
            } else if (this.y < (this.maxScrollY - 10) && !pullUpEl.className.match('flip')) {
                pullUpEl.className = 'flip';
                pullUpEl.querySelector('.pullUpLabel').innerHTML = '松手开始更新...';
                this.maxScrollY = this.maxScrollY;
            } else if (this.y > (this.maxScrollY + 10) && pullUpEl.className.match('flip')) {
                pullUpEl.className = '';
                pullUpEl.querySelector('.pullUpLabel').innerHTML = '上拉加载更多...';
                this.maxScrollY = pullUpOffset;
            }
        },
        onScrollEnd: function () {
            if (pullDownEl.className.match('flip')) {
                pullDownEl.className = 'loading';
                pullDownEl.querySelector('.pullDownLabel').innerHTML = '加载中...';
                pullDownAction();
            } else if (pullUpEl.className.match('flip')) {
                pullUpEl.className = 'loading';
                pullUpEl.querySelector('.pullUpLabel').innerHTML = '加载中...';
                pullUpAction();
            }
        }
    });

    setTimeout(function () {
        document.getElementById('wrapper').style.left = '0';
    }, 800);
}



