package jobsheet.job_sheet_2_1;
import java.util.List;

public class Validate {

	public final static int MAX_PIN = 4;
	
	public static boolean isEmpty(String input) {
		return input.isEmpty();
	}
	
	public static boolean isValidEmail(String email) {
		return !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
	}
	
	public static boolean isUniqueEmail(String email, List<User> users) {
		for(User user: users)
			if(email.equals(user.getEmail()))
				return false;
		return true;
	}
}
