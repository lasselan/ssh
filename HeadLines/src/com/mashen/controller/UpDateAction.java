package com.mashen.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.mashen.service.UserServiceImp;
import com.mashen.user.HeadLineUser;

@WebServlet("/update")
@MultipartConfig(location = "d:/aaa")
public class UpDateAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserServiceImp service = new UserServiceImp();	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HeadLineUser user = new HeadLineUser();
		user.setHeadaccount(req.getParameter("account"));
		user.setHeadpassword(req.getParameter("password"));
		user.setHeadname(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		// System.out.println(user);
		Part p = req.getPart("img");
		System.out.println(req.getParameter("img2") + "哈哈");

		if (req.getParameter("img2").equals("1")) {
			String url2 = req.getParameter("img1");
			System.out.println("123");
			if (!url2.equals("")) {
				System.out.println("456");
				String str1 = url2.substring(url2.lastIndexOf("/"));
				System.out.println("D://aaa" + str1);
				File file = new File("D://aaa" + str1);
				file.delete();
			}
			String uuid = UUID.randomUUID().toString();
			String sf = p.getSubmittedFileName();
			String st = sf.substring(sf.lastIndexOf("."));
			String str = uuid + st;
			p.write(str);
			String url = "http://localhost:8888" + "/img/" + str;
			user.setHeadimg(url);
			service.update(user);
			req.getRequestDispatcher("/up").forward(req, resp);
		} else {
			System.out.println("456");
			user.setHeadimg(req.getParameter("img1"));
			service.update(user);
			req.getRequestDispatcher("/up").forward(req, resp);

		}
	}
}
