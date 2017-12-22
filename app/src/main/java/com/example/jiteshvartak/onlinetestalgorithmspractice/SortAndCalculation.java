package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class SortAndCalculation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] calories = new int[n];
		for (int calories_i = 0; calories_i < n; calories_i++) {
			calories[calories_i] = in.nextInt();
		}
		Arrays.sort(calories);
		int noOfcakeEaten = 0;
		long totalMilesRun = 0;
		for (int i = calories.length - 1; i >= 0; i--) {

			totalMilesRun += Math.pow(2, noOfcakeEaten) * calories[i];
			noOfcakeEaten++;
		}

		System.out.println(totalMilesRun);

		in.close();
	}

}