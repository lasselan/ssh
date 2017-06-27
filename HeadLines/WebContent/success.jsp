<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path=request.getContextPath();
    pageContext.setAttribute("path", path);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <META HTTP-EQUIV="Refresh" CONTENT="3; URL=${path}/homeshow.jsp"/> 
</head>
<body>
<center><h2>发表成功！3秒后跳转回首页！！</h2></center>
</body>
</html>