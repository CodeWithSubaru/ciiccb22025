package com.gcash.controllers;

import com.gcash.controllers.mockdata.UserAuthMockData;
import com.gcash.util.DB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CashTransferTest {
	UserAuthentication auth;
	
	@BeforeEach
	public void login() {
		auth = UserAuthMockData.login();
	}
	
	@Test
	public void itShouldUpdateBalanceForSenderAndReceiver() throws SQLException {
		// Previous amount balance
		BigDecimal prevBalance = auth.getUserSession().getBalance();
		BigDecimal amountToTransfer = BigDecimal.valueOf(200);
		
		String numberOfReceiver = "09203923123";
		ResultSet rs = DB.getUserAccountByNumber(numberOfReceiver);
		BigDecimal prevBalanceReceiver = rs.getBigDecimal("amount");
		
		CashTransfer.cashTransfer(amountToTransfer, numberOfReceiver, auth);
		BigDecimal actualBalance = auth.getUserSession().getBalance();
		
		ResultSet rsBalanceReceiver = DB.getUserAccountByNumber(numberOfReceiver);
		BigDecimal actualBalanceReceiver = rs.getBigDecimal("amount");
		
		assertEquals(0,
				prevBalance.subtract(amountToTransfer).compareTo(actualBalance),
				"New Balance must be same as previous balance of sender"
		);
		
		assertEquals(0,
				prevBalanceReceiver.compareTo(actualBalanceReceiver),
				"New Balance must be same as previous balance of receiver"
		);
	}
}
