package com.sample.ProblemSolving;

public class Consecutive1sInBinary {
	
	public static int count(int number) {
		int count=0;
		while (number >0) {
			number = number & (number >>> 1);
			count ++;		
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(222));
	}
}
