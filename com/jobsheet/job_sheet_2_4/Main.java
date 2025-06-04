package jobsheet.job_sheet_2_4;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		CashTransfer.cashTransfer(BigDecimal.valueOf(200), "Cash Transfer", 1, Date.valueOf(LocalDate.now()), 2, 1);
	}
}
