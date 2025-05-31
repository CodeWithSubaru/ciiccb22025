package activities;

public class Task122 {
	public static void main(String[] args) {
		DateTask date1 = new DateTask(1,1,1978);
		DateTask date2 = new DateTask(9,21,1984);
		System.out.println(date1.toString());
		System.out.println(date2.toString());
		
		// display leapYears
		DateTask.leapYears();
	}
}

class DateTask {
	// instance variables
	private byte day;
	private byte month;
	private short year;
	
	// Constructors:
	
	// The no-args constructor
	public DateTask() {
		this(1,1,1);
	}
	
	// Constructor that takes 3 arguments
	public DateTask(int m, int d, int y) {
		setDate(m, d, y);
	}
	
	// Methods
	@Override
	public String toString() {
		return month + "/" + day +   "/" + year;
	}
	
	public void setDate(int m, int d, int y) {
		if (valid(d, m, y)) {
			day = (byte) d;
			year = (short) y;
			month = (byte) m;
		}
		else{
			day = (byte) 0;
			year = (short) 0;
			month = (byte) 0;
		}
	}
	public static void leapYears() {
		for (int i = 1980; i <= 2023; i = i + 4) {
			if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0))
				System.out.println("The year " + i + " is a leap year");
		}
	}
	
	public int getDay() {
		return day;
	}
	
	public int setDay(int day) {
		if (valid(day, month, year)) {
			this.day = (byte) day;
		}
		return 0;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int setMonth(int month) {
		if (valid(day, month, year)) {
			this.month = (byte) month;
		}
		
		return 0;
	}
	
	public int getYear() {
		return year;
	}
	
	public int setYear(int year) {
		if (valid(day, month, year)) {
			this.year = (short) year;
		}
		return 0;
	}
	
	private boolean valid(int day, int month, int year) {
		if (day > 31 || day < 1 || month > 12 || month < 1 || year < 1)  {
			System.out.println("Attempting to create a non-valid date " +month + "/" + day + "/" + year);
			return false;
		}
		switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				return (day <= 30);
			case 2:
				return day <= 28 || (day == 29 && year % 4 == 0);
		}
		return true;
	}
}