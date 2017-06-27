package com.mashen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mashen.jdbc.ConnectionDao;
import com.mashen.user.ColumnUser;

public class ColumnDaoImp implements ColumnDao {
	@Override
	public List<ColumnUser> selectall() {
		List<ColumnUser> list = new ArrayList<ColumnUser>();
		try {
			Connection conn = ConnectionDao.getconnection();
			PreparedStatement stat = conn.prepareStatement("select * from colu");
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				ColumnUser column = new ColumnUser();
				column.setPid(rs.getInt("pid"));
				column.setCatname(rs.getString("catname"));
				list.add(column);
			}
			stat.close();
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	public static void main(String[] args) {
		ColumnDaoImp imp = new ColumnDaoImp();
		imp.selectall();
	}
}
