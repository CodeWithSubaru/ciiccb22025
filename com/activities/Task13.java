package activities;

public class Task13 {
	public static void main(String[] args) {
		new Car("Toyota", "Camry", 2022, 4).displayDetails();
	}
}

class Vehicle {
	protected String make;
	protected String model;
	protected int year;
	
	public Vehicle(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
}

class Car extends Vehicle {
	private final int numberOfDoors;
	
	public Car(String make, String model, int year, int numberOfDoors) {
		super(make, model, year);
		this.numberOfDoors = numberOfDoors;
	}
	
	public void displayDetails() {
		System.out.printf("\nCar Details:\nMake: %s\nModel: %s\nYear: %s\nNumber of Doors: %s%n", make, model, year, numberOfDoors);
	}
}