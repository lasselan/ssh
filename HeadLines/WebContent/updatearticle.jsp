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
		<label for="formGroupInputLarge"><h3>文章标题</h3></label>
		<c:forEach var="li" items="${artile}">
			<div class="form-group form-group-lg">
				<div style="width: 400px">
					<input type="text" class="form-control" readonly="readonly"
						id="title" name="title" required="required" value="${li.title}">
				</div>
			</div>
			<button type="button"
				class="btn btn-primary glyphicon glyphicon-trash"
				data-toggle="modal" data-target="#del${li.title}"
				data-whatever="del${li.title}"></button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form action="${path}/lookup" method="post"
				style="display: inline;">
				<input style="display:none;" name="title" value="${li.title}">				
				<button type="submit"
					class="btn btn-primary glyphicon glyphicon-pencil"></button>
			</form>
			<div class="modal fade" id="del${li.title}" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">确定删除:${li.title}</h4>
						</div>
						<div class="modal-footer">
							<center>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<a href="${path}/UpDateArticleAction?title=${li.title}">
									<button type="button" class="btn btn-primary">确定删除</button>
								</a>
							</center>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<br><br><br><a href="${path}/homeshow.jsp"><button style="width: 100px" class="btn btn-success">
			<font size="3" color="black"><b>返回主页</b></font></button></a> 
		
	</center>
</body>
<script type="text/javascript"
	src="${path}/userheadlines/bootstrap/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="${path}/userheadlines/bootstrap/js/bootstrap.js"></script>
</html>