package com.activities;

import java.util.Scanner;

public class StringPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your string: ");
        String input = scanner.nextLine();

        StringBuilder stringInput = new StringBuilder(input);

        StringBuilder reverseWord = new StringBuilder("");

        for(int i = stringInput.length() - 1; i >= 0; i--)
            reverseWord.append(stringInput.charAt(i));

        System.out.println(stringInput.toString().equals(reverseWord.toString()) ? "Input is a palindrome" : "Input is not a palindrome");
    }
}
