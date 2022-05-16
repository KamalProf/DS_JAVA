package com.sample.SORT;

public class BUBBLE_Sort {
/*
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

Time Complexity: O(n^2)
The worst case time complexity of bubble sort is O(n^2) since we have to run two loops to implement it 
and in the worst case we would end up making nearly O(n^2) comparisons to get the final sorted array.
Space Complexity: O(1)
Bubble sort does not use any extra space to sort the given array, it sorts the given array in place.

Bubblesort:
For each element A in the array
----For each element B in the array
--------If the smaller element of A and B isn't on the left, swap the two
----If there haven't been any swaps done on this run, we're done.
 */
	void bubbleSort(int arr[])
	{
		// No. of elements in the array
		int n = arr.length;
		// This loop controls the "passes" on the array
		for (int i = 0; i < n - 1; i++)
			// Loop goes till second last unsorted element
			for (int j = 0; j < n - i - 1; j++)
				// Check if adjacent elements are in correct order
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}
 
    /* Prints the array */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method to test above
    public static void main(String args[])
    {
    	BUBBLE_Sort ob = new BUBBLE_Sort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}


/*
Key Points
Bubble sort works well for large arrays where the given data is mostly sorted 
since it takes just one pass on the array to determine if the array is already sorted. 
But if most elements in the array are not sorted and if it is a large array then it is not preferred 
to use bubble sort as it is not efficient, 
algorithms like quick sort would be a better choice in such cases. 
Bubble sort is only useful for very small and nearly sorted arrays.
*/
