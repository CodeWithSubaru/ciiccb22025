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
	private final Message message;

	public UserAuthentication(User user) {
		this.user = user;
		message = new Message();
	}
	
	public void register() {
		if(Validate.isEmpty(user.getEmail()) || Validate.isEmpty(user.getName()) || Validate.isEmpty(user.getNumber()) || Validate.isEmpty(user.getPin()))
			message.setError("Error: All inputs are required.");
		
		if(Validate.isValidEmail(user.getEmail()))
			message.setError("Error: Invalid Email format.");
		
		if(!Validate.isUniqueEmail(user.getEmail(), registeredUsers))
			message.setError("Error: Email already exists.");
		
		if (!user.getName().matches("[a-zA-Z ]+"))
			message.setError("Error: Name must only contain letters.");
		
		if (!user.getNumber().matches("\\d{11}"))
			message.setError("Error: Number must be 11 digits.");
		
		if (!user.getPin().matches(String.format("\\d{%s}", Validate.MAX_PIN)))
			message.setError(String.format("Error: PIN must be %s digits.", Validate.MAX_PIN));
		
		registeredUsers.add(user);
		message.setSuccess("Success: User registered successfully!");
	}
	
	public void login() {
		if(Validate.isValidEmail(user.getEmail()))
			message.setError("Error: Email format is invalid.");
		
		if(Validate.isEmpty(user.getEmail()) || Validate.isEmpty(user.getPin()))
			message.setError("Error: Fill up the fields correctly.");
		
		for(User registedUser: registeredUsers)
			if(registedUser.getEmail().equals(user.getEmail()) && registedUser.getPin().equals(user.getPin())) {
				user = registedUser;
				isAuthorize = true;
				message.setSuccess("Success: You're now login, ID: " + user.getId());
			}
		if(!hasSuccessMsg() && !hasErrorMsgs())
			message.setError("Error: Wrong Credentials");
	}
	
	public void changePin(String oldPin, String newPin) {
		if(oldPin.isEmpty() || newPin.isEmpty())
			message.setError("Error: Field/s required");
		else if(oldPin.matches(String.format("\\d{%s}", Validate.MAX_PIN)) || newPin.matches(String.format("\\d{%s}", Validate.MAX_PIN)))
			message.setError("Error: Please put " + Validate.MAX_PIN + " digits only");
		else if (newPin.equals(user.getPin()))
			message.setError("Error: New PIN must be different from the old PIN");
		 else if (!isAuthenticated() && !oldPin.equals(user.getPin()))
			message.setError("Error: Incorrect pin");
		 else {
			user.setPin(newPin);
			message.setSuccess("Success: Pin changed successfully");
		}
	}
	
	public void logout() {
		user = null;
		isAuthorize = false;
	}
	
	public boolean isAuthenticated() {
		return isAuthorize;
	}
	
	public String flashErrors() {
		return message.flashErrors();
	}
	
	public String flashSuccess() {
		return message.flashSuccess();
	}
	
	public boolean hasSuccessMsg() {
		return message.hasSuccessMsg();
	}
	
	public boolean hasErrorMsgs() {
		return message.hasErrorMsgs();
	}
	
	public void unsetMessages() {
		message.unsetMessages();
	}
}