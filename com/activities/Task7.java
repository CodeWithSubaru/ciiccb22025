package activities;

public class Task7 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		int sum = Math.sum(a,b);
		System.out.println(sum);
		
		int difference = Math.difference(a,b);
		System.out.println(difference);
		
		int product = Math.product(a,b);
		System.out.println(product);
		
		int quotient = Math.quotient(a,b);
		System.out.println(quotient);
	}
}

class Math {
	static int sum(int a, int b) {
		return a + b;
	}
	
	static int difference(int a, int b) {
		return a - b;
	}
	
	static int product(int a, int b) {
		return a - b;
	}
	
	static int quotient(int a, int b) {
		return a / b;
	}
}
