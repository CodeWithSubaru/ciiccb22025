package jobsheet.job_sheet_2_1;

public class Main {
		static User user;
		
		public static void main(String[] args) {
			while(true) {
				String[] welcomeOptions = {"Login", "Register", "Exit"};
				String[] appOptions = {"Change Pin", "Logout"};
				Console.log("Welcome to GCash App\n");
				Console.line();
				Console.options(welcomeOptions);
				Console.line();
				String operation = Console.log("Choose your operation [1-3]: ")
						                   .nextLine();
				
				if(operation.equals("1")) {
						Console.log("\nLogin your credentials\n\n");
						String email = Console.log("Enter your email: ").nextLine();
						String pin = Console.log("Enter your pin (4 digits): ").nextLine();
						
						user = new User(email, pin);
						UserAuthentication auth = new UserAuthentication(user);
						auth.login();
						flashMessage(auth);
					
					while(auth.isAuthenticated()) {
						Console.line();
						Console.options(appOptions);
						Console.line();
						String newOperation = Console.log("Choose your operation [1-2]: ").nextLine();
						if (newOperation.equals("1")) {
							while(true) {
								String oldPin = Console.log("Enter your old pin (4 digits): ").nextLine();
								String newPin = Console.log("Enter your new pin (4 digits): ").nextLine();
								auth.changePin(oldPin, newPin);
								if(!auth.hasErrorMsgs()) {
									flashMessage(auth);
									break;
								}
								flashMessage(auth);
							}
						} else if(newOperation.equals("2"))
							auth.logout();
						else
							inValidOperation();
					}
				} else if(operation.equals("2")) {
					Console.log("\nRegister your information\n\n");
					String name = Console.log("Enter your name: ").nextLine();
					String email = Console.log("Enter your email: ").nextLine();
					String number = Console.log("Enter your number: ").nextLine();
					String pin = Console.log("Enter your pin (4 digits): ").nextLine();
					
					user = new User(name, email, number, pin);
					UserAuthentication auth = new UserAuthentication(user);
					auth.register();
					flashMessage(auth);
					
				} else if (isEqualsTo(operation, welcomeOptions.length)) {
					inValidOperation();
				} else {
					Console.log("Bye, see you again soon! :)");
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