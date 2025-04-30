package new_programming_challenge.odd_or_even_positive_negative_or_zero;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            byte input = scanner.nextByte();

            String isEvenOrOdd = input % 2 == 0 ? "Even" : "Odd";

            String result = "Zero"; 
            if(input > 0) {
                result = "Positive";
            } else if(input < 0) {
                result = "Negative";
            }

            System.out.println("Even or Odd: " + isEvenOrOdd);
            System.out.println("Positive, Negative or Zero: " + result);
    }
}