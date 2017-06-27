package com.mashen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/up")
public class SessionAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		// 销毁
		String ss = "修改成功，请重新登录！";
		req.setAttribute("ss1", ss);
		req.getRequestDispatcher("/userheadlines/login.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		// 销毁Session()
//		req.getRequestDispatcher("/home.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath()+"/homeshow.jsp");
	}
}
