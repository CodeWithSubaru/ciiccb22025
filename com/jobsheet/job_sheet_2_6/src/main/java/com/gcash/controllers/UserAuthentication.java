package com.gcash.controllers;

import com.gcash.util.Message;
import com.gcash.model.Balance;
import com.gcash.model.User;
import com.gcash.util.*;

import java.math.BigDecimal;
import java.sql.*;

public class UserAuthentication {
	private User user;
	private UserSession userSession;
	private final Message message;
	private boolean isAuthorize = false;
	
	public UserAuthentication(User user) {
		this.user = user;
		message = new Message();
	}
	
	public void register() {
		if(Validate.isEmpty(user.getEmail()) || Validate.isEmpty(user.getName()) || Validate.isEmpty(user.getNumber()) || Validate.isEmpty(user.getPin()))
			message.setError("Error: All inputs are required.");
		
		if(!(Validate.isValidEmail(user.getEmail())))
			message.setError("Error: Invalid Email format.");
		
		if(!(Validate.isUniqueEmail(user.getEmail())))
			message.setError("Error: Email already exists.");
		
		if (!user.getName().matches("[a-zA-Z ]{3,}"))
			message.setError("Error: Name must only contain letters and must be at least 3 characters.");
		
		if (!user.getNumber().matches("\\d{11}"))
			message.setError("Error: Number must be 11 digits.");
		
		if(!Validate.isUniqueNumber(user.getNumber()))
			message.setError("Error: Number already exists");
		
		if (!user.getPin().matches(String.format("\\d{%s}", Validate.MAX_PIN)))
			message.setError(String.format("Error: PIN must be %s digits.", Validate.MAX_PIN));
		
		if(hasErrorMsgs())
			return;
		
		String query;
		Connection db;
		PreparedStatement stmt;
		
		try {
			query = "INSERT INTO USERS (name, email, number, pin) VALUES (?, ?, ?, ?)";
			db = DB.getConnection();
			stmt = db.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getNumber());
			stmt.setString(4, Util.hash(user.getPin()));
			
			if(stmt.executeUpdate() == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int userId = rs.getInt(1);
					query = "INSERT INTO BALANCE (amount, userId) VALUES (?, ?)";
					stmt = db.prepareStatement(query);
					stmt.setBigDecimal(1, BigDecimal.valueOf(0));
					stmt.setInt(2, userId);
					stmt.executeUpdate();
				}
			}
			
			message.setSuccess("Success: User registered successfully!");
		} catch(Exception e) {
			message.setError("Error: Something went wrong, Please try again later! :(");
		}
	}
	
	public void login() {
		if(!Validate.isValidEmail(user.getEmail()))
			message.setError("Error: Email format is invalid.");
		
		if(Validate.isEmpty(user.getEmail()) || Validate.isEmpty(user.getPin()))
			message.setError("Error: Fill up the fields correctly.");
		
		try {
			String query = "SELECT * FROM USERS user JOIN BALANCE b ON user.id = b.userId WHERE user.email = ?";
			Connection db = DB.getConnection();
			PreparedStatement stmt = db.prepareStatement(query);
			stmt.setString(1, user.getEmail());
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String hashedPinFromDB = rs.getString("pin");
				boolean isCorrectPin = Util.verify(user.getPin(), hashedPinFromDB);
				
				if(isCorrectPin) {
					userSession = new UserSession(
							new User(rs.getInt("id"),
									rs.getString("name"),
									rs.getString("email"),
									rs.getString("number"),
									hashedPinFromDB),
							new Balance(rs.getInt("id"),
									rs.getBigDecimal("amount"),
									user));
					isAuthorize = true;
					message.setSuccess("Success: Login Success! You're now login, ID: " + userSession.getUser().getId());
				} else {
					message.setError("Error: Incorrect PIN.");
				}
			} else {
				message.setError("Error: Email not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong. Please try again later...");
		}
	}
	
	public void changePin(String oldPin, String newPin) {
		if(oldPin.equals(userSession.getUser().getPin())) {
			message.setError("Error: New PIN must be different from the old PIN.");
			return;
		}
		
		if(userSession != null && Util.verify(oldPin, userSession.getUser().getPin())) {
			try {
				String hashedPin = Util.hash(newPin);
				Connection db = DB.getConnection();
				PreparedStatement stmt = db.prepareStatement("UPDATE USERS SET pin = ? WHERE id = ?");
				stmt.setString(1, hashedPin);
				stmt.setInt(2, userSession.getUser().getId());
				if(stmt.executeUpdate() == 1)
					user.setPin(hashedPin);
				
				message.setError("Success: Your pin changed successfully");
			} catch (Exception e) {
				message.setError("Error: Something went wrong while changing your pin. Please try again later!");
			}
			
		} else {
			message.setError("Error: Old pin incorrect");
		}
	}
	
	public void logout() {
		user = null;
		userSession = null;
	}
	
	public UserSession getUserSession() {
		return userSession;
	}
	
	public boolean isAuthenticated() {
		return isAuthorize;
	}
	
	public String flashErrors() {
		return message.flashErrors();
	}
	
	public String flashSuccess() {
		return message.flashSuccess();
	}
	
	public boolean hasSuccessMsg() {
		return message.hasSuccessMsg();
	}
	
	public boolean hasErrorMsgs() {
		return message.hasErrorMsgs();
	}
	
	public void unsetMessages() {
		message.unsetMessages();
	}
	
}
