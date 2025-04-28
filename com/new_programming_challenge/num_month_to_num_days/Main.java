package new_programming_challenge.num_month_to_num_days;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Type your number of month [1-12]: ");
        byte month = scanner.nextByte();

        byte days;
        
        switch(month) {
            case 2:
                days = 28;
                break;
            case 1, 3, 5, 7, 9, 11:
                days = 31;
                break;
            default:
                days = 30;
        }

        System.out.println(month + " = " + days);

    }
}
