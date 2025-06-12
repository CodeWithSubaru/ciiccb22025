package com.gcash.controllers.mockdata;

import com.gcash.controllers.UserAuthentication;
import com.gcash.model.User;

public class UserAuthMockData {
	private static final String EMAIL = "raffy@gmail.com";
	private static final String PIN ="1234" ;
	
	public static UserAuthentication login() {
		User user = new User(EMAIL, PIN);
		UserAuthentication auth = new UserAuthentication(user);
		auth.login();
		return auth;
	}
}
