package com.sample.ProblemSolving;

public class MajorityElementInArray {

	//1. Brute-Force Solution
	//A naive solution is to count each element’s frequency in the first half of the array to check if it is the majority element.
	//Following is the naive implementation:
	static int getMajorityElement_BruteForce(int[] arr,int n) {
		int majorityCount = 0;
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(arr[i] == arr[j]) {
					majorityCount+=1;
				}
				if(majorityCount > n/2) {
					return (arr[i]);
				}
			}
		}
		
		return 0;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []majorArr = new int[] {1,2,3,1,3,3};		
		int majorElement = getMajorityElement_BruteForce(majorArr,6);
		System.out.println(majorElement);
	}

}
