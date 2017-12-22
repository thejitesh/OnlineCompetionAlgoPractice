package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ArrayRotation {

	private static final char END_DUMMY = 'a';

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int noOfInputs = in.nextInt();
		int noOfTransformations = in.nextInt();
		int noOfQueries = in.nextInt();

		int[] inputArray = new int[noOfInputs];

		for (int a_i = 0; a_i < noOfInputs; a_i++) {
			inputArray[a_i] = in.nextInt();
		}

		inputArray = performTransformation(inputArray, noOfTransformations);

		for (int a0 = 0; a0 < noOfQueries; a0++) {
			int m = in.nextInt();
			System.out.println(inputArray[m]);
		}

	}

	private static int[] performTransformation(int[] inputArray, int noOfTransformations) {

		int inputArrayLength = inputArray.length;
		int startIndex = noOfTransformations % inputArrayLength;

		int[] transformedArray = new int[inputArrayLength];
		for (int i = 0; i < inputArrayLength; i++) {
			transformedArray[startIndex] = inputArray[i];
			startIndex++;
			if (startIndex > inputArrayLength - 1) {
				startIndex = 0;
			}
		}
		return transformedArray;
	}
	
	
	
	
	 private final static int REWARD_POINTS = 10;
	    
	    static int getPoints(int month1, int month2, int month3){
	        return getPointsEarned(month1) + getPointsEarned(month2) + getPointsEarned(month3);
	    }
	    
	    static int getPointsEarned(int noOfSwipes){
	        int pointsEarned = REWARD_POINTS * noOfSwipes;
	            if(pointsEarned >100){
	            return 100;
	        }
	        return pointsEarned;
	    }

}
