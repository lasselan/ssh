package com.mashen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mashen.jdbc.ConnectionDao;
import com.mashen.user.HeadLineUser;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImp implements UserDao {

	@Override
	public int add(HeadLineUser user) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement s = (PreparedStatement) conn.prepareStatement(
					"insert into toutiaohao(headaccount,headpassword,headname,headimg,email,created) values(?,?,?,?,?,?)");
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
			String date = df.format(new Date());
			user.setCreated(date);
			s.setString(1, user.getHeadaccount());
			s.setString(2, user.getHeadpassword());
			s.setString(3, user.getHeadname());
			s.setString(4, user.getHeadimg());
			s.setString(5, user.getEmail());
			s.setString(6, user.getCreated());
			int count = s.executeUpdate();
			System.out.println("影响数" + count);
			if (conn != null) {
				conn.close();
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public boolean compareAccount(String s) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement sb = (PreparedStatement) conn
					.prepareStatement("select headaccount from toutiaohao where headaccount=?");
			sb.setString(1, s);
			ResultSet rs = sb.executeQuery();
			if (rs.next()) {
				return true;
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<HeadLineUser> login(String headaccount) {
		ArrayList<HeadLineUser> list = new ArrayList<>();
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement s = (PreparedStatement) conn
					.prepareStatement("select * from toutiaohao where headaccount=?");
			s.setString(1, headaccount);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				HeadLineUser user = new HeadLineUser();
				user.setHeadaccount(rs.getString("headaccount"));
				user.setHeadpassword(rs.getString("headpassword"));
				user.setHeadimg(rs.getString("headimg"));
				user.setCreated(rs.getString("created"));
				user.setHeadname(rs.getString("headname"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			if (conn != null) {
				conn.close();
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(HeadLineUser user) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement p = (PreparedStatement) conn.prepareStatement(
					"update toutiaohao set headname=?,headpassword=?,headimg=?,email=? where headaccount=?");
			p.setString(1, user.getHeadname());
			p.setString(2, user.getHeadpassword());
			p.setString(3, user.getHeadimg());
			p.setString(4, user.getEmail());
			p.setString(5, user.getHeadaccount());
			int count = p.executeUpdate();
			System.out.println("影响数" + count);
			if (conn != null) {
				conn.close();
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public static void main(String[] args) {
		UserDaoImp imp = new UserDaoImp();
		HeadLineUser user = new HeadLineUser();
		user.setHeadpassword("hhh");
		user.setEmail("hh");
		user.setHeadaccount("2");
		user.setHeadname("hh");
		user.setHeadimg("hhh");
		imp.update(user);
	}
}
