package com.gcash.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
	private final int id;
	private final BigDecimal amount;
	private final String name;
	private String accountName;
	private int accountId;
	private final Date date;
	private String transferToName;
	private String transferFromName;
	private int transferToId;
	private int transferFromId;
	
	public Transaction(int id, BigDecimal amount, String name, String accountName, Date date, String transferFromName, String transferToName) {
		this.id = id;
		this.amount = amount;
		this.name = name;
		this.accountName = accountName;
		this.date = date;
		this.transferFromName = transferFromName;
		this.transferToName = transferToName;
	}
	
	public Transaction(int id, BigDecimal amount, String name, int accountId, Date date, int transferFromId, int transferToId) {
		this.id = id;
		this.amount = amount;
		this.name = name;
		this.accountId = accountId;
		this.date = date;
		this.transferFromId = transferFromId;
		this.transferToId = transferToId;
	}
	
	public int getId() {
		return id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTransferFromName() {
		return transferFromName;
	}
	
	public String getTransferToName() {
		return transferToName;
	}
	
	public int getTransferToId() {
		return transferToId;
	}
	
	public int getTransferFromId() {
		return transferFromId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	@Override
	public String toString() {
		String append = ", From: " + getTransferFromName() +
				                ", To: " + getTransferToName();
		
		if(getName().equals("CashIn"))
			append = ", Account: " + getAccountName();
			
		return "[" + id + "] - " + "Amount: " + getAmount() +
				       ", Name of Transaction: " + getName() + append +
				       ", Date: " + getDate();
	}
	
	
}
