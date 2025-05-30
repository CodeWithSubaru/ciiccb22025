package new_programming_challenge.generate_number_of_loop_using_input;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter your number to loop: ");
		int numberOfLoop = scanner.nextInt();
		
		for(int i = 1; i <= numberOfLoop; i++) {
			for(int j = 1; j <= i; j++)
				System.out.print("* ");
			System.out.println();
		}
	}
}
