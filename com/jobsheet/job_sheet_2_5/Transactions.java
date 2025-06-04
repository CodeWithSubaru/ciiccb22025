package jobsheet.job_sheet_2_5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transactions {
	private String query;
	private Connection db;
	private PreparedStatement stmt;
	private final List<Transaction> transactions = new ArrayList<>();
	
	public List<Transaction> viewAll() {
		try {
			query = "SELECT * FROM TRANSACTIONS";
			db = DB.getConnection();
			stmt = db.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				transactions.add(new Transaction(
						rs.getInt("id"),
						rs.getBigDecimal("amount"),
						rs.getString("name"),
						rs.getInt("account_id"),
						rs.getDate("date"),
						rs.getInt("transferToId"),
						rs.getInt("transferFromId")
				));
			}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
		return transactions;
	}
	
	public List<Transaction> viewUserAll(int userId) {
		try {
			String query = "SELECT * FROM TRANSACTIONS WHERE account_id = ?";
			db = DB.getConnection();
			stmt = db.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				transactions.add(new Transaction(
						rs.getInt("id"),
						rs.getBigDecimal("amount"),
						rs.getString("name"),
						rs.getInt("account_id"),
						rs.getDate("date"),
						rs.getInt("transferToId"),
						rs.getInt("transferFromId")
				));
			}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
		return transactions;
	}
	
	public Transaction viewTransaction(int transactionId) {
		Transaction transaction = null;
		try {
			query = "SELECT * FROM TRANSACTIONS WHERE id = ?";
			db = DB.getConnection();
			stmt = db.prepareStatement(query);
			stmt.setInt(1, transactionId);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				transaction = new Transaction(
						rs.getInt("id"),
						rs.getBigDecimal("amount"),
						rs.getString("name"),
						rs.getInt("account_id"),
						rs.getDate("date"),
						rs.getInt("transferToId"),
						rs.getInt("transferFromId"));
			}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
		
		return transaction;
	}
}
