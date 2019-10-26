<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Full Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/demo.css">
	<script type="text/javascript" src="easyui/js/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
	<style>
		.app{margin:0px;margin-bottom:2px; width:100%;background:#aaaaaa;}
		.acc{font-size:16px;color:#ffffff;background:pink;display:block;width:100%;height:30px;line-height:30px;text-align:center;
		text-decoration:none;
		}
		.acc:hover{background:#ff00ff}
	</style>
	<script>
	function addTab(title, url){
		if ($('#tt').tabs('exists', title)){
			$('#tt').tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			$('#tt').tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px;fount-size:20px;">网站后台</div>
	<div data-options="region:'west',split:true,title:'主菜单'" style="width:150px;padding:0px;" >
		<div id="aa" class="easyui-accordion" style="width:100%;height:100%;">
		    <div title="用户管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:2px;height:auto;">				
				<p class="app"><a href="#" class="acc"  class="easyui-linkbutton" onclick="addTab('用户列表','userlist.html')">用户列表</a></p>			
		    </div>
		    <div title="客户管理" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
				<p class="app"><a href="#" class="acc"  class="easyui-linkbutton" onclick="addTab('客户列表','customerlist.html')">客户列表</a></p>			
		    </div>
		    <div title="联系人管理" data-options="iconCls:'icon-save'">
				<p class="app"><a href="#" class="acc"  class="easyui-linkbutton" onclick="addTab('联系人列表','userlist.html')">联系人列表</a></p>			
		    </div>
		</div>
	
	</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">网站后台@1988-2018</div>
	<div data-options="region:'center',title:'主页面'">
		<div id="tt" class="easyui-tabs" style="width:100%;height:100%;margin:0px;padding:0px;">
		<div title="欢迎使用">
		</div>
</div>
	
	</div>
</body>
</html>