package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.Scanner;

class XOROnRangeArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Object instance = null;

		Object lock = new Object();

		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new Object();
				}
			}
		}

		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int queries = in.nextInt();
			int[] X = new int[n];
			for (int X_i = 0; X_i < n; X_i++) {
				X[X_i] = in.nextInt();
			}

			for (int i = 0; i < queries; i++) {

				int a = in.nextInt();
				int p = in.nextInt();
				int q = in.nextInt();

				int max = 0;
				for (int j = p - 1; j < q; j++) {
					int xOr = X[j] ^ a;
					max = xOr > max ? xOr : max;
				}

				println("" + max);
			}

		}
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
