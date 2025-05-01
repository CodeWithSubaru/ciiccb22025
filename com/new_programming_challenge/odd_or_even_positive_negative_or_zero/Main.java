package new_programming_challenge.odd_or_even_positive_negative_or_zero;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            System.out.print("Enter your numbers to add w/ comma separated (1,2,4): ");
            String inputs = scanner.nextLine();

            int total = 0;

            String[] integers = inputs.split(",");

            for(String i : integers)
                total += Integer.parseInt(i);

            System.out.println(total);
    }
}