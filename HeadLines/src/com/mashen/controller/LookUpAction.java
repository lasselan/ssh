package com.mashen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.service.ArticleServiceImp;
import com.mashen.user.ArticleUser;

@WebServlet("/lookup")
public class LookUpAction extends HttpServlet {
	private ArticleServiceImp service = new ArticleServiceImp();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String headname1=(String)req.getSession().getAttribute("sss");
//		String headname=req.getParameter("headname");
		ArrayList<ArticleUser> list = service.lookup(headname1);
		req.setAttribute("artile", list);
		req.getRequestDispatcher("updatearticle.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String headname=(String)req.getSession().getAttribute("sss");
		ArrayList<ArticleUser> list = service.lookup(headname);
		
		String title=req.getParameter("title");
		String content = null;
		for(ArticleUser l:list){
			if(l.getTitle().equals(title)){
				content=l.getContent();
			}
		}
		req.setAttribute("title", title);
		req.setAttribute("content", content);
		req.getRequestDispatcher("updateshowarticle.jsp").forward(req, resp);
	}
}
