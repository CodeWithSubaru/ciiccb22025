package chapter3;

public class Student {
    String fullName;
    String course;
    int age;
    
    public Student(String fullName, String course, int age) {
        this.fullName = fullName;
        this.course = course;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{ Fullname = " + this.fullName + ", " + "Course = " + this.course + ", " + "Age = " + this.age + " }"; 
    }
}
