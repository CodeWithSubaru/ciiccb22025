package jobsheet.job_sheet_2_5;

public class Main {
	public static void main(String[] args) {
		System.out.println("All Transactions: ");
		var transactions = new Transactions();

		for(Transaction transaction: transactions.viewAll())
			System.out.println(transaction);
		
		System.out.println("\nTransactions of User: ");
		for(Transaction transaction: transactions.viewUserAll(1))
			System.out.println(transaction);
		
		System.out.println("\nView Transaction: ");
		System.out.println(transactions.viewTransaction(28));
	}
}
