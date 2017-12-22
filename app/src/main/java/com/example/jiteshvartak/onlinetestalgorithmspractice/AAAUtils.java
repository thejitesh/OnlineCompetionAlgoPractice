package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.HashMap;

public class AAAUtils {

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

	public static void fracion(double x) {
		String a = "" + x;
		String spilts[] = a.split("\\."); // split using decimal
		int b = spilts[1].length(); // find the decimal length
		int denominator = (int) Math.pow(10, b); // calculate the denominator
		int numerator = (int) (x * denominator); // calculate the nerumrator Ex
		// 1.2*10 = 12
		int gcd = getGCD(numerator, denominator); // Find the greatest common
		// divisor bw them
		String fraction = "" + numerator / gcd + "/" + denominator / gcd;
		System.out.println(fraction);
	}

	public static int getGCD(int n1, int n2) {
		if (n2 == 0) {
			return n1;
		}
		return getGCD(n2, n1 % n2);
	}

	private static double[] array;
	private static double[] tempMergArr;
	private static int length;

	public static void sort_Merge(double inputArr[]) {
		array = inputArr;
		length = inputArr.length;
		tempMergArr = new double[length];
		doMergeSort(0, length - 1);
	}

	private static void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private static void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
}
