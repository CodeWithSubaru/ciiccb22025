package jobsheet.job_sheet_2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		try {
				String query = "SELECT * FROM BALANCE WHERE id = ?";
				Connection db = DB.getConnection();
				PreparedStatement stmt = db.prepareStatement(query);
				stmt.setInt(1, 1);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					Balance balance = new Balance(rs.getInt("id"),
							rs.getBigDecimal("amount"),
							rs.getInt("userId"));
					System.out.println("Check Balance: " + balance.checkBalance());
				}
		} catch (Exception e) {
			System.out.println("Error: Something went wrong!");
		}
	}
}
