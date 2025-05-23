package activities;

public class Tasksheet122{
	public static void main(String[] args) {
		Student[] students = new Student[]{
				new Student("Morgan", "Freeman"),
				new Student("Brad", "Pitt"),
				new Student("Kevin", "Spacey")
		};
		
		for (Student s : students)
			s.printFullName();
}

static class Student {
	private final String firstName;
	private final String lastName;
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void printFullName () {
		System.out.println(firstName + " " + lastName);
	}
}
}
