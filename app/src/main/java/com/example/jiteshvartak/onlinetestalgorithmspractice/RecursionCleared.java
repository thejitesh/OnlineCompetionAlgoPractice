package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class RecursionCleared {

	public static void main(String[] d) {

		 char arrayStr[] = {'a', 'b', 'c', '\0'};
	        String strStr = "abc";
	        System.out.println( "Length of arrayStr " + arrayStr.length + " - Length of strStr " + strStr.length());
        System.out.println("-----");
		
		int arr[] = { 6, 6, 6 };

		int divisors[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			divisors[i] = getDivisors(arr[i]);
		}
		// list.clear();
		score(divisors, 0, divisors.length - 1, 0);
		// Collections.sort(list);
		System.out.println(maxScore + "");

	}

	public static int countSetBits(long number) {
		int count = 0;
		while (number > 0) {
			++count;
			number &= number - 1;
		}
		return count;
	}


	static int maxScore = 0;
	// static ArrayList<Integer> list = new ArrayList<>();

	static int score(int[] divisors, int si, int ei, int score) {

		if (si == ei) {
			return 0;
		}

		int li = si;
		int ri = ei;
		int lsum = divisors[li];
		int rsum = divisors[ri];

		for (int i = si; i <= ei; i++) {

			if (ri - li == 1) {
				if (lsum == rsum) {
					score++;
					score(divisors, si, li, score);// left
					score(divisors, ri, ei, score);// right

				}
				break;
			}

			if (lsum < rsum) {
				li++;
				lsum += divisors[li];
			} else {
				ri--;
				rsum += divisors[ri];
			}
		}

		maxScore = score > maxScore ? score : maxScore;
		return score;
	}

	static HashMap<Integer, Integer> hm = new HashMap<>();

	static int getDivisors(int num) {

		Integer intger = hm.get(num);
		if (intger != null) {
			return intger.intValue();
		}

		if (num == 0) {
			return 0;
		}
		int divisors = 0;

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				divisors++;
			}
		}

		hm.put(num, divisors);
		return divisors;
	}

	static long solve(int[] a) {
		long count = 0;
		for (int i = 0; i < a.length; i++) {

			count += Integer.bitCount(a[i]);

		}

		return (long) (count % (Math.pow(10, 10) + 11));

	}
}