package new_programming_challenge.string_builder;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static final int MINIMUM_CHAR_REQ = 10;
	
	public static void main(String[] args) {
		StringBuilder str = null;
		
		try {
			System.out.print("Enter your input: ");
			str = new StringBuilder(scanner.nextLine());
			if (str.length() <= MINIMUM_CHAR_REQ)
				throw new Exception("Please enter at least 10 characters");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Length: " + str.length());
		System.out.println("First Character: " + str.charAt(0));
		System.out.println("Last Character: " + str.charAt(str.length() - 1));
		System.out.println("Index of 'a': " + str.indexOf("a"));
		System.out.println("Substring of 3, 6: " + str.substring(3, 6));
		System.out.println("Appending '123': " + str.append(123));
		System.out.println("Inserting 'xyz' at index 4: " + str.insert(4, "xyz"));
		System.out.println("Delete substring 2, 4: " + str.delete(2, 4));
		System.out.println("Delete character at index 8: " + str.deleteCharAt(8));
		System.out.println("Reverse: " + str.reverse());
	}
}
