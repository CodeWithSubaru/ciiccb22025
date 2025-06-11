package com.gcash;

import com.gcash.controllers.*;
import com.gcash.model.*;
import com.gcash.util.*;

import java.math.BigDecimal;

public class Main {
	static User user;
	
	public static void main(String[] args) {
		
		while(true) {
			String[] welcomeOptions = {"Login", "Register", "Exit"};
			String[] appOptions = {"Check Balance", "Cash In", "Cash Transfer", "Transactions", "Change Pin", "Logout"};
			Console.prompt("Welcome to GCash App\n");
			Console.line();
			Console.options(welcomeOptions);
			Console.line();
			String operation = Console.prompt("Choose your operation [1-3]: ")
					                   .nextLine();
			
			if(operation.equals("1")) {
				Console.prompt("\nLogin your credentials\n\n");
				String email = Console.prompt("Enter your email: ").nextLine();
				String pin = Console.prompt("Enter your pin (4 digits): ").nextLine();
				
				user = new User(email, pin);
				UserAuthentication auth = new UserAuthentication(user);
				auth.login();
				flashMessage(auth);
				
				while(auth.isAuthenticated()) {
					Console.log("\nOperations: ");
					Console.line();
					Console.options(appOptions);
					Console.line();
					String newOperation = Console.prompt("Choose your operation [1-6]: ").nextLine();
					Console.log("\n");
					
					if (newOperation.equals("1")) {
						Console.log("\nBalance");
						Console.log("\nYour current balance: " + auth.getUserSession().getBalance());
					} else if(newOperation.equals("2")) {
						Console.log("\nCash In");
						Console.log("\nYour current balance: " + auth.getUserSession().getBalance());
						BigDecimal amount = Console.promptBigDecimal("\nAmount to cash in: ");
						CashIn.cashIn(amount, auth);
					} else if (newOperation.equals("3")) {
						Console.log("\nCash Transfer");
						Console.log("\nYour current balance: " + auth.getUserSession().getBalance());
						BigDecimal amount = Console.promptBigDecimal("Amount to transfer: ");
						String transferToNumber = Console.prompt("Mobile Number: ").nextLine();
						CashTransfer.cashTransfer(amount, transferToNumber, auth);
					} else if (newOperation.equals("4")) {
						Console.log("\nTransactions");
						for (Transaction transaction: Transactions.viewUserAll(auth.getUserSession().getUser().getId()))
							System.out.println(transaction);
						
					} else if(newOperation.equals("5")) {
						Console.log("\nChange Pin");
						while (true) {
							String oldPin = Console.prompt("Enter your old pin (4 digits): ").nextLine();
							String newPin = Console.prompt("Enter your new pin (4 digits): ").nextLine();
							auth.changePin(oldPin, newPin);
							if (!auth.hasErrorMsgs()) {
								flashMessage(auth);
								break;
							} else {
								flashMessage(auth);
								break;
							}
							
						}

					} else if (newOperation.equals("6")) {
						auth.logout();
						break;
					} else {
						inValidOperation();
					}
				}
			} else if(operation.equals("2")) {
				Console.prompt("\nRegister your information\n\n");
				String name = Console.prompt("Enter your name: ").nextLine();
				String email = Console.prompt("Enter your email: ").nextLine();
				String number = Console.prompt("Enter your mobile number: ").nextLine();
				String pin = Console.prompt("Enter your pin (4 digits): ").nextLine();
				
				user = new User(name, email, number, pin);
				UserAuthentication auth = new UserAuthentication(user);
				auth.register();
				flashMessage(auth);
			} else if (isEqualsTo(operation, welcomeOptions.length)) {
				inValidOperation();
			} else {
				Console.prompt("Bye, see you again soon! :)");
				break;
			}
		}
	}
	
	public static boolean isEqualsTo(String chosenOperation, int numOfOperations) {
		for (int i = 0; i <= numOfOperations; i++)
			if(chosenOperation.equals(String.valueOf(i)))
				return false;
		
		return true;
	}
	
	public static void inValidOperation () {
		System.out.println("Invalid Operation");
	}
	
	public static void flashMessage(UserAuthentication auth) {
		System.out.println("\n");
		if(auth.hasErrorMsgs())
			System.out.println(auth.flashErrors());
		else
			System.out.println(auth.flashSuccess());
		
		auth.unsetMessages();
		System.out.println();
	}
}