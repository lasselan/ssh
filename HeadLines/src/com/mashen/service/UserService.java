package com.mashen.service;

import java.util.ArrayList;

import com.mashen.user.HeadLineUser;

public interface UserService {
	public int reg(HeadLineUser user);
	public ArrayList<HeadLineUser> login(String headaccount);
	public int update(HeadLineUser user);
}
