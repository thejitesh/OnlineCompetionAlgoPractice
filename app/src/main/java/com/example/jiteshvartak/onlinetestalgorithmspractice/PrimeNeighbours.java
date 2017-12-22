package com.example.jiteshvartak.onlinetestalgorithmspractice;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

class PrimeNeighbours {
	public static void main(String args[]) throws Exception {

		// Scanner
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int grid[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = s.nextInt();

			}
		}
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				int left = j == 0 ? 0 : grid[i][j - 1];
				int right = j == N - 1 ? 0 : grid[i][j + 1];
				int top = i == 0 ? 0 : grid[i - 1][j];
				int bottom = i == N - 1 ? 0 : grid[i + 1][j];

				if (isPrime(left + right + top + bottom)) {
					count++;
				}

			}
		}

		println(count + "");

	}

	static HashMap<String, Boolean> hm = new HashMap<>();

	static boolean isPrime(int n) {

		Boolean bol = hm.get(n + "");
		if (bol != null) {
			return bol.booleanValue();
		}
		if (n == 1 || n == 2 || n == 3 || n == 5 || n == 7) {
			hm.put(n + "", true);
			return true;
		}

		if (n % 2 == 0) {
			hm.put(n + "", false);
			return false;
		}

		int startIndex = 3;
		int endIndex = n / 2;
		int increment = 2;
		for (int k = startIndex; k < endIndex; k += increment) {
			if (n % k == 0) {
				hm.put(n + "", false);
				return false;
			}
		}

		hm.put(n + "", true);
		return true;

	}

	static boolean isCap(char c) {
		return (c >= 65 && c <= 90);
	}

	static void println(String str) {
		System.out.println(str);
	}

	static void print(String str) {
		System.out.print(str);
	}
}
