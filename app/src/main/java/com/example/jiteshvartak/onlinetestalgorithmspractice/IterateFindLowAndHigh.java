package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IterateFindLowAndHigh {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int highestScore = 0, lowestScore = 0;

		int highestScoreCount = 0, lowestScoreCount = 0;

		for (int i = 0; i < n; i++) {

			if (i == 0) {
				highestScore = lowestScore = in.nextInt();
			} else {

				int score = in.nextInt();
				if (score > highestScore) {
					highestScoreCount++;
					highestScore = score;
				}
				if(score<lowestScore){
					lowestScore = score;
					lowestScoreCount++;
				}
			}

		}
		
		
		System.out.println(highestScoreCount+" "+lowestScoreCount);
		in.close();

		
	}

	static void print(String str) {
		System.out.println(str);
	}

}