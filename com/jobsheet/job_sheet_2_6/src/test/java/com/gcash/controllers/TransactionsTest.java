package com.gcash.controllers;

import com.gcash.controllers.mockdata.UserAuthMockData;
import com.gcash.enums.TransactionType;
import com.gcash.model.Transaction;
import com.gcash.model.User;
import com.gcash.util.DB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsTest {
	UserAuthentication auth;
	@BeforeEach
	public void login() {
		auth = UserAuthMockData.login();
	}
	
	@Test
	public void itShouldDisplayTransactions() throws SQLException {
		
		Transaction transaction;
		
		Connection db = DB.getConnection();
		PreparedStatement stmt = db.prepareStatement(
					"INSERT INTO TRANSACTIONS (amount, name, account_id, date, transferFromId, transferToId) VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setBigDecimal(1, BigDecimal.valueOf(200));
			stmt.setString(2, String.valueOf(TransactionType.CashTransfer));
			stmt.setInt(3, auth.getUserSession().getUser().getId());
			stmt.setDate(4, Date.valueOf(LocalDate.now()));
			stmt.setInt(5, auth.getUserSession().getUser().getId());
			stmt.setInt(6, 6);
			stmt.executeUpdate();
		
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				// latest row generated
				int newId = rs.getInt(1);
			
					Transaction viewTransactionById = Transactions.viewTransaction(newId);
					ResultSet receiver = DB.getUserAccountById(6);
				System.out.println(viewTransactionById);
					assertEquals(0, viewTransactionById.getTransferFromName().compareTo(auth.getUserSession().getUser().getName()), "Sender name must match to authenticated user");
					if(receiver.next())
						assertEquals(0, viewTransactionById.getTransferToName().compareTo(receiver.getString("name")), "Receiver name must match from user");
				}
	}
}
