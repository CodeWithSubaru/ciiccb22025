package com.gcash.util;

import com.gcash.constants.Constant;

import javax.xml.transform.Result;
import java.sql.*;

public class DB {
		private static final String URL = Constant.URL;
		private static final String USERNAME = Constant.USER;
		private static final String PASSWORD = Constant.PASSWORD;
		
		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		
		public static ResultSet getUserAccountById(int id) {
			try {
				Connection db = getConnection();
				PreparedStatement stmt = db.prepareStatement("SELECT * FROM USERS user JOIN BALANCE balance ON user.id = balance.userId WHERE user.id = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if(!rs.next())
					throw new Exception("Something went wrong. Please try again later!");
				
				return rs;
			} catch (Exception e) {
				e.getLocalizedMessage();
				return null;
			}
		}
	
	public static ResultSet getUserAccountByNumber(String number) {
		try {
			Connection db = getConnection();
			PreparedStatement stmt = db.prepareStatement("SELECT * FROM USERS user JOIN BALANCE balance ON user.id = balance.userId WHERE user.number = ?");
			stmt.setString(1, number);
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next())
				throw new Exception("Something went wrong. Please try again later!");
			
			return rs;
		} catch (Exception e) {
			e.getLocalizedMessage();
			return null;
		}
	}
}
