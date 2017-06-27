<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${path}/userheadlines/bootstrap/css/bootstrap.css" />
<title>写文章</title>
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
		<div class="panel-heading">编写文章</div>
		<div class="panel-body">
			<center>
				<center>
					<font color="red">${so }</font>
				</center>
				<form action="${path}/ue" method="post" enctype="multipart/form-data">
					<label for="formGroupInputLarge"><h4>文章发表者</h4></label>
					<div class="form-group form-group-lg">
						<div style="width: 400px">
							<input type="text" class="form-control" name="headname"
								value="${sss}" readonly="readonly">
						</div>
					</div>
					<label for="formGroupInputLarge"><h4>用户头像</h4></label> <br>
					<img src="${s}" style="width: 200px;"><br>
					<input style="display:none" name="headimg" value="${s}">
					<label for="formGroupInputLarge"><h3>文章标题</h3></label>
					<div class="form-group form-group-lg">
						<div style="width: 400px">
							<input type="text" class="form-control" placeholder="请输入标题"
								id="title" name="title" required="required">
						</div>
					</div>
					<label for="formGroupInputLarge"><h3>标题图像</h3></label>
					<div class="form-group form-group-lg">
						<div style="width: 400px">
							<input type="file" class="form-control" id="img" name="img"
								required="required">
						</div>
					</div>
					<br>
					<script id="editor" type="text/plain"
						style="width:1024px;height:500px;" name="ue"></script>
					<br>
					<button style="width: 100px" onclick="check()"
						class="btn btn-success">
						<font size="3" color="black"><b>提&nbsp;&nbsp;交</b></font>
					</button>
				</form>
			</center>
		</div>
	</div>
</body>
</html>