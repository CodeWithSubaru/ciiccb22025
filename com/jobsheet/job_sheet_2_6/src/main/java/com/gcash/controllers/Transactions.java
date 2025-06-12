package com.gcash.controllers;

import com.gcash.model.Transaction;
import com.gcash.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transactions {
	private static String query;
	private static Connection db;
	private static PreparedStatement stmt;
	private static List<Transaction> transactions = new ArrayList<>();
	
	public static List<Transaction> viewAll() {
		try {
			String query = "SELECT t.*, sender.name AS account_name, sender.name AS sender_name, receiver.name AS receiver_name FROM TRANSACTIONS t JOIN USERS sender ON sender.id = t.account_id LEFT JOIN USERS receiver ON receiver.id = t.transferToId";
			db = DB.getConnection();
			stmt = db.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				transactions.add(new Transaction(
						rs.getInt("id"),
						rs.getBigDecimal("amount"),
						rs.getString("name"),
						rs.getString("account_name"),
						rs.getDate("date"),
						rs.getString("sender_name"),
						rs.getString("receiver_name")
				));
			}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
		return transactions;
	}
	
	public static List<Transaction> viewUserAll(int userId) {
		try {
			String query = "SELECT t.*, sender.name AS sender_name, receiver.name AS receiver_name, sender.name AS sender_name FROM TRANSACTIONS t JOIN USERS sender ON sender.id = t.account_id LEFT JOIN USERS receiver ON receiver.id = t.transferToId WHERE account_id = ?";
			db = DB.getConnection();
			stmt = db.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			
			
			
			while (rs.next()) {
				transactions.add(new Transaction(
						rs.getInt("id"),
						rs.getBigDecimal("amount"),
						rs.getString("name"),
						rs.getString("account_name"),
						rs.getDate("date"),
						rs.getString("sender_name"),
						rs.getString("receiver_name")
				));
			}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
		return transactions;
	}
	
	public static Transaction viewTransaction(int transactionId) {
		Transaction transaction = null;
		
		try {
			query = "SELECT t.*, sender.name AS account_name, sender.name AS sender_name, receiver.name AS receiver_name FROM TRANSACTIONS t JOIN USERS sender ON sender.id = t.transferFromId LEFT JOIN USERS receiver ON receiver.id = t.transferToId WHERE t.id = ?";
			db = DB.getConnection();
			stmt = db.prepareStatement(query);
			stmt.setInt(1, transactionId);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				transaction = new Transaction(
						rs.getInt("id"),
						rs.getBigDecimal("amount"),
						rs.getString("name"),
						rs.getString("account_name"),
						rs.getDate("date"),
						rs.getString("sender_name"),
						rs.getString("receiver_name"));
			}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
		
		return transaction;
	}
}
