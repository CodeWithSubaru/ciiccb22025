package com.gcash.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public final static int MAX_PIN = 4;
	
	public static boolean isEmpty(String input) {
		return input.isEmpty();
	}
	
	public static boolean isValidEmail(String email) {
		return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
	}
	
	public static boolean isUniqueEmail(String email) {
		try {
			Connection db = DB.getConnection();
			String query = "SELECT 1 FROM USERS WHERE email = ? LIMIT 1";
			PreparedStatement stmt = db.prepareStatement(query);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			return !rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isUniqueNumber(String number) {
		try {
			Connection db = DB.getConnection();
			String query = "SELECT 1 FROM USERS WHERE number = ? LIMIT 1";
			PreparedStatement stmt = db.prepareStatement(query);
			stmt.setString(1, number);
			ResultSet rs = stmt.executeQuery();
			return !rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
