package com.gcash.util;

import com.gcash.model.Balance;
import com.gcash.model.User;

import java.math.BigDecimal;

public class UserSession {
	private final User user;
	private final Balance balance;
	
	public UserSession(User user, Balance balance) {
		this.user = user;
		this.balance = balance;
	}
	
	public User getUser() {
		return user;
	}
	
	public BigDecimal getBalance() {
		return balance.getAmount();
	}
	
	public void addBalance(BigDecimal amount) {
		balance.addAmount(amount);
	}
	
	public void deductBalance(BigDecimal amount) {
		balance.deductAmount(amount);
	}
}
