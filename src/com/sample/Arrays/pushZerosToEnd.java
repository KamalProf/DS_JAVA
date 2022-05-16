package com.sample.Arrays;

public class pushZerosToEnd {
	
	public static int[] pushZeros(int arr[]) {
		int count = 0;
		for(int i=0;i<arr.length;i++) 
			if (arr[i] != 0) 
				arr[count++] = arr[i];			
		
		while (count < arr.length)
			arr[count++] = 0;
		
		return arr;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        int finalArr[] = pushZeros(arr);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");		

	}

}
