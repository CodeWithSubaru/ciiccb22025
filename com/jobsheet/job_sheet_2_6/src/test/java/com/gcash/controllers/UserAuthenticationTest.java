package com.gcash.controllers;

import com.gcash.controllers.mockdata.UserAuthMockData;
import com.gcash.model.User;
import com.gcash.util.DB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthenticationTest {
	
	@Test
	public void itShouldLoginUser() {
		String EMAIL = "raffy@gmail.com";
		String PIN ="1234";
		
		User user = new User(EMAIL, PIN);
		UserAuthentication auth = new UserAuthentication(user);
		auth.login();
		assertTrue(auth.isAuthenticated(), "User should be logging in successfully");
	}
	
	@Test
	public void itShouldInvalidLoginUser() {
		String EMAIL = "raffy1@gmail.com";
		String PIN ="1234";
		
		User user = new User(EMAIL, PIN);
		UserAuthentication auth = new UserAuthentication(user);
		auth.login();
		assertFalse(auth.isAuthenticated(), "User should be login failed");
	}
}
