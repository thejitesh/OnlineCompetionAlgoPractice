package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.lang.reflect.Array;
import java.util.*;

class EarthPrimeFactor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int q = in.nextInt();

		int A[] = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}

		for (int j = 0; j < q; j++) {
			int x = Integer.parseInt(in.next().trim());
			final int tmpX = x;
			String msg = "NO";

			if (x == 0 ) {
				println(msg);
				continue;
			}
			else if(x == 1){
			    println(msg);
				continue;
			}

			for (int i = 0; i < n; i++) {
				if (A[i] == 1) {
					if (check(tmpX)) {
						msg = "YES";
						break;
					} else {
						msg = "NO";
					}
				} else if (A[i] == 0 || x % A[i] != 0 || A[i] > x) {
					msg = "NO";
					continue;
				} else {

					int div = x;
					while (true && A[i] != 1 && x != 0) {// divide infinitely
						div = x / A[i];
						x = div;
						if (x % A[i] != 0 || div == A[i]) {
							break;
						}
					}

					if (div == 1) {
						if (check(tmpX)) {
							msg = "YES";
							break;
						} else {
							msg = "NO";
						}
					} else if (x == 0) {
						msg = "NO";
					} else if (isPrime(div) && isPrime(A[i])) {
						msg = "YES";
						break;
					} else {

						if (check(div)) {
							msg = "YES";
							break;
						} else {
							msg = "NO";
						}
					}

				}

			}
			println(msg);

		}

	}

	static HashMap<String, Boolean> hm = new HashMap<>();

	static boolean isPrime(int n) {

		Boolean bol = hm.get(n + "");
		if (bol != null) {
			return bol.booleanValue();
		}
		if (n == 1 || n == 2 || n == 5 || n == 7) {
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

	static boolean check(int div) {
		boolean isEven = div % 2 == 0;
		int startIndex = isEven ? 2 : 3;
		int endIndex = div / 2;
		int increment = 2;
		for (int k = startIndex; k <= endIndex; k += increment) {

			if (div % k == 0) {
				int k2 = div / k;
				if (isPrime(k) && isPrime(k2)) {
					// msg = "YES";
					return true;
				} else {
					if (check(k2)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
