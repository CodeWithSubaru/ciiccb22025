package new_programming_challenge.three_inputs_largest_number;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

            System.out.println();
            System.out.print("Type 1st number: ");
            byte firstNum = scanner.nextByte();

            System.out.println();
            System.out.print("Type 2nd number: ");
            byte secondNum = scanner.nextByte();

            System.out.println();
            System.out.print("Type 3rd number: ");
            byte thirdNum = scanner.nextByte();
            
            byte[] numbers = {firstNum, secondNum, thirdNum};

            byte max = numbers[0];

            for (byte i = 1; i < numbers.length; i++) {
                if(numbers[i] > max)
                    max = numbers[i];
            }

            System.out.println();
            System.out.println("Max number is " + max);
    }
}
