package jobsheet.job_sheet_2_3;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class CashIn {
	
	public static void cashIn(BigDecimal amount, String name, int accountId, Date date, int transferToId, int transferFromId) {
		
		try {
			String query = "INSERT INTO TRANSACTIONS (amount, name, account_id, date, transferToId, transferFromId) VALUES (?, ?, ?, ?, ?, ?)";
			Connection db = DB.getConnection();
			PreparedStatement stmt = db.prepareStatement(query);
			stmt.setBigDecimal(1, amount);
			stmt.setString(2, name);
			stmt.setInt(3, accountId);
			stmt.setDate(4, date);
			stmt.setInt(5, transferToId);
			stmt.setInt(6, transferFromId);
			
			stmt.executeUpdate();
			System.out.println("Success: Data inserted");
		} catch (Exception e) {
			System.out.println("Error: Something went wrong. Please try again later.");
		}
	}
}
