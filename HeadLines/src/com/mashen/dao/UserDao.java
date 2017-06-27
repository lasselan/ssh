package com.mashen.dao;

import java.util.ArrayList;

import com.mashen.user.HeadLineUser;

public interface UserDao {
	public int add(HeadLineUser user);
	public ArrayList<HeadLineUser> login(String headaccount);
	public int update(HeadLineUser user);
}
