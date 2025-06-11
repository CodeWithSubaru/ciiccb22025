package com.gcash.model;

import java.math.BigDecimal;

public class Balance {
	private final int id;
	private BigDecimal amount;
	private final User user;

	public Balance(int id, BigDecimal amount, User user_id) {
		this.id = id;
		this.amount = amount;
		this.user = user_id;
	}
	
	public int getId() {
		return id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void addAmount(BigDecimal amount) {
		if(amount.compareTo(BigDecimal.ZERO) > 0)
			this.amount = this.amount.add(amount);
	}
	
	public void deductAmount(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) > 0 && this.amount.compareTo(amount) >= 0)
			this.amount = this.amount.subtract(amount);
	}
}
