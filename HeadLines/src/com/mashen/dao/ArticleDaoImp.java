package com.mashen.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.mashen.jdbc.ConnectionDao;
import com.mashen.user.ArticleUser;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ArticleDaoImp implements ArticleDao {

	@Override
	public int add(ArticleUser user) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement s = (PreparedStatement) conn.prepareStatement(
					"insert into article(count,title,content,headname,titleimg,headimg,created) values(?,?,?,?,?,?,?)");
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
			String date = df.format(new Date());
			user.setCreated(date);
			s.setString(1, user.getCount());
			s.setString(2, user.getTitle());
			s.setString(3, user.getContent());
			s.setString(4, user.getHeadname());
			s.setString(5, user.getTitleimg());
			s.setString(6, user.getHeadimg());
			s.setString(7, user.getCreated());
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

	@Override
	public ArrayList<ArticleUser> login(String title) {
		ArrayList<ArticleUser> list = new ArrayList<>();
		Connection conn;
		PreparedStatement p = null;
		try {
			conn = ConnectionDao.getconnection();
			if (title != null && !"".equals(title)) {
				p = (PreparedStatement) conn.prepareStatement("select * from article where title like ?");
				p.setString(1, "%" + title + "%");
			} else {
				p = (PreparedStatement) conn.prepareStatement("SELECT * FROM article");
			}
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				ArticleUser user = new ArticleUser();
				user.setCount(rs.getString("count"));
				user.setTitle(rs.getString("title"));
				user.setContent(rs.getString("content"));
				user.setHeadname(rs.getString("headname"));
				user.setTitleimg(rs.getString("titleimg"));
				user.setHeadimg(rs.getString("headimg"));
				user.setCreated(rs.getString("created"));
				list.add(user);
			}
			if (conn != null) {
				conn.close();
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(ArticleUser user) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement p = (PreparedStatement) conn
					.prepareStatement("update article set content=? where title=?");
			p.setString(1, user.getContent());
			p.setString(2, user.getTitle());
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

	@Override
	public String delete(String title) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement p = (PreparedStatement) conn.prepareStatement("delete from article where title=?");
			p.setString(1, title);
			int count = p.executeUpdate();
			System.out.println("影响数" + count);
			if (conn != null) {
				conn.close();
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public int updatecount(ArticleUser user) {
		Connection conn;
		try {
			conn = ConnectionDao.getconnection();
			PreparedStatement p = (PreparedStatement) conn
					.prepareStatement("update article set count=?,created=? where title=?");
			p.setString(1, user.getCount());
			p.setString(2, user.getCreated());
			p.setString(3, user.getTitle());
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
	
	@Override
	public ArrayList<ArticleUser> lookup(String headname) {
		ArrayList<ArticleUser> list = new ArrayList<>();
		Connection conn;
		PreparedStatement p = null;
		try {
			conn = ConnectionDao.getconnection();			
				p = (PreparedStatement) conn.prepareStatement("select * from article where headname=?");
				p.setString(1,headname);			
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				ArticleUser user = new ArticleUser();
				user.setCount(rs.getString("count"));
				user.setTitle(rs.getString("title"));
				user.setContent(rs.getString("content"));
				user.setHeadname(rs.getString("headname"));
				user.setTitleimg(rs.getString("titleimg"));
				user.setHeadimg(rs.getString("headimg"));
				user.setCreated(rs.getString("created"));
				list.add(user);
			}
			if (conn != null) {
				conn.close();
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		// ArticleUser user = new ArticleUser();
		ArticleDaoImp imp = new ArticleDaoImp();
		// user.setContent("1");
		// user.setCount("1");
		// user.setHeadimg("q");
		// user.setHeadname("ggg");
		// user.setTitleimg("4");
		// user.setTitle("我");
		// imp.add(user);
		imp.login("s");
	}

}
