package com.sample.ProblemSolving;

public class Fibonacci {

	
	public static int totalsum (int n){
		int inputf[] = new int[n+1];
		inputf[0] = 0;
		inputf[1] = 1;
		int sum = inputf[0]+inputf[1];
		for (int i=2 ; i<=n; i++){
			inputf[i] = inputf[i-1]+inputf[i-2];
			sum = sum + inputf[i];
			System.out.println("My Series:="+inputf[i]);
		}
		System.out.println(n);
		return sum;
	}
	
	public static void main (String args[]) {
		int n =10;
		System.out.println(totalsum(n));
	}
}
