package jobsheet.job_sheet_2_1;

import java.util.Scanner;

public class Main {
		static Scanner scanner = new Scanner(System.in);
		static User user;
		
		public static void main(String[] args) {
			while(true) {
				System.out.println("Welcome to GCash App");
				System.out.println("========================");
				System.out.println("[1] - Login");
				System.out.println("[2] - Register");
				System.out.println("[3] - Exit");
				System.out.println("========================\n");
				System.out.print("Choose your operation [1-3]: ");
				String operation = scanner.nextLine();
				
				if(operation.equals("1")) {
					
					System.out.print("Enter your email: ");
					String email = scanner.nextLine();
					System.out.print("Enter your pin: ");
					String pin = scanner.nextLine();
					
					user = new User(email, pin);
					UserAuthentication auth = new UserAuthentication(user);
					String isLogin = auth.login();
					System.out.printf("\n%s\n\n", isLogin);
					
					while(auth.isAuthenticated()) {
						System.out.println("========================");
						System.out.println("[1] - Change Pin");
						System.out.println("[2] - Logout");
						System.out.println("========================\n");
						System.out.print("Choose your operation [1-2]: ");
						String newOperation = scanner.nextLine();
						if (newOperation.equals("1")) {
							System.out.print("Enter your old pin: ");
							String oldPin = scanner.nextLine();
							System.out.print("Enter your new pin: ");
							String newPin = scanner.nextLine();
							String isPinChanged = auth.changePin(oldPin, newPin);
							System.out.printf("\n%s\n\n", isPinChanged);
						} else if(newOperation.equals("2"))
							auth.logout();
						else
							inValidOperation();
					}
				} else if(operation.equals("2")) {
					System.out.print("Enter your name: ");
					String name = scanner.nextLine();
					System.out.print("Enter your email: ");
					String email = scanner.nextLine();
					System.out.print("Enter your number: ");
					String number = scanner.nextLine();
					System.out.print("Enter your pin: ");
					String pin = scanner.nextLine();
					
					user = new User(name, email, number, pin);
					String isRegistered = new UserAuthentication(user).register();
					System.out.printf("\n%s\n\n", isRegistered);
				} else {
					System.out.println("Bye, see you again soon! :)");
					break;
				}
				
			}
		}
		
		public static void inValidOperation () {
			System.out.println("Invalid Operation");
		}
}
