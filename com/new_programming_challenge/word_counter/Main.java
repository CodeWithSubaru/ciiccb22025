package new_programming_challenge.word_counter;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Word counter");
		System.out.println("=== ===");
		System.out.print("Enter a sentence: ");
		String sentence = scanner.nextLine();
		
		System.out.println(method1(sentence));
		System.out.println(method2(sentence));
	}
	
	public static int method1(String sentence) {
		return sentence.trim().isEmpty() ? 0 : sentence.split(" ").length;
	}
	
	public static int method2(String sentence) {
		if (sentence.trim().isEmpty())
			return 0;
		
		sentence = sentence.trim();
		int wordCount = 0;
		boolean inWord = false;
		
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c != ' ') {
				if (!inWord) {
					wordCount++;
					inWord = true;
				}
			} else {
				inWord = false;
			}
		}
		
		return wordCount;
	}
}
