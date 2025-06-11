package com.gcash.controllers;

import com.gcash.enums.TransactionType;
import com.gcash.model.User;
import com.gcash.util.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class CashIn {
	//  String name, int accountId, Date date, int transferFromId
	
	public static void cashIn(BigDecimal amount, UserAuthentication auth) {
		String query;
		PreparedStatement stmt;
		User currentUser = auth.getUserSession().getUser();
		auth.getUserSession().addBalance(amount);
		try(Connection db = DB.getConnection()) {
			query = "UPDATE BALANCE SET amount = ? WHERE userId = ?";
			stmt = db.prepareStatement(query);
			stmt.setBigDecimal(1, auth.getUserSession().getBalance());
			stmt.setInt(2, currentUser.getId());
			
			if(stmt.executeUpdate() == 1) {
				query = "INSERT INTO TRANSACTIONS (amount, name, account_id, date, transferToId, transferFromId) VALUES (?, ?, ?, ?, ?, ?)";
				stmt = db.prepareStatement(query);
				stmt.setBigDecimal(1, amount);
				stmt.setString(2, String.valueOf(TransactionType.CashIn));
				stmt.setInt(3, currentUser.getId());
				stmt.setDate(4, Date.valueOf(LocalDate.now()));
				stmt.setNull(5, java.sql.Types.INTEGER);
				stmt.setNull(6, java.sql.Types.INTEGER);
				
				stmt.executeUpdate();
				
				System.out.println("Success: Transaction complete!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: Something went wrong. Please try again later.");
		}
	}
}
