package com.sample.GRAPH;

/*
Heap sort : Heap sort is an in-place algorithm. 
Creates a binary heap out of a list of data then removes the first element in the list and 
appends it to a final list. It repeats this until the heap is empty.

Time : O(nlogn)
Space : O(1) (if done iteratively)
*/

// Max-Heap data structure in Java

import java.util.ArrayList;

class Heap {
	//n = arr.length;
	//i = current index position
	static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root; 
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;
 
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
 
    // Function to delete the root from Heap
    static int deleteRoot(int arr[], int n)
    {
        // Get the last element
        int lastElement = arr[n - 1];
 
        // Replace root with first element
        arr[0] = lastElement;
 
        // Decrease size of heap by 1
        n = n - 1;
 
        // heapify the root node
        heapify(arr, n, 0);
 
        // return new size of Heap
        return n;
    }
    
 // Function to insert a new node to the Heap
    void insertNode(int arr[], int n, int Node)
    {
        // Increase the size of Heap by 1
        n = n + 1;
     
        // Insert the element at end of Heap
        arr[n - 1] = Node;
     
        // Heapify the new node following a
        // Bottom-up approach
        heapify(arr, n, n - 1);
    }

    /* A utility function to print array of size N */
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }

  public static void main(String args[]) {
	  int arr[] = { 10, 5, 3, 2, 4 };
	  
      int n = arr.length;

      n = deleteRoot(arr, n);

      printArray(arr, n);
  }
}

