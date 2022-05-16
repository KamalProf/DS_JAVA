package com.sample.Arrays;

/*
	Input arr = 1,4,0,3,2
	Output arr = 
	arr[0] is 1 => arr[1] is 0
	arr[1] is 4 => arr[4] is 1
*/
public class ArrayRearrange {
	
	public void arrayRearrange(int[] arr,int n) {
		int temp[] = new int[] {};
		for (int i=0; i<n; i++) {
			temp[arr[i]] = i;
		}
		//move all elements from temp array back into final array
		for (int i=0; i<n; i++) {
			arr[i] = temp[i];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
