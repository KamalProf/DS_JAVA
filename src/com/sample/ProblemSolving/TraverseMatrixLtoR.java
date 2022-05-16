package com.sample.ProblemSolving;

public class TraverseMatrixLtoR {
	//Recursive function
	public static int concurrentPaths(int row, int col) {
		if (row == 1 || col == 1)
			return 1;
		int totalPath = concurrentPaths(row, col - 1) + concurrentPaths(row - 1, col);
		return totalPath;
	}

	public static void main(String[] args) {
		int n = 5, m = 5;
		System.out.println(concurrentPaths(n, m));
	}
}

/*
//https://www.geeksforgeeks.org/count-the-number-of-ways-to-traverse-a-matrix/
Count the number of ways to traverse a Matrix
Given a two-dimensional matrix, in how way can someone traverse it from top-left to bottom-right? 
Condition- At any particular cell the possible moves are either down or right, no other steps possible.
Stop when the end is reached.
Ans :
we will find that the number of ways a cell can be reached is = Number of ways 
it can reach the cell above it + number of ways it can reach the cell which is left of it. 

*/
