package com.gcash.model;

public class User {
	private static Integer counter = 1;
	private Integer id;
	private String name;
	private final String email;
	private String number;
	private String pin;
	
	public User(String name, String email, String number, String pin) {
		this.id = counter++;
		this.name = name.trim();
		this.email = email.trim();
		this.number = number.trim();
		this.pin = pin.trim();
	}
	
	public User(String email, String pin) {
		this.email = email.trim();
		this.pin = pin.trim();
	}
	
	public User(Integer id, String name, String email, String number, String pin) {
		this(name, email, number, pin);
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getPin() {
		return pin;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return "User{" +
				       "email='" + email + '\'' +
				       ", id=" + id +
				       ", name='" + name + '\'' +
				       ", number='" + number + '\'' +
				       ", pin='" + pin + '\'' +
				       '}';
	}
}