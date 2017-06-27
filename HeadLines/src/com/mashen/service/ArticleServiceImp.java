package com.mashen.service;

import java.util.ArrayList;

import com.mashen.dao.ArticleDaoImp;
import com.mashen.user.ArticleUser;

public class ArticleServiceImp implements ArticleService {
	private ArticleDaoImp dao = new ArticleDaoImp();

	@Override
	public int add(ArticleUser user) {
		return dao.add(user);
	}

	@Override
	public ArrayList<ArticleUser> login(String title) {
		return dao.login(title);
	}

	@Override
	public int update(ArticleUser user) {
		
		return dao.update(user);
	}

	@Override
	public String delete(String title) {
		return dao.delete(title);
	}

	@Override
	public int updatecount(ArticleUser user) {
		return dao.updatecount(user);
	}

	@Override
	public ArrayList<ArticleUser> lookup(String headname) {
		return dao.lookup(headname);
	}

}
