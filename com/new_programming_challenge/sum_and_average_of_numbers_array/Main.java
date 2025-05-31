package new_programming_challenge.sum_and_average_of_numbers_array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("How many numbers do you want to enter? ");
		int size = scanner.nextInt();
		
		int[] numbers = new int[size];
		
		System.out.println();
		System.out.println("Enter " + size + " numbers");
		
		for (int i = 0; i < size; i++) {
			System.out.printf("Number %s: ", i + 1);
			numbers[i] = scanner.nextInt();
		}
		
		System.out.println();
		System.out.println();
		System.out.printf("Array: %s", Arrays.toString(numbers));
		
		int sum = 0;
		for (Integer num : numbers)
			sum += num;
		
		int average = sum / numbers.length;
		
		System.out.println();
		System.out.printf("Sum: %s", sum);
		System.out.println();
		System.out.printf("Average: %s", average);
	}
}
