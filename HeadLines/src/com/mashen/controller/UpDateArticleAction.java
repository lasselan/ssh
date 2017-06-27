package com.mashen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.service.ArticleServiceImp;
import com.mashen.user.ArticleUser;

@WebServlet("/UpDateArticleAction")
public class UpDateArticleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleServiceImp service = new ArticleServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title=request.getParameter("title");
		service.delete(title);
		response.sendRedirect(request.getContextPath()+"/lookup");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleUser user = new ArticleUser();
		user.setTitle(request.getParameter("title"));
		user.setContent(request.getParameter("ue"));
		service.update(user);
		response.sendRedirect(request.getContextPath()+"/lookup");
	}

}
