package com.mashen.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.dao.UserDaoImp;

@WebFilter(urlPatterns = { "/ue.jsp", "/lookup", "/updatearticle.jsp", "/UpDateArticleAction", "/updateshowarticle.jsp" })
public class FilterAction implements Filter {

	public FilterAction() {

	}

	public void destroy() {
		System.out.println("销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		UserDaoImp userDaoImp = new UserDaoImp();
		// 俩个方法都可以转String
		// String as=String.valueOf(req.getSession().getAttribute("cs"));
		String as = (String) req.getSession().getAttribute("cs");
		// System.out.println(userDaoImp.compareAccount(as));
		if (!userDaoImp.compareAccount(as)) {
			System.out.println("没登录");
			resp.sendRedirect(req.getContextPath() + "/userheadlines/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化");
	}

}
