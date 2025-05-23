package activities;

public class Task8 {
	static int sum;
	public static void main(String[] args) {
		int sumOfAll = sum(4,5,10);
		System.out.println(sumOfAll);
	}
	
	public static int sum(int... numbers) {
		for(int number: numbers)
			sum += number;
		return sum;
	}
}
