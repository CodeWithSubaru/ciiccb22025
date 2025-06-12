package com.gcash.controllers;

import com.gcash.controllers.mockdata.UserAuthMockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashInTest {
	UserAuthentication auth;
	
	@BeforeEach
	public void login() {
		auth = UserAuthMockData.login();
	}
	
	@Test
	public void canCashIn() {
		BigDecimal prevBalance = auth.getUserSession().getBalance();
		
		BigDecimal amountToCashIn = BigDecimal.valueOf(2000);
		CashIn.cashIn(amountToCashIn, auth);
		BigDecimal actualBalance = auth.getUserSession().getBalance();
		
		assertEquals(0, prevBalance.add(amountToCashIn).compareTo(actualBalance), "Balance must be updated");
	}
}
