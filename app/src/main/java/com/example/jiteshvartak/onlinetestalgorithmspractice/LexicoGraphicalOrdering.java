package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;


public class LexicoGraphicalOrdering {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		System.out.println(A.length() + B.length());
		int compare = A.compareTo(B);  
		if (compare <= 0)  
		{  
			System.out.println("No");
		}  
		else   
		{  
	
			System.out.println("Yes");
		}
		
		System.out.println(capitalize(A) +" "+capitalize(B));

	}

	
	public static String capitalize(String text){
	    String c = (text != null)? text.trim() : "";
	    String[] words = c.split(" ");
	    String result = "";
	    for(String w : words){
	        result += (w.length() > 1? w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1, w.length()).toLowerCase(Locale.US) : w) + " ";
	    }
	    return result.trim();
	}
}
