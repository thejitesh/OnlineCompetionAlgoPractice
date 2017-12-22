package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class funnyNotFunny {

	private static final char END_DUMMY = 'a';


	public static void main(String[] args) {

		
		
		
        Scanner scanner = new Scanner(System.in);
        int noOfInputs = scanner.nextInt();
        for(int i = 0;i<noOfInputs;i++){
            String inputString = scanner.next();
            String reverseString = new StringBuffer(inputString).reverse().toString();
            boolean isFunny = true;
            for(int j=1;j<inputString.length();j++){
                if(Math.abs(inputString.charAt(j) - inputString.charAt(j-1)) != 
                		Math.abs(reverseString.charAt(j) - reverseString.charAt(j-1))){
                    isFunny = false;
                }
            }
            
            if(isFunny){
                System.out.println("Funny");
            }else{
                 System.out.println("Not Funny");
            }
        }
        scanner.close();
		
	}

	static  class Test {


		 {
			 System.out.println("");
		 }
		 
		 static{
			 System.out.println("");
		 }

		
	}

	static  class Test2 extends Test {
		
		
		
		Test2(int i){
			 System.out.println("");
		}

	}
}
