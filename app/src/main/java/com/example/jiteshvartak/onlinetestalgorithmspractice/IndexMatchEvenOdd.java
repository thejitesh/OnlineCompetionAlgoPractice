package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.lang.reflect.Array;
import java.util.*;

class IndexMatchEvenOdd {

	static int minimumChocolateMoves(int n, int[] X) {

		int count = 0;
		int noOfOnes = 0;
		for (int i = 0; i < n; i++) {
			if (!isPerfectMatch(i, X[i])) {
				if (X[i] == 1) {
					noOfOnes++;
				}
				count++;
			}
		}
		if (count > 0) {

			if (noOfOnes == 0 || count / 2 == noOfOnes) {
				if (count % 2 == 0) {
					return count / 2;
				} else {
					return -1;
				}
			} else {

				int totalMove = 0;
				if (noOfOnes % 2 == 0) {
					totalMove = noOfOnes;
					if ((count - noOfOnes) % 2 == 0) {

						totalMove += (count - noOfOnes) / 2;
					} else {
						return -1;
					}

				} else {
					totalMove = noOfOnes - 1;
					if ((count - noOfOnes) % 2 != 0) {
						return (count/2);
					}else{
						return -1;
					}

				}
				return totalMove;
			}
		}
		return 0;
	}

	static boolean isPerfectMatch(int index, int number) {

		
		
		HashSet<String> str = new HashSet<>();
		str.add("");
		Iterator<String> ite = str.iterator();
		ite.hasNext();
		ite.next();
		
		ArrayList<String> arr = new ArrayList<>();
	
		Hashtable<String, String> dd =new Hashtable<>();

		Object d;
		
		
		boolean isEvenIndex = isEven(index);
		boolean isEvenNumber = isEven(number);
		if (isEvenIndex && isEvenNumber) {
			return true;
		} else if (!isEvenIndex && !isEvenNumber) {
			return true;
		}
		return false;
	}

	static boolean isEven(int i) {
		return i % 2 == 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Return the minimum number of chocolates that need to be moved, or -1
		// if it's impossible.
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int[] X = new int[n];
			for (int X_i = 0; X_i < n; X_i++) {
				X[X_i] = in.nextInt();
			}
			int result = minimumChocolateMoves(n, X);
			System.out.println(result);
		}
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

	
	
	abstract class aa{
		

	}
}
