package com.activities;

import java.util.Scanner;

public class StringPalindrome {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input your string: ");
        String input = scanner.nextLine();

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
