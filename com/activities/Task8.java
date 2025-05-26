package activities;

public class Task8 {
	
	public static void main(String[] args) {
		int sumOfAll = sum(4,5,10);
		System.out.println("Total sum of all cumulative numbers" + " = " + sumOfAll);
	}
	
	public static int sum(int... numbers) {
		int total = 0;
		
		for (int number : numbers) {
			int sumOfNumber = (number * (number + 1)) / 2;
			System.out.println("Cumulative sum for " + number + " = " + sumOfNumber);
			total += sumOfNumber;
		}
		
		return total;
	}
}
