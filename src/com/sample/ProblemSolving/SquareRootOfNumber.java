package com.sample.ProblemSolving;

// https://www.geeksforgeeks.org/square-root-of-an-integer/
public class SquareRootOfNumber {
	
	static int sqr_root (int n) {
		// Base Cases
        if (n == 0 || n == 1)
            return n;
        
		long start=1, end=n, result=0;
		while(start < end) {
			int mid = (int) ((start+end)/2);
			if (mid*mid < n) {
				start = mid + 1;
				result = mid;
			}else {
				result = mid -1;
			}
		}
		return (int) result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqr_root(11));
	}

}

/*
Better Approach: The idea is to find the largest integer i whose square is less than or equal to the given number. The idea is to use Binary Search to solve the problem. The values of i * i is monotonically increasing, so the problem can be solved using binary search. 
Algorithm: 
Take care of some base cases, i.e when the given number is 0 or 1.
Create some variables, lowerbound l = 0, upperbound r = n, where n is the given number, mid and ans to store the answer.
Run a loop until l <= r , the search space vanishes
Check if the square of mid (mid = (l + r)/2 ) is less than or equal to n, If yes then search for a larger value in second half of search space, i.e l = mid + 1, update ans = mid
Else if the square of mid is more than n then search for a smaller value in first half of search space, i.e r = mid – 1
Print the value of answer ( ans)
*/
