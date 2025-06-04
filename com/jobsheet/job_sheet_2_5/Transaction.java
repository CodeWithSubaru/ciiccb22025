package jobsheet.job_sheet_2_5;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
	@Override
	public String toString() {
		return "Transaction{" +
				       "accountId=" + accountId +
				       ", id=" + id +
				       ", amount=" + amount +
				       ", name='" + name + '\'' +
				       ", date=" + date +
				       ", transferToId=" + transferToId +
				       ", transferFromId=" + transferFromId +
				       '}';
	}
	
	private final int id;
	private final BigDecimal amount;
	private final String name;
	private final int accountId;
	private final Date date;
	private final int transferToId;
	private final int transferFromId;
	
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
	
	public int getAccountId() {
		return accountId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTransferFromId() {
		return transferFromId;
	}
	
	public int getTransferToId() {
		return transferToId;
	}
}
