package new_programming_challenge.check_vowel_and_consonant;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String[] args) {
		System.out.println("Enter your String: ");
		String str = scanner.nextLine();
		
		int vowelCounter = 0;
		int consonantCounter = 0;
		for (int i = 0; i < str.length(); i++) {
			char character = str.toLowerCase().charAt(i);
			if(isVowel(character))
				vowelCounter++;
			else if(Character.isLetter(character))
				consonantCounter++;
		}
		
		System.out.println("Vowel: " + vowelCounter);
		System.out.println("Consonant: " + consonantCounter);
	}
	
	public static boolean isVowel(char character) {
		for (char v: vowel)
			 if(v == character) return true;
		
		return false;
	}
}
