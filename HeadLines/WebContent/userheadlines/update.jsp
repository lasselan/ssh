<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
<link rel="stylesheet" type="text/css"
	href="${path}/userheadlines/bootstrap/css/bootstrap.css" />
</head>
<style type="text/css">
.col-sm-10 {
	max-width: 300px;
}

.max {
	height: 100px;
	width: 100px;
}

img {
	height: 100%;
	width: 100%;
}
</style>
<script type="text/javascript">
	function imgPreview(fileDom) {
		//判断是否支持FileReader
		if (window.FileReader) {
			var reader = new FileReader();
		} else {
			alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
		}
		//获取文件
		var file = fileDom.files[0];
		var imageType = /^image\//;
		//是否是图片
		if (!imageType.test(file.type)) {
			alert("请选择图片！");
			return;
		}
		//读取完成
		reader.onload = function(e) {
			//获取图片dom
			var img = document.getElementById("preview");
			//图片路径设置为读取的图片
			img.src = e.target.result;
		};
		reader.readAsDataURL(file);
	}
	function check() {
		var flag = true;
		var account = document.getElementById("account").value;
		var password = document.getElementById("password").value;
		var name = document.getElementById("name").value;
		var content = document.getElementById("account");
		var con = document.getElementById("password")
		var Ogg = document.getElementById("exampleInputFile").value;
		if (Ogg == "") {
			document.getElementById("ii").value = "0";
		} else {
			document.getElementById("ii").value = "1";
		}
		if (content.value.match(" ")) {
			alert("账号不能有空格")
			return false;
		}
		if (con.value.match(" ")) {
			alert("密码不能有空格")
			return false;
		}
		if ("" == account) {
			alert("请输入账号！");
			flag = false;
			return false;
		} else if ("" == password) {
			alert("请输入密码！");
			flag = false;
			return false;
		} else if ("" == name) {
			alert("请输入名称！");
			flag = false;
			return false;
		}
		if (flag == true) {
			return true;
		}
	}
</script>

<body>
	<c:forEach var="li" items="${user}">
		<div class="panel panel-success">
			<div class="panel-heading">修改信息</div>
			<div class="panel-body">
				<form class="form-horizontal" action="${path}/update" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="account"
								name="account" placeholder="请设置账号" readonly="readonly"
								value="${li.headaccount }">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="请设置登陆密码" value="${li.headpassword}"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name"
								value="${li.headname}" name="name" placeholder="请输入姓名"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email"
								value="${li.email}" name="email" placeholder="请设置邮箱">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">旧头像</label>
						<div class="col-sm-10">
							<img src="${li.headimg}" style="width: 50px">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">新头像</label>
						<div class="col-sm-10">
							<img id="preview" /> <input type="file" id="exampleInputFile"
								onchange="imgPreview(this)" name="img"> <input
								style="display: none;" type="text" name="img2" id="ii">
							<input style="display: none;" type="text" value="${li.headimg}"
								name="img1"> <br>
						</div>
					</div>
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default" onclick="check()">确认修改</button>
						<a href="${path}/homeshow.jsp"><button type="button"
								class="btn btn-default">返回主页</button></a>
								<a href="${path}/lookup"><button type="button"
								class="btn btn-default">修改文章</button></a>
					</div>
			</div>
			</form>
		</div>
		</div>
	</c:forEach>
</body>
</html>