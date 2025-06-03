package jobsheet.job_sheet_2_1;

import java.util.Scanner;

public class Console {
	static Scanner scanner = new Scanner(System.in);
	
	public static Scanner log(String msg) {
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
