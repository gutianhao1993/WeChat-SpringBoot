$(function () {
    $('body').mLoading();
    getDetailInfo();
});

function getDetailInfo() {
    var Level = '';
    var params = window.location.search.substring(9).split('&');
    if (params[1] == 'flag=0') {
        var id = params[0];
        var url = 'getDetailInfo.do';
        var param = {
            "id": id
        };
        $.post(url, param, function (data) {
            if (data == null || data == '') {
                var curWwwPath = window.document.location.href;
                var pathName = window.document.location.pathname;
                var pos = curWwwPath.indexOf(pathName);
                var localhostPaht = curWwwPath.substring(0, pos);
                var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 2);
                window.location.href = localhostPaht + projectName + 'noResult.do';
            } else {
                $('body').mLoading("hide");

                var result = data.alarm;
                var alarmNo = result.alarmNo;
                var FSUName = result.fsuName;
                var SoName = result.soName;
                var SensorName = result.sensorName;
                var AlarmLevel = result.alarmLevel;
                var AlarmTime = result.alarmTime;
                var AlarmMsg = result.alarmMsg;
                var AreaName = result.areaName;

                if (FSUName == null || FSUName.trim() == '') {
                    FSUName = '未知';
                }
                if (SoName == null || SoName.trim() == '') {
                    SoName = '未知';
                }
                if (SensorName == null || SensorName.trim() == '') {
                    SensorName = '未知';
                }
                if (AreaName == null || AreaName.trim() == '') {
                    AreaName = '未知';
                }
                if (AlarmTime == null || AlarmTime.trim() == '') {
                    AlarmTime = '未知';
                }
                if (AlarmMsg == null || AlarmMsg.trim() == '') {
                    AlarmMsg = '未知';
                }

                document.getElementById("AlarmNo").innerHTML = alarmNo;
                document.getElementById("FSUName").innerHTML = FSUName;
                document.getElementById("SoName").innerHTML = SoName;
                document.getElementById("SensorName").innerHTML = SensorName;
                document.getElementById("AreaName").innerHTML = AreaName;
                document.getElementById("AlarmTime").innerHTML = AlarmTime;
                document.getElementById("AlarmMsg").innerHTML = AlarmMsg;

                if (AlarmLevel == 3 || AlarmLevel == 4) {
                    document.getElementById('levelicon').setAttribute('class', 'weui-icon-info weui-icon_msg');
                    if (AlarmLevel == 3) {
                        Level = '三级告警';
                    }
                    if (AlarmLevel == 4) {
                        Level = '四级告警';
                    }
                }
                if (AlarmLevel == 2) {
                    Level = '二级告警';
                    document.getElementById('levelicon').setAttribute('class', 'weui-icon-warn weui-icon_msg-primary');
                }
                if (AlarmLevel == 1) {
                    Level = '一级告警';
                    document.getElementById('levelicon').setAttribute('class', 'weui-icon-warn weui-icon_msg');
                }

                document.getElementById('LevelInfo').innerHTML += Level;

                var columns = $('.column');
                $.each(columns, function (i, obj) {
                    if (columns[i].clientHeight >= columns[i].nextElementSibling.clientHeight) {
                        columns[i].nextElementSibling.style.height = columns[i].clientHeight + 'px';
                    } else {
                        columns[i].style.height = columns[i].nextElementSibling.clientHeight + 'px';
                    }
                });
            }
        });
    } else if (params[1] == 'flag=1') {
        var alarmID = params[0];
        var url = 'getAlarmDetailInfo.do';
        var param = {
            "alarmID": alarmID
        };
        $.post(url, param, function (data) {
            if (data == null || data == '') {
                var curWwwPath = window.document.location.href;
                var pathName = window.document.location.pathname;
                var pos = curWwwPath.indexOf(pathName);
                var localhostPaht = curWwwPath.substring(0, pos);
                var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 2);
                window.location.href = localhostPaht + projectName + 'noResult.do';
            } else {
                $('body').mLoading("hide");

                var result = data.alarm;
                var FSUName = result.fsuName;
                var SoName = result.soName;
                var SensorName = result.sensorName;
                var AlarmLevel = result.alarmLevel;
                var StartTime = result.startTime;
                var Dsc = result.dsc;
                var AreaName = result.areaName;

                if (FSUName == null || FSUName.trim() == '') {
                    FSUName = '未知';
                }
                if (SoName == null || SoName.trim() == '') {
                    SoName = '未知';
                }
                if (SensorName == null || SensorName.trim() == '') {
                    SensorName = '未知';
                }
                if (AreaName == null || AreaName.trim() == '') {
                    AreaName = '未知';
                }
                if (StartTime == null || StartTime.trim() == '') {
                    StartTime = '未知';
                }
                if (Dsc == null || Dsc.trim() == '') {
                    Dsc = '未知';
                }

                document.getElementById("AlarmNo").innerHTML = alarmID;
                document.getElementById("FSUName").innerHTML = FSUName;
                document.getElementById("SoName").innerHTML = SoName;
                document.getElementById("SensorName").innerHTML = SensorName;
                document.getElementById("AreaName").innerHTML = AreaName;
                document.getElementById("AlarmTime").innerHTML = StartTime;
                document.getElementById("AlarmMsg").innerHTML = Dsc;

                if (AlarmLevel == 3 || AlarmLevel == 4) {
                    document.getElementById('levelicon').setAttribute('class', 'weui-icon-info weui-icon_msg');
                    if (AlarmLevel == 3) {
                        Level = '三级告警';
                    }
                    if (AlarmLevel == 4) {
                        Level = '四级告警';
                    }
                }
                if (AlarmLevel == 2) {
                    Level = '二级告警';
                    document.getElementById('levelicon').setAttribute('class', 'weui-icon-warn weui-icon_msg-primary');
                }
                if (AlarmLevel == 1) {
                    Level = '一级告警';
                    document.getElementById('levelicon').setAttribute('class', 'weui-icon-warn weui-icon_msg');
                }

                document.getElementById('LevelInfo').innerHTML += Level;
                var columns = $('.column');
                $.each(columns, function (i, obj) {
                    if (columns[i].clientHeight >= columns[i].nextElementSibling.clientHeight) {
                        columns[i].nextElementSibling.style.height = columns[i].clientHeight + 'px';
                    } else {
                        columns[i].style.height = columns[i].nextElementSibling.clientHeight + 'px';
                    }
                });
            }
        });
    }
}
