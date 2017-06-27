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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${path}/userheadlines/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${path}/userheadlines/bootstrap/css/home.css" />
<title>头条首页</title>
<script type="text/javascript">
	window.onload = function() {
		var odis = document.getElementById("dis");
		var odi = document.getElementById("di");
		var odii = document.getElementById("di2");
		if ("${sss}" == "") {
			odis.style.display = "none";
		} else {
			odis.style.display = "";
			odi.style.display = "none";
			odii.style.display = "";
		}
	}
</script>
</head>
<body>
	<!--导航条-->
	<nav class="navbar navbar-default navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">下载app <span
						class="sr-only">(current)</span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">广州&nbsp;&nbsp;&nbsp;阵雨&nbsp;&nbsp;&nbsp;23°/28°<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#"><img src="img/天气.png" /></a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li id="dis"><a href="${path}/login?account=${cs}"><img
						src="${s}" style="width: 25px;">${sss}</a></li>
				<li id="di2" style="display: none"><a href="${path }/up">注销</a></li>
				<li id="di"><a href="${path }/userheadlines/login.jsp">登陆</a></li>
				<li><a href="#">反馈</a></li>
				<li><a href="${path}/ue.jsp">发表文章</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">头条产品 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">问题</a></li>
						<li><a href="#">头条号</a></li>
						<li><a href="#">图虫</a></li>
						<li><a href="#">广告投放</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!--主面板-->

	<div class="main">
		<div class="mainleft1"></div>
		<!--导航-->
		<div class="mainleft">
			<a href="#"><img src="img/logo.png" width="110px" height="30px"></a>
			<div class="col-lg-8">			
				<li class="list-group-item1"><a href="${path}/homeshow.jsp" class="active">推荐</a></li>
				<c:forEach var="columnlist" items="${columnlist}">
					<li class="list-group-item1"><a href="">${columnlist.catname}</a></li>
				</c:forEach>
				<li class="list-group-item1"><a href="">更多</a></li>
			</div>
		</div>

		<!--文章-->
		<div class="maincentre">
			<!--轮播图-->
			<div>
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel" data-interval='2500' data-pause="hover">
					<!--底部原点-->
					<ol class="carousel-indicators">
						<!--data-target对应#+整个大的div的id-->
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						<li data-target="#carousel-example-generic" data-slide-to="6"></li>
						<li data-target="#carousel-example-generic" data-slide-to="8"></li>
						<li data-target="#carousel-example-generic" data-slide-to="9"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/1.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/2.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/3.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/5.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/6.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/7.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/8.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/9.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
						<div class="item">
							<!--图片的路径-->
							<img src="img/大熊的绿帽/10.jpeg" alt="...">
							<!--导航的标题-->
							<div class="carousel-caption">大爆炸</div>
						</div>
					</div>
					<!-- 左右按钮 -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <!--字体图标--> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <!--字体图标--> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--文章-->
			<div>
				<c:forEach var="ll" items="${artile}">
					<div class="article">
						<div class="articleImg">
							<a href="${path}/ArticleAction?title=${ll.title}&count=${ll.count}&created=${ll.headimg}"
								style="text-decoration: none;"><img src="${ll.titleimg}" /></a>
						</div>
						<div class="articleTitle">
							<a href="${path}/ArticleAction?title=${ll.title}&count=${ll.count}&created=${ll.headimg}"
								style="text-decoration: none;"> ${ll.title}</a>
						</div>
						<div class="articleTitle" style="font-size: 12px;">
							<!-- <a href="#"
								style="text-decoration: none;"> -->浏览次数：${ll.count}<!-- </a> -->
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
								style="color: #999999">发布时间:${ll.created}</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!--广告-->
		<div class="mainright">
			<!--搜索框-->
			<form action="${path}/ArticleAction" method="post">
				<div>
					<div class="input-group">
						<input type="text" class="form-control" name="key"
							placeholder="大家都在搜：大熊戴绿帽" required="required"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">搜索</button>
						</span>
					</div>
				</div>
			</form>
			<!--广告-->
			<div class="ad">
				<a href="#"><img src="img/广告.jpg" height="100%" /></a>
			</div>
			<!--24小时热闻-->
			<div class="allnew">
				<div class="adTitle">
					<h3>24小热闻</h3>
				</div>
				<div class="new">
					<div class="newImg">
						<img src="img/大熊的绿帽/1.jpeg" />
					</div>
					<div class="newTitle">当然是原谅她！</div>
				</div>
				<div class="new">
					<div class="newImg">
						<img src="img/大熊的绿帽/1.jpeg" />
					</div>
					<div class="newTitle">当然是原谅她！</div>
				</div>
				<div class="new">
					<div class="newImg">
						<img src="img/大熊的绿帽/1.jpeg" />
					</div>
					<div class="newTitle">当然是原谅她！</div>
				</div>
			</div>

			<!--精彩图片-->
			<div class="allnew">
				<div class="adTitle">
					<h3>精彩图片</h3>
				</div>
				<div>
					<a href="#"><img src="img/大熊的绿帽/1.jpeg" /></a>
				</div>
			</div>

			<!--友情链接-->
			<div class="allnew" style="height: 200px;">
				<div class="adTitle">
					<h3>友情链接</h3>
				</div>
				<div class="friend">
					<a href="#">码神公司</a>
				</div>
				<div class="friend">
					<a href="#">百度公司</a>
				</div>
				<div class="friend">
					<a href="#">百度百科</a>
				</div>
				<div class="friend">
					<a href="#">腾讯视频</a>
				</div>
				<div class="friend">
					<a href="#">头条产品</a>
				</div>
				<div class="friend">
					<a href="#">招聘计划</a>
				</div>
				<div class="friend">
					<a href="#">百度公司</a>
				</div>
				<div class="friend">
					<a href="#">360</a>
				</div>
				<div class="friend">
					<a href="#">腾讯视频</a>
				</div>
				<div class="friend">
					<a href="#">头条产品</a>
				</div>
				<div class="friend">
					<a href="#">招聘计划</a>
				</div>

			</div>

			<!--更多-->
			<div class="allnew" style="float: left;">
				<div class="adTitle">
					<h3>更多</h3>
				</div>
			</div>

		</div>

	</div>

</body>
<script type="text/javascript"
	src="${path}/userheadlines/bootstrap/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="${path}/userheadlines/bootstrap/js/bootstrap.js"></script>
</html>