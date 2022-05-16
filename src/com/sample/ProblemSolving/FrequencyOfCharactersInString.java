package com.sample.ProblemSolving;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfCharactersInString {
	
	static void frequencyOfCharacters(String str) {
		Map<Character,Integer> m = new HashMap<Character, Integer>();
		for (int i=0;i<str.length();i++) {
			if (m.containsKey(str.charAt(i))){ // if char is present, increment the counter
				m.put(str.charAt(i),m.get(str.charAt(i))+1);
			}else {
				m.put(str.charAt(i),1);
			}
		}
		//Print the numbers
		for(int i = 0; i < str.length(); i++)
        {          
            // Print only if this character is not printed before
            if(m.get(str.charAt(i)) != 0)
            {
                System.out.print(str.charAt(i));
                System.out.print(m.get(str.charAt(i)) + " ");
                m.put(str.charAt(i), 0);
            }            
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       String S = "geeksforgeeks";
	       frequencyOfCharacters(S);
	}

}
