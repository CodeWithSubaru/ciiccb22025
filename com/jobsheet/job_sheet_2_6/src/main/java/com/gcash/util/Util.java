package com.gcash.util;

import org.mindrot.jbcrypt.BCrypt;

public class Util {
	public static String titleCase(String words) {
		if(words == null || words.isEmpty()) return words;
		
		String[] arrWords = words.toLowerCase().split(" ");
		StringBuilder titleCase = new StringBuilder();
		
		for(String word: arrWords) {
			if(!word.isEmpty())
				titleCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
			
		
		}
		
		return titleCase.toString().trim();
	}
	
	public static String hash(String str) {
			return BCrypt.hashpw(str, BCrypt.gensalt());
	}
	
	public static boolean verify(String str, String compareStr) {
			return BCrypt.checkpw(str, compareStr);
	}
	
}
