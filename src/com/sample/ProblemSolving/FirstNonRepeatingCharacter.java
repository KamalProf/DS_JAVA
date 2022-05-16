package com.sample.ProblemSolving;

import java.util.Scanner;

//Program to find the first non-repeating character in a string is discussed here. 
//Given a string, the task is to find the first non-repeating character in the string.
/*
Input the string from the user.
Start traversing the string using two loops.
Use the first loop to scan the characters of the string one by one.
Use the second loop to find if the current character is occurring in the latter part if the string or not.
If it is not occurring, print that character.
Else, continue traversing.
*/
public class FirstNonRepeatingCharacter {
	static final int NO_OF_CHARS = 256;
	static char count[] = new char[NO_OF_CHARS];
	
	static void get_char_count(String str) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}

	static int first_non_repeating_character(String str) {
		get_char_count(str);
		int index = -1, i;
		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		String str = "traveltime";
		int index = first_non_repeating_character(str);
		System.out.println(index == -1 ? 
				"All the characters are repetitive " + "is empty" : 
					"First non-repeating character is " + str.charAt(index));

	}
}
