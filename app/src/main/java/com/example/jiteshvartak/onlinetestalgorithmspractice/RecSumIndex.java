package com.example.jiteshvartak.onlinetestalgorithmspractice;

import java.util.*;

class RecSumIndex {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		for (int xx = 0; xx < q; xx++) {
			int n = in.nextInt();
			double a[] = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = Double.parseDouble(in.next());
			}

			println(calculate(a, 0, a.length - 1) + "");
		}

		in.close();
	}

	static int calculate(double[] a, int si, int ei) {

		if(si == ei){
			return 0;
		}
		
		
		for (int pointer = si; pointer <= ei; pointer++) {

			double leftSum = getSum(a, si, pointer);
			double rightSum = getSum(a, pointer + 1, ei);

			int retval = Double.compare(leftSum, rightSum);

			if (retval == 0) {
				return 1 + Math.max(calculate(a, si, pointer), calculate(a, pointer + 1, ei));
			}
		}

		return 0;
	}

	static double getSum(double[] a, int si, int ei) {
		double sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += a[i];
		}
		return sum;
	}

	static void print(String str) {
		System.out.print(str);
	}

	static void println(String str) {
		System.out.println(str);
	}

}
