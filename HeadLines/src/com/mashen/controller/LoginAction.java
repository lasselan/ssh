package com.mashen.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.service.UserServiceImp;
import com.mashen.user.HeadLineUser;

@WebServlet("/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImp service = new UserServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("account");
		if (account != "") {
			ArrayList<HeadLineUser> s = service.login(account);
			req.setAttribute("user", s);
			req.getRequestDispatcher("/userheadlines/update.jsp").forward(req, resp);
		}else{
			resp.sendRedirect(req.getContextPath()+"/homeshow.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// UserServiceImp service = new UserServiceImp();
		String account = req.getParameter("account");
		String pw = req.getParameter("password");
		ArrayList<HeadLineUser> s = service.login(account);
		String s1 = null;
		String s2 = null;
		String s3 = null;
		String s4 = null;
		for (HeadLineUser ss : s) {
			s1 = ss.getHeadaccount();
			s2 = ss.getHeadpassword();
			s3 = ss.getHeadimg();
			s4 = ss.getHeadname();
		}
		if (account.equals(s1) && pw.equals(s2)) {
			req.getSession().setAttribute("cs", s1);
			req.getSession().setAttribute("sss", s4);
			req.getSession().setAttribute("s", s3);
//			req.setAttribute("sss", s4);
			req.getRequestDispatcher("/homeshow.jsp").forward(req, resp);
		} else {
			String ss1 = "账号或者密码错误！";
			req.setAttribute("ss1", ss1);
			// resp.sendRedirect(req.getContextPath()+"/user/login.jsp");
			req.getRequestDispatcher("/userheadlines/login.jsp").forward(req, resp);

		}
	}
}
