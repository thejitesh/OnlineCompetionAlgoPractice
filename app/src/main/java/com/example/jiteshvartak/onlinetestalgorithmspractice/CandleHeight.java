package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class CandleHeight {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int height[] = new int[n];
		HashMap<Integer, Integer> hmOccurance = new HashMap<>();
		for (int height_i = 0; height_i < n; height_i++) {
			height[height_i] = in.nextInt();

			Integer occurance = hmOccurance.get(height[height_i]);
			if (occurance == null) {
				hmOccurance.put(height[height_i], 1);
			} else {
				hmOccurance.put(height[height_i], occurance.intValue() + 1);
			}

		}
		in.close();

		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
			}
		}
		
		System.out.println(hmOccurance.get(maxHeight));

	}


}
