package new_programming_challenge.score_to_grade_F_A;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.print("Type your score: ");
        byte score = scanner.nextByte();
        
        char grade;
        
        if(score > 89) 
            grade = 'A';

        else if (score > 79)
            grade = 'B';

        else if(score > 69)
            grade = 'C';

        else if(score > 59)
            grade = 'D';

        else
            grade = 'F';
        
        System.out.println("Your grade is " + grade);
    }
}
