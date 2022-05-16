package com.sample.ProblemSolving;

public class SortAStringInAlphabeticalOrder {
	
	public static void SortAString(String str) {
		//str = "faced";
		int j = 0;
		char temp = 0;
		char[] chars = str.toCharArray();
		
		for (int i = 0; i < chars.length; i++) {
			for (j = 0; j < chars.length; j++) {				
				if (chars[j] > chars[i]) {
					temp = chars[i];
					chars[i] = chars[j];
					chars[j] = temp;
				}
			}
		}
		System.out.println("The sorted string is : ");
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortAString("faced");

	}

}
