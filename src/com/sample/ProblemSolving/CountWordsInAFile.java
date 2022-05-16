package com.sample.ProblemSolving;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CountWordsInAFile {
	
	 public static int countFilesInDirectory(File directory) {
	      int count = 0;
	      for (File file : directory.listFiles()) {
	          if (file.isFile()) {
	              count++;
	          }
	          if (file.isDirectory()) {
	              count += countFilesInDirectory(file);
	          }
	      }
	      return count;
	  }	
	 
	 public static void countRepeatingWords() {
		 Map<String,Integer> myMap = new HashMap<>();
		 for (String key: wordArray) {
			 if (myMap.containsKey(key)) {
				 int count = myMap.get(key);
				 myMap.put(key, count+1);
			 }
			 myMap.put(key, 1);
		 }		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
