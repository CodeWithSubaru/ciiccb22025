package activities;

import java.util.Scanner;

public class Task5 {
	static Scanner scanner = new Scanner(System.in);
	static String result;
	
	public static void main(String[] args) {
		promptMsg("first");
		int firstNum = scanner.nextInt();
		
		promptMsg("second");
		int secondNum = scanner.nextInt();
		
		promptMsg("third");
		int thirdNum = scanner.nextInt();
		
		result = (firstNum == secondNum) && (firstNum == thirdNum)
				                  ? firstNum + " " + secondNum + " " + thirdNum
				                  : ((firstNum >= secondNum && firstNum >= thirdNum) ? firstNum : (secondNum >= firstNum && secondNum >= thirdNum) ? secondNum : thirdNum) + "";
		
		
		System.out.println("Largest numbers: " + result);
	}
	
	public static void promptMsg(String number) {
		System.out.println("Enter your " + number + " Number: ");
	}
}
