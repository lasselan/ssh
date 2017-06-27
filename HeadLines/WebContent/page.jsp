<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/page?newPage=1">查看所有信息</a>
	<form action="${pageContext.request.contextPath}/page" method="post">
		<c:forEach var="i" items="${page}">
		<div>${i.catname}</div>	
		</c:forEach>
	</form>
	 <a href="${pageContext.request.contextPath}/page?newPage=1">首页</a>
 
       <a
           href="${pageContext.request.contextPath}/page?newPage=${npage-1<=1?1:npage-1}">上一页</a>
       <a
           href="${pageContext.request.contextPath}/page?newPage=${npage+1>=countpage?countpage:npage+1}">下一页</a>
       <a
           href="${pageContext.request.contextPath}/page?newPage=${countpage}">末页</a>
		<br><a href="#">总数：${count}</a>
		<a href="#">页数：${countpage}</a>
</body>
</html>