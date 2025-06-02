package jobsheet.job_sheet_2_1;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {
	private static final List<User> registeredUsers = new ArrayList<>(List.of(
			new User("jeff","jeff1@gmail.com", "12345678912", "2232"),
			new User("luke","luke3@gmail.com", "12345678912", "1234"),
			new User("cath","cath123@gmail.com", "12345678912", "2632")
	));
	
	private User user;
	private boolean isAuthorize = false;
	
	public UserAuthentication(User user) {
		this.user = user;
	}
	
	public String register() {
		if(Validate.isEmpty(user.getEmail()) || Validate.isEmpty(user.getName()) || Validate.isEmpty(user.getNumber()) || Validate.isEmpty(user.getPin()))
			return "Error: All inputs are required.";
		
		if(Validate.isValidEmail(user.getEmail()))
			return "Error: Email format is invalid.";
		
		if(!Validate.isUniqueEmail(user.getEmail(), registeredUsers))
			return "Error: Email already exists.";
		
		if (!user.getName().matches("[a-zA-Z ]+"))
			return "Error: Name must only contain letters.";
		
		if (!user.getNumber().matches("\\d{11}"))
			return "Error: Number must be 11 digits.";
		
		if (!user.getPin().matches(String.format("\\d{%s}", Validate.MAX_PIN)))
			return String.format("Error: PIN must be %s digits.", Validate.MAX_PIN);
		
		registeredUsers.add(user);
		return "Success: User registered successfully!";
	}
	
	public String login() {
		if(Validate.isValidEmail(user.getEmail()) || Validate.isEmpty(user.getEmail()) || Validate.isEmpty(user.getPin()))
			return "Error: Enter valid email and/or pin";
		
		for(User registedUser: registeredUsers)
			if(registedUser.getEmail().equals(user.getEmail()) && registedUser.getPin().equals(user.getPin())) {
				user = registedUser;
				isAuthorize = true;
				return "Success: You're now login, ID: " + user.getId();
			}
		
		return "Error: Wrong Credentials";
	}
	
	public String changePin(String oldPin, String newPin) {
		if(isAuthenticated() && oldPin.equals(user.getPin())) {
			user.setPin(newPin);
			return "Success: Your pin changed successfully";
		} else {
			return "Error: Old pin incorrect";
		}
		
	}
	
	public void logout() {
		user = null;
		isAuthorize = false;
	}
	
	public boolean isAuthenticated() {
		return isAuthorize;
	}
}