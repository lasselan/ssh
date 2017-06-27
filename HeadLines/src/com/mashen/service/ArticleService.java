package com.mashen.service;

import java.util.ArrayList;

import com.mashen.user.ArticleUser;

public interface ArticleService {
	public int add(ArticleUser user);
	public ArrayList<ArticleUser> login(String title);
	public int update(ArticleUser user);
	public String delete(String title);
	public int updatecount(ArticleUser user);
	public ArrayList<ArticleUser> lookup(String headname);
}
