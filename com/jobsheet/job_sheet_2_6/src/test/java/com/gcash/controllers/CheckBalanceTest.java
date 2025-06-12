package com.gcash.controllers;

import com.gcash.controllers.mockdata.UserAuthMockData;
import com.gcash.util.DB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckBalanceTest {
	UserAuthentication auth;
	
	@BeforeEach
	public void login() {
		auth = UserAuthMockData.login();
	}
	
	@Test
	public void itShouldSameBalance() throws SQLException {
		BigDecimal initialBalance = auth.getUserSession().getBalance();
		
		ResultSet rs = DB.getUserAccountById(auth.getUserSession().getUser().getId());
		
		assertNotNull(rs);
		assertEquals(0, initialBalance.compareTo(rs.getBigDecimal("amount")), "Authenticated user should be same balance from DB");
	}
}
