var hasProjectName = true;
var ProjectName = "";
var loadinitsubsystem = 1;
var menulabel;
//全局变量jqrid 导出URL公有变量-多个查询参数---导出全部、导出当页
var jqgrid_all_allportAllURL = "";
var jqgrid_all_allportPageURL = "";

//js获取项目名称，如： http://localhost:8083/uimcardprj
//注意：没有项目名称时，请修改此方法直接为空
function getProjectName() {
	if (hasProjectName) {
		//1.获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		var pathName = window.document.location.pathname;
		//2.取网址第一个斜杠之前。
		//获取带"/"的项目名，如：/uimcardprj
		ProjectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

	}

	return ProjectName;

}


//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath() {
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}


/**
 * 用户验证并设置数据控制值
 * @param userName 用户名
 * @param grid_selector  table名
 * @param rowId 当前行id
 * @param setupId 当前设置值
 */
function userVerification(userName, grid_selector, rowId, setupId) {
	var flag = check_setupVal(setupId);
	if (!flag) return false;
	if (setupId.value == -1 || setupId.value == "" || setupId.value == null) {
		layer.msg("设置值不能为空", {
			icon : 2
		});
	} else {
		layer.prompt({
			title : '密码验证',
			content : userName + '<input type="password" class="layui-layer-input" value="">',
		}, function(value, index, elem) {
			$.ajax({
				type : "POST",
				timeout : 20000,
				url : getProjectName() + "/omm/user/LoginCheck.action",
				dataType : "json",
				data : {
					userName : userName,
					userPwd : value
				},
				//				async : false,
				success : function(data) {
					if (data.mcode == 0) { //验证成功
						layer.close(index);
						var rowData = $(grid_selector).jqGrid('getRowData', rowId);
						$.ajax({
							url : getProjectName() + "/omm/base/FSUCheck_getSetpointXML.action",
							type : 'post',
							dataType : 'json',
							data : {
								fsuId : rowData.FSUID,
								deviceid : rowData.deviceid,
								signalId : rowData.signalId,
								signalNumber : rowData.signalNumber,
								setupVal : setupId.value
							},
							success : function(data) {
								if (data == "success") {
									$(grid_selector).jqGrid('setGridParam', {}).trigger("reloadGrid"); //重新载入
									var lastTr = $(grid_selector + " #" + rowId);
									lastTr.focus();
								}
							}
						});
					} else {
						layer.msg(data.mstr, {
							time : 500,
							icon : 2
						});
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					if (textStatus == "timeout") {
						layer.open({
							type : 1,
							skin : 'layui-layer-demo', //样式类名
							closeBtn : 0, //不显示关闭按钮
							anim : 2,
							shadeClose : true, //开启遮罩关闭
							content : '<div class="errorContent">服务器通讯异常</div>',
						});
					} else {
						alert(textStatus);
					}
				},
			});
		});
	}
}

/**
 * 验证文本框
 * @param setVal
 * @returns {Boolean}
 */
function check_setupVal(setVal) {
	if (double_check(setVal.value) || integer_check(setVal.value)) {
		layer.closeAll();
		return true;
	} else {
		layer.msg("只能为整数或小数！", {
			time : 1000,
			icon : 2
		});
		return false;
	}
}

/**
 * 匹配integer
 */
function integer_check(str) {
	if (str == null || str == "") return false;
	var result = str.match(/^[-\+]?\d+$/);
	if (result == null) return false;
	return true;
}

/**
 * 匹配double或float
 */
function double_check(str) {
	if (str == null || str == "") return false;
	var result = str.match(/^[-\+]?\d+(\.\d+)?$/);
	if (result == null) return false;
	return true;
}


/**
 * 列操作
 * @param grid_selector
 */
function showorhideCol(grid_selector, names_noShow, names_hidden) {
	//	var names_noShow = "FSUName";// 不允许隐藏的列
	//	var names_hidden = "";// 隐藏列
	if (names_hidden == null) {
		names_hidden = "";
	}
	if (names_noShow == null) {
		names_noShow = "";
	}

	var colNames = $(grid_selector).jqGrid('getGridParam', 'colNames'); // 获取所有列名
	var columnArray = $(grid_selector).jqGrid('getGridParam', 'colModel'); //获取所有列的属性
	var column_ul = $("#showColumn");
	column_ul.empty();
	var j = 0;
	if (colNames[0] == null || colNames[0] == "") {
		j = 1;
	}
	for (j; j < columnArray.length; j++) {
		var str = "<li>" +
			"	<a href='javascript:void(0)'>" +
			"		<label>";
		var s = new Array();
		str += "<span >" +
			"<input type='hidden' class='columnSort' value='" + j + "'/>" + //列显示的序号
			"<input type='hidden' class='columnField' value='" + columnArray[j].name + "'/>" + //列属性名
			"<input type='checkbox' class='" + columnArray[j].name + "' />" +
			"		<span class='columnName'>" + colNames[j] + "</span></span>" + //列名称
			"		</label>" +
			"	</a>" +
			"</li>";
		column_ul.append(str);
		if (columnArray[j].hidden == true) {
			$(".columnField[value='" + columnArray[j].name + "']").next().removeAttr("checked");
		}
		if (menulabel == null || menulabel == "") {
			$(".columnField").next().attr("checked", "checked");
		} else {
			var menulabels = menulabel.split(",");
			for (var i = 0; i < menulabels.length; i++) {
				$("." + menulabels[i]).attr("checked", "checked");
			}
		}

		var nameStr = [];
		nameStr = names_noShow.split(","); //不允许隐藏 的列
		for (var i = 0; i < nameStr.length; i++) {
			if (columnArray[j].name == nameStr[i]) {
				$("." + columnArray[j].name).attr("disabled", "disabled"); //基本信息不允许隐藏
				$("." + columnArray[j].name).next().css({
					"color" : "rgb(240, 174, 174)"
				}); //不允许隐藏的列 字体为灰色
			}
		}

		nameStr = names_hidden.split(","); //隐藏列 
		for (var i = 0; i < nameStr.length; i++) {
			if (columnArray[j].name == nameStr[i]) {
				$("." + columnArray[j].name).css({
					"visibility" : "hidden"
				});
				$("." + columnArray[j].name).next().css({
					"visibility" : "hidden"
				});
				$("." + columnArray[j].name).parent().parent().parent().parent().css({
					"height" : "0px",
					"width" : "0px",
					"display" : "none"
				});
			}
		}


		$("." + columnArray[j].name).click(function() { //点击 复选框
			if ($("." + this.className).prop("checked")) {
				jQuery(grid_selector).setGridParam().showCol(this.className).trigger("reloadGrid"); //显示列
			} else {
				jQuery(grid_selector).setGridParam().hideCol(this.className).trigger("reloadGrid"); //隐藏列
			}
		});
	}

	$("#colModal").modal("show");
}