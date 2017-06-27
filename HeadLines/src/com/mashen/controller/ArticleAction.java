package com.mashen.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.service.ArticleServiceImp;
import com.mashen.service.ColumnServletImp;
import com.mashen.user.ArticleUser;

@WebServlet("/ArticleAction")
public class ArticleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleServiceImp service = new ArticleServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String count1=request.getParameter("count");
		String created=request.getParameter("created");
		if (title == null) {
			// 导航栏遍历
			ColumnServletImp servletImp = new ColumnServletImp();
			request.setAttribute("columnlist", servletImp.selectall());
			// 文章遍历
			ArticleAction action = new ArticleAction();
			request.setAttribute("artile", action.time());
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			ArticleUser user = new ArticleUser();
			user.setTitle(title);
			user.setCreated(created);
			int cou=Integer.parseInt(count1)+1;
			String count=String.valueOf(cou);
			user.setCount(count);
			service.updatecount(user);
			
			String hh = title.substring(0, title.length() - 1);
			ArrayList<ArticleUser> list = service.login(hh);
			request.setAttribute("artile", list);
			request.getRequestDispatcher("articleshow.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");
		ArrayList<ArticleUser> list = service.login(key);
		
//		request.setAttribute("artile", list);
//		for (ArticleUser l : list) {
//			String s = l.getTitle();
//			request.setAttribute("listtt", s);
//		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String date = df.format(new Date());
		// 月
		String m = date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3);
		// 日
		String d = date.substring(date.indexOf("/") + 4, date.indexOf("/") + 6);
		// 时
		String h = date.substring(date.indexOf(":") - 2, date.indexOf(":"));
		// 分
		String f = date.substring(date.indexOf(":") + 1, date.indexOf(":") + 3);
		ArrayList<ArticleUser> list2 = new ArrayList<>();
		for (ArticleUser l : list) {
			String tim = l.getCreated();
			String m1 = tim.substring(tim.indexOf("-") + 1, tim.indexOf("-") + 3);
			String d1 = tim.substring(tim.indexOf("-") + 4, tim.indexOf("-") + 6);
			String h1 = tim.substring(tim.indexOf(":") - 2, tim.indexOf(":"));
			String f1 = tim.substring(tim.indexOf(":") + 1, tim.indexOf(":") + 3);
			if (m.equals(m1)) {
				if (d.equals(d1)) {
					if (h.equals(h1)) {
						if (f.equals(f1)) {
							l.setHeadimg(l.getCreated());
							l.setCreated("刚刚");
						} else {
							l.setHeadimg(l.getCreated());
							l.setCreated(Integer.parseInt(f) - Integer.parseInt(f1) + "分钟前");
						}
					} else {
						l.setHeadimg(l.getCreated());
						l.setCreated(Integer.parseInt(h) - Integer.parseInt(h1) + "小时前");
					}
				} else {
					l.setHeadimg(l.getCreated());
					l.setCreated(Integer.parseInt(d) - Integer.parseInt(d1) + "天前");
				}
			} else {
				if((Integer.parseInt(d) - Integer.parseInt(d1))<0){
					System.out.println(Integer.parseInt(d) - Integer.parseInt(d1));
					l.setHeadimg(l.getCreated());
					l.setCreated(31-Integer.parseInt(d1) + Integer.parseInt(d)+ "天前");
				}else{
					l.setHeadimg(l.getCreated());
					l.setCreated("超过1个月！");
				}
			}
			list2.add(l);
		}
		request.setAttribute("artile", list);
		
		ColumnServletImp servletImp = new ColumnServletImp();
		request.setAttribute("columnlist", servletImp.selectall());
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	public ArrayList<ArticleUser> time() {
		ArrayList<ArticleUser> list = service.login("");
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		String date = df.format(new Date());
		// 月
		String m = date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3);
		// 日
		String d = date.substring(date.indexOf("/") + 4, date.indexOf("/") + 6);
		// 时
		String h = date.substring(date.indexOf(":") - 2, date.indexOf(":"));
		// 分
		String f = date.substring(date.indexOf(":") + 1, date.indexOf(":") + 3);
		ArrayList<ArticleUser> list2 = new ArrayList<>();
		for (ArticleUser l : list) {
			String tim = l.getCreated();
			String m1 = tim.substring(tim.indexOf("-") + 1, tim.indexOf("-") + 3);
			String d1 = tim.substring(tim.indexOf("-") + 4, tim.indexOf("-") + 6);
			String h1 = tim.substring(tim.indexOf(":") - 2, tim.indexOf(":"));
			String f1 = tim.substring(tim.indexOf(":") + 1, tim.indexOf(":") + 3);
			if (m.equals(m1)) {
				if (d.equals(d1)) {
					if (h.equals(h1)) {
						if (f.equals(f1)) {
							l.setHeadimg(l.getCreated());
							l.setCreated("刚刚");
						} else {
							l.setHeadimg(l.getCreated());
							l.setCreated(Integer.parseInt(f) - Integer.parseInt(f1) + "分钟前");
						}
					} else {
						l.setHeadimg(l.getCreated());
						l.setCreated(Integer.parseInt(h) - Integer.parseInt(h1) + "小时前");
					}
				} else {
					l.setHeadimg(l.getCreated());
					l.setCreated(Integer.parseInt(d) - Integer.parseInt(d1) + "天前");
				}
			} else {
				if((Integer.parseInt(d) - Integer.parseInt(d1))<0){
					l.setHeadimg(l.getCreated());
					l.setCreated(31-Integer.parseInt(d1) + Integer.parseInt(d)+ "天前");
				}else{
					l.setHeadimg(l.getCreated());
					l.setCreated("超过1个月！");
				}
			}
			list2.add(l);
		}
		return list2;
	}

	public static void main(String[] args) {
		ArticleAction action = new ArticleAction();
		action.time();
	}
}
