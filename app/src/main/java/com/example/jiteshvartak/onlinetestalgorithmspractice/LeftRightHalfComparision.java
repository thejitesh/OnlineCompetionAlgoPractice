package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public class LeftRightHalfComparision {

	static int solve(int[] a) {

		int retValue = 0;
		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < a.length / 2; i++) {
			leftSum += a[i];
		}

		for (int i = a.length / 2; i < a.length; i++) {
			rightSum += a[i];
		}

		if (leftSum == rightSum) {
			retValue = 0;
		} else {
			if (leftSum < rightSum) {
				retValue = rightSum - leftSum;
			} else {
				retValue = leftSum - rightSum;
			}
		}
		return retValue;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int result = solve(a);
		System.out.println(result);
	}
}
