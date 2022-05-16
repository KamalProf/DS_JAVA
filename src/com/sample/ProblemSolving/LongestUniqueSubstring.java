package com.sample.ProblemSolving;

import java.util.HashSet;

// https://www.youtube.com/watch?v=3IETreEybaA
// https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
public class LongestUniqueSubstring { // Sliding Window Problem

	static int longestUniqueSubstring(String s) {
		int max = 0; // result max length of longest subsctring
		int i_pointer = 0;
		int j_pointer = 0;
		HashSet<Character> hash_set = new HashSet();
		
		while (j_pointer < s.length()) {
			if (!hash_set.contains(s.charAt(j_pointer))) {
				hash_set.add(s.charAt(j_pointer));
				j_pointer++;
				max = Math.max(hash_set.size(), max);
			} else {
				hash_set.remove(s.charAt(i_pointer));
				i_pointer++;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println("longestUniqueSubstring Is:"+longestUniqueSubstring("abcabcbb"));
		System.out.println("longestBBBBB Is:"+longestUniqueSubstring("bbbbbb"));
		System.out.println("longestCCCC Is:"+longestUniqueSubstring("pwwkew"));
	}

}


/*
 When we traverse the string, to know the length of current window we need two indexes. 
1) Ending index ( j ) : We consider current index as ending index. 
2) Starting index ( i ) : It is same as previous window if current character was not present in the previous window. 
To check if the current character was present in the previous window or not, 
we store last index of every character in an array lasIndex[]. 
If lastIndex[str[j]] + 1 is more than previous start, then we updated the start index i.
Else we keep same i.  
*/