package com.sample.SORT;

import java.util.Arrays;

//	https://www.geeksforgeeks.org/quick-sort/?ref=leftbar-rightbar
public class QUICK_Sort {
	
	static int partition(int[] arr, int low, int high) {
		// pivot (Element to be placed at right position)
		int pivot = arr[high];
		int i = low-1;
		// traverse through all elements compare each element with pivot
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				// if element smaller than pivot is found swap it with the greater element
				// pointed by i
				i++;
				// swapping element at i with element at j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swap the pivot element with the greater element specified by i
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		// return the position from where partition is done
		return i;
	}
	
	static void quickSort(int[] arr,int low,int high) {
		if (low < high) {
			//pivot is partitioning index, arr[p] is now at right place 
			int pivot = partition(arr,low,high);
			// recursive call on the left of pivot
			quickSort(arr,low,pivot);
			// recursive call on the right of pivot
			quickSort(arr,pivot+1,high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int length = arr.length;
		quickSort(arr,0,length-1);
		System.out.println("Sorted Array in Ascending Order ");
	    System.out.println(Arrays.toString(arr));
	}
}


/*
 quickSort Algorithm :
 Target of partitions is, 
 given an array and an element x of array as pivot, put x at its correct position in sorted array 
 and put all smaller elements (smaller than x) before x, 
 and put all greater elements (greater than x) after x

Partition Algorithm : 
The logic is simple, we start from the leftmost element and keep track of index of smaller (or equal to) elements as i.
 While traversing, if we find a smaller element, we swap current element with arr[i]. Otherwise we ignore current element. 
low  --> Starting index,  high  --> Ending index 

quickSort(arr[], low, high)
{
    if (low < high)
    {
       // pi is partitioning index, arr[pi] is now
       //    at right place 
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}
*/