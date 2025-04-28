package new_programming_challenge.num_day_of_week;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {

            System.out.print("Type your number of day [1-7]: ");
            byte numDay = scanner.nextByte();
            
            String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            
            System.out.println(numDay + " = " + day[numDay - 1]);
        
        } catch(Exception e) {
            System.out.println("Invalid Input");
        }
    }
}
