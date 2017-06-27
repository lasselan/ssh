package com.mashen.service;

import java.util.ArrayList;

import com.mashen.dao.UserDao;
import com.mashen.dao.UserDaoImp;
import com.mashen.user.HeadLineUser;

public class UserServiceImp implements UserService{
	private UserDao dao=new UserDaoImp();
	@Override
	public int reg(HeadLineUser user) {
		
		return dao.add(user);
	}

	@Override
	public ArrayList<HeadLineUser> login(String headaccount) {
		
		return dao.login(headaccount);
	}

	@Override
	public int update(HeadLineUser user) {
		
		return dao.update(user);
	}

}
