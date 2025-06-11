package com.gcash.controllers;

import com.gcash.enums.TransactionType;
import com.gcash.util.DB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class CashTransfer {
	private static String query;
	private static Connection db;
	private static PreparedStatement stmt;
	
	public static void cashTransfer(BigDecimal amount, String transferToNumber, UserAuthentication auth) {
		try {
			db = DB.getConnection();
			query = "SELECT * FROM USERS u JOIN BALANCE b ON u.id = b.userId WHERE u.number = ?";
			stmt = db.prepareStatement(query);
			stmt.setString(1, transferToNumber);
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next()) return;
			
			if (amount.compareTo(BigDecimal.ZERO) <= 0)
				throw new Exception("Error: Amount must be greater than zero.");
			
			int transferFromId = auth.getUserSession().getUser().getId();
			int transferToId = rs.getInt("id");
			BigDecimal transferToAmount = rs.getBigDecimal("amount");
			
			
			if (transferFromId == transferToId)
				throw new Exception("Error: Cannot transfer to the same account.");
					
			if (auth.getUserSession().getBalance().compareTo(amount) < 0)
				throw new Exception("Error: Insufficient balance.");
			
			auth.getUserSession().deductBalance(amount);
			
			
			query = "INSERT INTO TRANSACTIONS (amount, name, account_id, date, transferToId, transferFromId) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = db.prepareStatement(query);
			stmt.setBigDecimal(1, amount);
			stmt.setString(2, String.valueOf(TransactionType.CashTransfer));
			stmt.setInt(3, transferFromId);
			stmt.setDate(4, Date.valueOf(LocalDate.now()));
			stmt.setInt(5, transferToId);
			stmt.setInt(6, transferFromId);
			
			if (stmt.executeUpdate() == 1) {
				auth.getUserSession().deductBalance(amount);
				query = "UPDATE BALANCE SET amount = ? WHERE userId = ?";
				stmt = db.prepareStatement(query);
				stmt.setBigDecimal(1, auth.getUserSession().getBalance());
				stmt.setInt(2, transferFromId);
				stmt.executeUpdate();
				
				transferToAmount = transferToAmount.add(amount);
				query = "UPDATE BALANCE SET amount = ? WHERE userId = ?";
				stmt = db.prepareStatement(query);
				stmt.setBigDecimal(1, transferToAmount);
				stmt.setInt(2, transferToId);
				stmt.executeUpdate();
				
				System.out.println("Success: Amount transferred to ID: " + transferToId);
			}
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public static ResultSet selectBalance(int id) {
		try {
			query = "SELECT * FROM BALANCE WHERE userId = ?";
			stmt = db.prepareStatement(query);
			stmt.setInt(1, id);
			return stmt.executeQuery();
		} catch (Exception e) {
			System.out.println("Error: Something went wrong");
			return null;
		}
	}
}
