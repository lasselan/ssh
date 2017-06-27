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
<title>注册</title>
<link rel="stylesheet" href="${path }/userheadlines/bootstrap/css/bootstrap.css" />
<style type="text/css">
.out {
	width: 800px;
	margin: auto;
	padding: 100px;
}

.main {
	width: 500px;
	margin: auto;
	padding: 50px;
	background: url(${path }/img/注册.jpg) repeat scroll top left;
	background-size: 500px 325px;
}
</style>
<script type="text/javascript">
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
</head>

<body style="background-color: #E8E8E8;">
	<div>
		<a href="${path}/homeshow.jsp"><img src="${path}/img/logo2.png"
			style="width: 150px; float: left;" /></a>
	</div>
	<div class="out">
		<center>
			<font color="red">${sb }</font>
		</center>
		<div class="main">
			<form class="form-horizontal" action="${path}/reg" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="account"
							name="account" placeholder="请设置账号" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							name="pw" placeholder="请设置登陆密码" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="请输入姓名" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="请设置邮箱">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">头像</label>
					<div class="col-sm-10">
						<input style="display: none;" type="text" name="img2" id="ii">
						<input type="file" id="exampleInputFile" name="img">
					</div>
				</div>
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" onclick="check()">提交申请</button>
					<a href="${path}/userheadlines/login.jsp"><button type="button"
							class="btn btn-default">返回登陆</button></a>
				</div>
		</div>
		</form>
	</div>
	</div>
</body>

</html>