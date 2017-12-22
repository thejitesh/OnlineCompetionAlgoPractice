package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

public class Transmitter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int range = in.nextInt();
		int[] x = new int[n];

		int min = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			if (i == 0) {
				min = x[i];
				max = x[i];
			}
			if (x[i] < min) {
				min = x[i];
			}
			if (x[i] > max) {
				max = x[i];
			}
		}

		int maxTransmitters = 0;
		if (min == max) {
			maxTransmitters = 0;
		}

		for (int i = min; i <= max;) {
			i = i + (range * 2) + 1;
			maxTransmitters++;
		}

		System.out.println(maxTransmitters);

	}


}
