package activities;

public class Task113 {
    int num1;
    public static void main(String[] args) {
        int check_number = 10;
        String message;
        
        for(int i = 1; i <= check_number; i++) {
             message = (i % 2 == 0) ? i + " is even number" : i + " is odd number";

            System.out.println(message);
        }
    }
}
