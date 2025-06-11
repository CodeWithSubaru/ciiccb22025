package com.gcash.util;

import java.math.BigDecimal;
import java.util.Scanner;

public class Console {
	static Scanner scanner = new Scanner(System.in);
	
	public static void log(String msg) {
		log(msg, true);
	}
	
	public static void log(String msg, boolean isNewLine) {
		if(isNewLine)
			System.out.println(msg);
		else
			System.out.print(msg);
	}
	
	public static BigDecimal promptBigDecimal(String msg) {
		System.out.print(msg);
		BigDecimal value = scanner.nextBigDecimal();
		scanner.nextLine();
		return value;
	}
	
	public static Scanner prompt(String msg) {
		System.out.print(msg);
		return scanner;
	}
	
	public static void options(String... prompts) {
		int counter = 0;
		for (String prompt: prompts) {
			System.out.printf("%s - %s\n", ++counter, prompt);
		}
	}
	
	public static void line() {
		System.out.println("========================");
	}
}
