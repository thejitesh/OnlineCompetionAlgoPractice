package com.example.jiteshvartak.onlinetestalgorithmspractice;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class RegExEmail {

	
    static String isValid(String email) {
      
    	email ="harry@hogwarts.com";
    	Pattern pattern = Pattern.compile("^[a-z]{5}@hogwarts.com$			");
    	Matcher matcher = pattern.matcher(email);
    	if (matcher.find())
    	{
    	    return "YES";
    	}
    	
    	return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String s = in.next();
        String result = isValid("");
        System.out.println(result);
        in.close();
    }
    
    static int cal(String a , String b){
        int ans = 0;
        for(int d=1;d<=9;d++){
            
            if(a.contains(""+d)  && b.contains(""+d)){
                ans = ans*10 + d;
            }
        }
        return ans;
    }
   
    static boolean isCap(char c){
        return (c >= 65 && c<=90);
    }
    
    
    static void println(String str){
        System.out.println(str);
    }
    
    static void print(String str){
        System.out.print(str);
    }
}
