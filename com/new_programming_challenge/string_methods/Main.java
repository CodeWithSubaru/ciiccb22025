package new_programming_challenge.string_methods;

public class Main {
	public static void main(String[] args) {
		String str = "java programming";
		System.out.println("Length: " + str.length());
		System.out.println("Uppercase: " + str.toUpperCase());
		System.out.println("Lowercase: " + str.toLowerCase());
		System.out.println("First char in string: " + str.charAt(0));
		System.out.println("Last char in string: " + str.charAt(str.length() - 1));
		System.out.println("Substring starts w/ 2 and ends w/ 5: " + str.substring(2, 5));
	}
}
