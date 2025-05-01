package new_programming_challenge.odd_or_even_positive_negative_or_zero_2;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            System.out.print("Enter your number: ");
            byte input = scanner.nextByte();

            String result = 
                (input == 0 ? "Zero ": "") + 
                (input % 2 == 0 ? "Even " : "Odd ") + 
                (input < 0 ? "Negative" : "Positive");

            System.out.println(input + " is " + result + " number");
            scanner.close();
    }
}