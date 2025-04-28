package new_programming_challenge.three_inputs_largest_number;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

            System.out.println();
            System.out.print("Type 1st number: ");
            int firstNum = scanner.nextInt();

            System.out.println();
            System.out.print("Type 2nd number: ");
            int secondNum = scanner.nextInt();

            System.out.println();
            System.out.print("Type 3rd number: ");
            int thirdNum = scanner.nextInt();
            
            int[] numbers = {firstNum, secondNum, thirdNum};

            int max = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                if(numbers[i] > max)
                    max = numbers[i];
            }

            System.out.println();
            System.out.println("Max number is " + max);
    }
}
