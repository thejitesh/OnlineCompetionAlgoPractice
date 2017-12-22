package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class BoundsComparision {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		Arrays.sort(arr);

		int start = 0;
		int end = 0;
		int count = 0;

		if (arr[0] == 0) {
			start = arr[0];
			end = start + 4;
			count++;
		}

		for (int i = 0; i < n; i++) {

			if (arr[i] > end) {
				start = arr[i];
				end = start + 4;
				count++;
			}

		}

		print(count + "");
		scanner.close();
	}

	static void print(String str) {
		System.out.println(str);
	}

}