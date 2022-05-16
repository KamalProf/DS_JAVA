package com.sample.SEARCH;

//Java implementation of recursive Binary Search
class BinarySearch {
 // Returns index of x if it is present in arr[l..r], else return -1
 int binarySearch(int arr[], int start, int end, int element)
 {
     if (end >= start) {
         int mid = start + (end - start) / 2;

         // If the element is present at the middle itself
         if (arr[mid] == element)
             return mid;

         // If element is smaller than mid, then it can only be present in left subarray
         if (arr[mid] > element)
             return binarySearch(arr, start, mid - 1, element);
         else  // Else the element can only be present in right subarray        	
        	 return binarySearch(arr, mid + 1, end, element);
     }
     // We reach here when element is not present in array
     return -1;
 }

 // Driver method to test above
 public static void main(String args[])
 {
     BinarySearch ob = new BinarySearch();
     int arr[] = { 2, 3, 4, 10, 40, 59 };
     int findElement = 10;
     int result = ob.binarySearch(arr, 0, arr.length - 1, findElement);
     if (result == -1)
         System.out.println("Element not present");
     else
         System.out.println("Element found at index: "+ result);
 }
}
