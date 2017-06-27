package com.mashen.service;

import java.util.List;

import com.mashen.dao.ColumnDaoImp;
import com.mashen.user.ColumnUser;

public class ColumnServletImp implements ColumnServlet {
	private ColumnDaoImp dao = new ColumnDaoImp();
	@Override
	public List<ColumnUser> selectall() {
		return dao.selectall();		
	}

}
