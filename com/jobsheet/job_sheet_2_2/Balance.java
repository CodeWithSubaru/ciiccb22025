package jobsheet.job_sheet_2_2;

import java.math.BigDecimal;

public class Balance {
	private final int id;
	private final BigDecimal amount;
	private final int user_id;

	public Balance(int id, BigDecimal amount, int user_id) {
		this.id = id;
		this.amount = amount;
		this.user_id = user_id;
	}
	
	public int getId() {
		return id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public BigDecimal checkBalance() {
		return getAmount();
	}
	
}
