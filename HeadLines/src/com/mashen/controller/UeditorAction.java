package com.mashen.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mashen.service.ArticleServiceImp;
import com.mashen.user.ArticleUser;

@WebServlet("/ue")
@MultipartConfig(location = "D:/aaa/ueditor")
public class UeditorAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleServiceImp service = new ArticleServiceImp();
		ArticleUser user = new ArticleUser();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		user.setContent(request.getParameter("ue"));
		user.setTitle(request.getParameter("title"));
		user.setHeadname(request.getParameter("headname"));
		user.setHeadimg(request.getParameter("headimg"));
		String content=request.getParameter("ue");
		String count="0";
		user.setCount(count);
		Part p = request.getPart("img");
		System.out.println(content+"哈哈");
		if(content!=null){
			System.out.println("123");
			String uuid = UUID.randomUUID().toString();
			String sf = p.getSubmittedFileName();
			String st = sf.substring(sf.lastIndexOf("."));
			String str = uuid + st;
			p.write(str);
			String url = "http://localhost:8888" + "/im/" + str;
			user.setTitleimg((url));
//			String title=request.getParameter("title");
			service.add(user);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			String s="文本内容为空！！！";
			request.setAttribute("so",s);
			request.getRequestDispatcher("ue.jsp").forward(request, response);
		}
	}

}
