package jobsheet.job_sheet_2_3;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		CashIn.cashIn( BigDecimal.valueOf(200), "CashIn", 1, Date.valueOf(LocalDate.now()), 2, 1);
		
		CashIn.cashIn(BigDecimal.valueOf(300), "CashIn", 1, Date.valueOf(LocalDate.now()), 2, 1);
	}
}
