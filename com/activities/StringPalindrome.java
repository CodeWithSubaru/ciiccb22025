package com.activities;

import java.util.Scanner;

public class StringPalindrome {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input your string: ");
        String input = scanner.nextLine();

        // last implementation
        // StringBuilder stringInput = new StringBuilder(input);

        // StringBuilder reverseWord = new StringBuilder("");

        // Wrong Implementation, you should use reverse method
        
        // for(int i = stringInput.length() - 1; i >= 0; i--)
        //     reverseWord.append(stringInput.charAt(i));

        // System.out.println(stringInput.toString().equals(reverseWord.toString()) ? "Input is a palindrome" : "Input is not a palindrome");

        System.out.println(
                new StringBuilder(input)
                .toString()
                .equals(new StringBuilder("")
                .reverse()
                .toString()
            )
            ? "Input is a palindrome" 
            : "Input is not a palindrome"
        );
    }
}
