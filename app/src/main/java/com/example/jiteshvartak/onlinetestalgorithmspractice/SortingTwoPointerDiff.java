package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.lang.reflect.Array;
import java.util.*;

class SortingTwoPointerDiff {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		Arrays.sort(a);
		int pairsCount = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				int diff = a[j] - a[i];
				if (diff == k) {
					pairsCount++;
				} else if (diff > k) {
					break;
				}
			}
		}

		println(pairsCount + "");
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
