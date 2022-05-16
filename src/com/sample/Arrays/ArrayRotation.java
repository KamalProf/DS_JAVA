package com.sample.Arrays;

//https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/?ref=lbp
public class ArrayRotation {
	/* Function to reverse arr[] from start to end
			1) Initialize start and end indexes as start = 0, end = n-1 
			2) Swap arr[start] with arr[end] 
			3) Recursively call reverse for rest of the array.
	*/		
	static void reverseArray(int[] arr,int start,int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = arr[temp];
		reverseArray(arr,start+1,end-1);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayRotation obj = new ArrayRotation();
		int arr[] = new int[] {1,2,3,4,5,6};
		for (int i=arr.length-1; i>=0 ; i--) {
			System.out.print(arr[i]);
		}
		reverseArray(arr, 0, 5);
	       for (int i=1; i < arr.length; i++)
	            System.out.print(arr[i] + " ");
	}
}
