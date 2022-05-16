package com.sample.SORT;

/*
	https://www.geeksforgeeks.org/merge-sort/?ref=leftbar-rightbar
*/

public class MERGE_Sort {
	
	void sort(int arr[], int beg, int end)  
	{
		if (beg < end) {
			// Find the middle point
			int mid = (beg + end) / 2;
			// Sort first and second halves
			sort(arr, beg, mid);
			sort(arr, mid + 1, end);
			// Merge the sorted halves
			merge(arr, beg, mid, end);
		}
	}  	
	
	void merge(int arr[], int beg, int mid, int end)    
	{
		// Find sizes of two subarrays to be merged
		int n1 = mid - beg + 1;
		int n2 = end - mid;

		/* Create temporary Arrays */
		int LeftArray[] = new int[n1];
		int RightArray[] = new int[n2];

		/* copy data to temp arrays */
		for (int i = 0; i < n1; i++)
			LeftArray[i] = arr[beg + i];

		for (int j = 0; j < n2; j++)
			RightArray[j] = arr[mid + 1 + j];

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subArray array
		int k = beg;

		while (i < n1 && j < n2) {
			if (LeftArray[i] <= RightArray[j]) {
				arr[k] = LeftArray[i];
				i++;
			} else {
				arr[k] = RightArray[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of LeftArray[] if any */
		while (i < n1) {
			arr[k] = LeftArray[i];
			i++;
			k++;
		}
		/* Copy remaining elements of RightArray[] if any */
		while (j < n2) {
			arr[k] = RightArray[j];
			j++;
			k++;
		}
	}    	
	
	/* A utility function to print array of size n */
    static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MERGE_Sort ob = new MERGE_Sort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}


/*
Merge Sort is a Divide and Conquer algorithm. 
It divides the input array into two halves, calls itself for the two halves, 
and then merges the two sorted halves. The merge() function is used for merging two halves. 
The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted 
and merges the two sorted sub-arrays into one.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = l+ (r-l)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
*/	
