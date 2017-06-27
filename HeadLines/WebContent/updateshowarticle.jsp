<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${path}/userheadlines/bootstrap/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/ueditor.all.min.js">
	
</script>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor').getContent();
</script>
</head>
<body style="background-color: #DBD76B">
	<div class="panel panel-info">
		<div class="panel-heading">
			<center>
				<font color="red"><h4>
						<b>修改文章</b>
					</h4> </font>
			</center>
		</div>
	</div>
	<center>
	<form action="${path}/UpDateArticleAction" method="post">
	<input style="display: none" name="title" value="${title}">
		<script id="editor" type="text/plain"
			style="width:1024px;height:500px;" name="ue">${content}</script>
		<br>
		<button style="width: 100px" onclick="check()" class="btn btn-success">
			<font size="3" color="black"><b>提&nbsp;&nbsp;交</b></font>
		</button>
		</form>
	</center>
</body>
</html>