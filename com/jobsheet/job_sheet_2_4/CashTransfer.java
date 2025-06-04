package jobsheet.job_sheet_2_4;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CashTransfer {
	private static String query;
	private static Connection db;
	private static PreparedStatement stmt;
	
	public static void cashTransfer(BigDecimal amount, String name, int accountId, Date date, int transferToId, int transferFromId) {
		try {
			if (amount.compareTo(BigDecimal.ZERO) <= 0)
				throw new Exception("Error: Amount must be greater than zero.");
			
			if (transferFromId == transferToId)
				throw new Exception("Error: Cannot transfer to the same account.");
			
			db = DB.getConnection();
			try (ResultSet rsFrom = selectBalance(transferFromId)) {
				try (ResultSet rsTo = selectBalance(transferToId)) {
					
					if (rsFrom != null && rsTo != null && rsFrom.next() && rsTo.next()) {
						
						if (rsFrom.getBigDecimal("amount").compareTo(amount) < 0)
							throw new Exception("Error: Insufficient balance.");
						
						query = "INSERT INTO TRANSACTIONS (amount, name, account_id, date, transferToId, transferFromId) VALUES (?, ?, ?, ?, ?, ?)";
						stmt = db.prepareStatement(query);
						stmt.setBigDecimal(1, amount);
						stmt.setString(2, name);
						stmt.setInt(3, accountId);
						stmt.setDate(4, date);
						stmt.setInt(5, transferToId);
						stmt.setInt(6, transferFromId);
						
						if (stmt.executeUpdate() == 1) {
							BigDecimal totalFrom = rsFrom.getBigDecimal("amount").subtract(amount);
							BigDecimal totalTo = rsTo.getBigDecimal("amount").add(amount);
							query = "UPDATE BALANCE SET amount = ? WHERE userId = ?";
							stmt = db.prepareStatement(query);
							stmt.setBigDecimal(1, totalFrom);
							stmt.setInt(2, transferFromId);
							stmt.executeUpdate();
							
							query = "UPDATE BALANCE SET amount = ? WHERE userId = ?";
							stmt = db.prepareStatement(query);
							stmt.setBigDecimal(1, totalTo);
							stmt.setInt(2, transferToId);
							stmt.executeUpdate();
							
							System.out.println("Success: Amount transferred to ID: " + transferToId);
						}
					}
				}
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
