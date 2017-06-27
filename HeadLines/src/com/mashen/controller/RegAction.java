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

import com.mashen.dao.UserDaoImp;
import com.mashen.service.UserServiceImp;
import com.mashen.user.HeadLineUser;

@WebServlet("/reg")
@MultipartConfig(location = "d:/aaa")
public class RegAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserServiceImp service = new UserServiceImp();
		UserDaoImp imp = new UserDaoImp();
		HeadLineUser user = new HeadLineUser();
		user.setHeadaccount(req.getParameter("account"));
		user.setHeadpassword(req.getParameter("pw"));
		user.setHeadname(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		Part p = req.getPart("img");
		if (req.getParameter("img2").equals("1")) {
			System.out.println("123");
			String uuid = UUID.randomUUID().toString();
			String sf = p.getSubmittedFileName();
			String st = sf.substring(sf.lastIndexOf("."));
			String str = uuid + st;
			p.write(str);
			String url = "http://localhost:8888" + "/img/" + str;
			user.setHeadimg(url);
			String account = req.getParameter("account");
			if (!imp.compareAccount(account)) {
				service.reg(user);
				String ss = "注册成功";
				req.setAttribute("ss1", ss);
				req.getRequestDispatcher("userheadlines/login.jsp").forward(req, resp);
			} else {
				String ss1 = "用户已存在";
				req.setAttribute("sb", ss1);
				req.getRequestDispatcher("userheadlines/register.jsp").forward(req, resp);
			}
		} else {
			System.out.println("456");
			user.setHeadimg("");
			String account = req.getParameter("account");
			if (!imp.compareAccount(account)) {
				service.reg(user);
				String ss = "注册成功";
				req.setAttribute("ss1", ss);
				req.getRequestDispatcher("userheadlines/login.jsp").forward(req, resp);
			} else {
				String ss1 = "用户已存在";
				req.setAttribute("sb", ss1);
				req.getRequestDispatcher("userheadlines/register.jsp").forward(req, resp);
			}
		}
	}
}
