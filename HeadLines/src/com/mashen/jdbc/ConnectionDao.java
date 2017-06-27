package com.mashen.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionDao {
	private static String url = "jdbc:mysql://127.0.0.1:3306/col";
	private static String user = "root";
	private static String pw = "123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getconnection() throws SQLException {
		return (Connection) DriverManager.getConnection(url, user, pw);

	}
}
