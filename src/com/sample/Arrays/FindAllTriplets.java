package com.sample.Arrays;

// https://www.techiedelight.com/find-triplet-given-with-given-sum/
import java.util.Arrays;

public class FindAllTriplets {
	
	static void printAllTriplets(int []nums,int target) {			
		Arrays.sort(nums);// sort the array in ascending order	
		
		for (int i=0; i<nums.length-3; i++) {			
			int two_number_sum = target - nums[i]; // remaining sum
			// maintain two indices pointing to endpoints of the subarray nums[i+1…n)
			int low = i+1;
			System.out.println("low :"+low);
			int high = nums.length-1;
			System.out.println("high :"+high);
			
			while(low < high) {// loop if `low` is less than `high`
				if (low + high < two_number_sum) {// increment `low` index if the total is less than the remaining sum
					low ++;					
				}else if (low + high > two_number_sum) {// decrement `high` index if the total is more than the remaining sum
					high --;					
				}else if (low + high == two_number_sum) {// triplet with the given sum is found
					System.out.println(" "+nums[low]+" "+nums[high]+" "+nums[i]);
					low ++; // increment `low` index and decrement `high` index
					high --;
				}
			}
		}
	}

	public static void main(String[] args) {
		int []nums = {0,1,2,3,4,5};
		int target = 6;
		printAllTriplets(nums,target);
	}

}
