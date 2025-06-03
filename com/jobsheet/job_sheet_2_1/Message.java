package jobsheet.job_sheet_2_1;

import java.util.ArrayList;
import java.util.List;


public class Message {
	private List<String> errors = new ArrayList<>();
	private String success;
	
	public String flashErrors() {
		return String.join("\n", errors);
	}
	
	public void setError(String error) {
		errors.add(error);
	}
	
	public boolean hasErrorMsgs() {
		return !errors.isEmpty();
	}
	
	public boolean hasSuccessMsg() {
		return success != null && !success.isEmpty();
	}
	
	public String flashSuccess() {
		return success;
	}
	
	public void setSuccess(String success) {
		this.success = success;
	}
	
	public void unsetMessages() {
			if(!errors.isEmpty())
				errors = new ArrayList<>();
	}
}
